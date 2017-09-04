package ssm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.mapper.UserMapper;
import ssm.po.User;

public class UserServiceImpl implements UserService {
	//注入dao
	@Autowired
	private UserMapper userMapper;
	//查询所有用户
	public List<User> queryALL() throws Exception {
		 return userMapper.findAllUser();
	}
	//根据id查询一个user对象
	@Override
	public User findUserById(int id) throws Exception {
		return userMapper.findUserById(id);
	}
	
	@Override
	public void updateUser(User user, int id) throws Exception {
		user.setId(id);
		userMapper.updateById(user);
	}
	
		
		
		
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	//查询记录总数
	public int findUserCount() throws Exception {
		int count = userMapper.findUserCount();
		return count;
	}
	//分页查询----每一页的记录的List<User>
	public List<User> pageQueryUserList(HashMap<String, Integer> map) throws Exception {
		List<User> userList = userMapper.pageQueryUserList(map);
		return userList;
	}
	
	//根据id删除一个用户
	public void deleteById(Integer integer){
		try {
			userMapper.deleteUserById(integer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}





	

}
