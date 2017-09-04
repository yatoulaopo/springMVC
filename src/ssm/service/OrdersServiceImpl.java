package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.mapper.OrdersMapper;
import ssm.po.Orders;

public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	public OrdersMapper getOrdersMapper() {
		return ordersMapper;
	}
	public void setOrdersMapper(OrdersMapper ordersMapper) {
		this.ordersMapper = ordersMapper;
	}
	//查询所有订单
	public List<Orders> findOrdersList() throws Exception {
		List<Orders> ordersList = ordersMapper.findOrdersList();
		return ordersList;
		
	}

}
