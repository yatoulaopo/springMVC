package ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ssm.po.Orders;
import ssm.service.OrdersService;

/**
 * 对订单进行操作的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/orders")  //窄化请求映射
public class OrdersController {
	//注入service
	@Autowired
	private OrdersService ordersService;
	@RequestMapping(value="/queryOrdersList.action",method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView queryOrdersList() throws Exception {
		List<Orders> ordersList = ordersService.findOrdersList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("ordersList", ordersList);
		modelAndView.setViewName("orders/ordersList");
		return modelAndView;
	}
	
	
	
	
	
	public OrdersService getOrdersService() {
		return ordersService;
	}
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
}
