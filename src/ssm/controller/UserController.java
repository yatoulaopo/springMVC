package ssm.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.bean.PageBean;
import ssm.po.User;
import ssm.service.UserService;

/**
 * 测试所有springMVC框架的功能，查询所有用户，修改某个用户
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	//注入service
	@Autowired
	private UserService userService;
	//查询所有用户
	@RequestMapping("/queryUserList.action")
	public ModelAndView queryUserList()throws Exception{
		List<User> listUser = userService.queryALL();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listUser", listUser);
		modelAndView.setViewName("user/userList");
		return modelAndView;
	}
	//根据id查找一个user独享
	@RequestMapping("/findUserById.action")
	public ModelAndView findUserById(int id)throws Exception{
		User user = userService.findUserById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("user/userUpdate");
		return modelAndView;
	}
	
	//根据user对象（要有id值），去更新数据库中的数据
	@RequestMapping("/updateUser.action")
	public String updateUser(int id,User user)throws Exception{
		userService.updateUser(user, id);
		return "redirect:queryUserList.action";
	}
	
	//分页显示
	@RequestMapping("queryUserListPage")
	public ModelAndView queryUserListPage(int page)throws Exception{
		//page/totalCount/onePageCount/pageCount/userList/beginIndex;
		ModelAndView modelAndView = new ModelAndView();
		PageBean pageBean = new PageBean();
		int totalCount = userService.findUserCount();
		int onePageCount = 10;
		int pageCount = (totalCount+onePageCount-1)/onePageCount;
		int beginIndex = (page -1)*onePageCount;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("beginIndex",beginIndex);
		map.put("onePageCount",onePageCount);
		List<User> userList = userService.pageQueryUserList(map);
		pageBean.setBeginIndex(page-1);
		pageBean.setTotalCount(totalCount);
		pageBean.setOnePageCount(onePageCount);
		pageBean.setPageCount(pageCount);
		pageBean.setTotalCount(totalCount);
		pageBean.setUserList(userList);
		pageBean.setPage(page);
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("user/userListPage");
		return modelAndView;
	}
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
