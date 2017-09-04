package ssm.mapper;

import java.util.List;

import ssm.po.Orders;

public interface OrdersMapper {
	//查找数据库中所有订单
	public List<Orders> findOrdersList()throws Exception;
	
	//resultMap方式实现一对一：根据订单关联查询订单信息
	public List<Orders> selectByResultMap()throws Exception;
	
	//延迟加载，查询订单，延迟查询订单项信息
	public List<Orders> findOrdersLazyLoading()throws Exception;
}
