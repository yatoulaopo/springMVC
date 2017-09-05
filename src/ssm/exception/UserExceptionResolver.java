package ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义全局异常解析器：只要实现HandlerExceptionResolver就可以了
 * @author Administrator
 *
 */
public class UserExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		UserException userException = null;
		//判断异常是不是自定义异常
		if(ex instanceof UserException) {
			userException = (UserException) ex;
		}else {
			//如果产生的异常不是自定义的异常，则新建一个自定义异常，消息为“为之错误”
			userException = new UserException("未知错误！");
		}
		//产生异常之后，由全局异常解析器处理，并且跳转到error.jsp页面
		String message = userException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("user/error");
		return modelAndView;
	}

}
