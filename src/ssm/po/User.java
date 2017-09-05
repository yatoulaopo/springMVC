package ssm.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ssm.groups.ValidGroup1;
import ssm.groups.ValidGroup2;

public class User implements Serializable{
	private Integer id;
	//校验器校验
	@Size(min=5,max=15,message="{user.username.size.error}",groups={ValidGroup1.class})
	private String username;
	private String city;
	@NotNull(message="{user.createTime.notNull.error}",groups= {ValidGroup2.class})
	private Date createTime;
	
	//springmvc的文件上传
	private String filename;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	private String country;
	//批量删除，根据List<id>
	private Integer[] ListId;
	
	public Integer[] getListId() {
		return ListId;
	}
	public void setListId(Integer[] listId) {
		ListId = listId;
	}
	//用于测试自定义转换器，把前端页面传过来的S天ring格式的字符串转换为User类的date格式的日期
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
