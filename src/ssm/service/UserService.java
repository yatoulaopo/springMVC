package ssm.service;

import java.util.HashMap;
import java.util.List;

import ssm.po.User;

public interface UserService {
	//查询所有用户
	public List<User> queryALL()throws Exception;
	//根据id查询一个User
	public User findUserById(int id)throws Exception;
	//根据user对象（要有id值），去更新数据库的update操作
	public void updateUser(User user,int id) throws Exception;
	//查询总记录数
	public int findUserCount()throws Exception;
	
	//分页查询：每一页的记录的List<User>
	public List<User> pageQueryUserList(HashMap<String,Integer> map)throws Exception;
}
