package interfaces;

/**
 * 
 * @author Khaled
 * An Interface of a subject to manage the obsersers
 *
 */

public interface Subject {
	
	/**
	 * 
	 * @param obs
	 * to get the registered observer
	 */
	
	public void registerObserver(Observer obs);
	
	/**
	 * 
	 * @param obs
	 * to get the remove observer
	 */

	public void removeObserver(Observer obs);
	
	/**
	 * method to notify the observer
	 */
	public void notifyObservers();
}