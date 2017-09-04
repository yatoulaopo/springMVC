package ssm.service;

import java.util.List;

import ssm.po.Orders;

public interface OrdersService {
	public List<Orders> findOrdersList()throws Exception;
}
