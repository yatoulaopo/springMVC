package ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ssm.po.Items;

/**
 * 适配器是SimpleControllerHandlerAdapter
 * @author Administrator
 *
 */
public class MyController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Items items = new Items();
		items.setName("新疆特产红枣");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items0", items);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}

}
