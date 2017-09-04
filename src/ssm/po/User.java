package ssm.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	private Integer id;
	private String username;
	private String city;
	
	//批量删除，根据List<id>
	private Integer[] ListId;
	
	public Integer[] getListId() {
		return ListId;
	}
	public void setListId(Integer[] listId) {
		ListId = listId;
	}
	//用于测试自定义转换器，把前端页面传过来的S天ring格式的字符串转换为User类的date格式的日期
	private Date createTime;
	
	private String country;
	//多对多：根据用户信息，关联订单，关联订单项，关联商品
	private List<Orders> listOrders;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Orders> getListOrders() {
		return listOrders;
	}
	public void setListOrders(List<Orders> listOrders) {
		this.listOrders = listOrders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
