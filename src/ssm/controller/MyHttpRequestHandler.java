package ssm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import ssm.po.Items;


/**
 * 适配器是：HttpRequestHandlerAdapter
 * @author Administrator
 *
 */
public class MyHttpRequestHandler implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Items items = new Items();
		items.setName("iphone5C");
		request.setAttribute("items1", items);
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
	}

}
