package ssm.exception;
/**
 * 预期异常：即自定义的异常
 * @author Administrator
 *
 */
public class UserException extends Exception{
	private String message;


	public UserException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
