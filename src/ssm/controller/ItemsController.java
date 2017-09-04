package ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ssm.po.Items;


/**
 * 采用<mvc:annotation-driven/>之后，Controller只要写普通类就可以了
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
	@RequestMapping(value="/queryItemsList.action",method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView queryItemsList()throws Exception {
		Items items = new Items();
		items.setName("茶杯");
		Items items1 = new Items();
		items1.setName("电视机");
		List<Items> list = new ArrayList<Items>();
		list.add(items);
		list.add(items1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
}
