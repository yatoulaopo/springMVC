package ssm.bean;

import java.util.List;

import ssm.po.User;

public class PageBean {
	//总记录数
	private int totalCount;
	//每页显示几条记录
	private int onePageCount;
	//总共多少页
	private int pageCount;
	//当前页的记录
	private List<User> userList;
	//当前页
	private Integer page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	//当前页的起始序号
	private int beginIndex;
	private int endIndex;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getOnePageCount() {
		return onePageCount;
	}
	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
}
