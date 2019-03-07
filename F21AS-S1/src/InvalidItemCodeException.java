import java.lang.Exception;
import java.lang.Throwable;

/**
* Creating an InvalidItemQuantityException as a customized exception
* 
* @author  MOIZ K DHANERAWALA
* @since   1-21-2019 
*/
public class InvalidItemCodeException extends Exception {


	private final String err;

	/**
	   * This method is used to setup the InvalidItemCodeException 
	   * @param err this is the exception error message
	   */
	public InvalidItemCodeException(String err) {
		super();
		this.err = err;
	}

	/**
	   * This method is used to setup the InvalidItemCodeException 
	   * @param message this is the exception error message
	   * @param err this is the throwable cause
	   * @param cause the specific case of the exception
	   */
	public InvalidItemCodeException(String message, Throwable cause, String err) {
		super(message, cause);
		this.err = err;
	}

	/**
	   * This method is used to setup the InvalidItemCodeException 
	   * @param message this is the passed no exception error message
	   * @param err this is the exception error message
	   */
	public InvalidItemCodeException(String message, String err) {
		super(message);
		this.err = err;
	}

	/**
	   * This method is used to setup the InvalidItemCodeException 
	   * @param cause this is the throwable cause
	   * @param err this is the exception error message
	   */
	public InvalidItemCodeException(Throwable cause, String err) {
		super(cause);
		this.err = err;
	}


	/**
	   * This method is used to get the error code 
	   */
	public String getCode() {
		return this.err;
	}
}
