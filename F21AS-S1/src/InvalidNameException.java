/**
* Creating an InvalidNameException as a customized exception
* 
* @author  Khaled AlSabahi
* @since   2-21-2019 
*/
public class InvalidNameException extends Exception{

	/**
	   * This method is used to setup the InvalidNameException 
	   * @param message this is the exception error message
	   */
	public InvalidNameException(String message) {
		super(message);
	}
}