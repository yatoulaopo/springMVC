package ssm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.bean.PageBean;
import ssm.groups.ValidGroup1;
import ssm.groups.ValidGroup2;
import ssm.mapper.UserMapper;
import ssm.po.User;
import ssm.po.UserQueryVo;
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
	public String updateUser(int id,Model model,@Validated(value={ValidGroup1.class,ValidGroup2.class}) User user,BindingResult bindingResult)throws Exception{
		//先判断是否捕获到错误
		if(bindingResult.hasErrors()) {
			//代表有错误了
			List<ObjectError> errorList = bindingResult.getAllErrors();
			for (ObjectError objectError : errorList) {
				String errorMessage = objectError.getDefaultMessage();
				System.out.println(errorMessage);
			}
			model.addAttribute("errorList", errorList);
			return "user/error";
		}
		userService.updateUser(user, id);
		return "redirect:queryUserListPage.action?page=1";
	}
	
	//分页显示
	@RequestMapping("/queryUserListPage")
	public ModelAndView queryUserListPage(Integer page)throws Exception{
		//page/totalCount/onePageCount/pageCount/userList/beginIndex;
		ModelAndView modelAndView = new ModelAndView();
		PageBean pageBean = new PageBean();
		int totalCount = userService.findUserCount();
		int onePageCount = 15;
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
	
	//根据id的数组，批量删除一批用户
	@RequestMapping("/deleteUserByIdArray")
	public String deleteUserByIdArray(Integer[] listId)throws Exception{
		for (int i = 0; i < listId.length; i++) {
			userService.deleteById(listId[i]);
		}
		return "redirect:queryUserListPage.action?page=1";
	}
	
	//根据id，批量删除用户
	@RequestMapping("/deleteUserById")
	public String deleteUserById(Integer id)throws Exception{
		userService.deleteById(id);
		return "redirect:queryUserListPage.action?page=1";
	}
		
	//根据id批量查找用户，并跳转到批量用户的展示页面
	@RequestMapping("/updateByUserArray")
	public ModelAndView updateByUserArray(Integer[] listId)throws Exception{
		//根据id数组，查询出一个list<User>
		List<User> listUser = userService.findListUser(listId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listUser", listUser);
		modelAndView.setViewName("user/updateUserBatch");
		return modelAndView;
	}
	
	//批量更新用户
	@RequestMapping("/updateUserBatch.action")
	public String updateUserBatch(UserQueryVo userQueryVo)throws Exception{
		List<User> listUser = userQueryVo.getListUser();
		for (User user : listUser) {
			userService.updateUser(user, user.getId());
		}
		return "redirect:queryUserListPage.action?page=1";
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
