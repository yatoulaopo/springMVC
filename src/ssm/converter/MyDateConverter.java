package ssm.converter;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 自定义Converter,将前端页面的String类型的日期，转换为sql.date类型的日期格式
 * ----必须在springmvc.xml中配置转换器才能起作用
 * @author Administrator
 *
 */
public class MyDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String arg0) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = (Date) dateFormat.parse(arg0);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
