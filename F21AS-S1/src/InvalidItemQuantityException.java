import java.lang.Exception;
import java.lang.Throwable;

/**
* Creating an InvalidItemQuantityException as a customized exception
* 
* @author  Khaled AlSabahi
* @since   2-21-2019 
*/
public class InvalidItemQuantityException extends Exception {

	/**
	   * This method is used to setup the InvalidItemQuantityException 
	   * @param message this is the exception error message
	   */
	public InvalidItemQuantityException(String message) {
		super(message);
	}
}