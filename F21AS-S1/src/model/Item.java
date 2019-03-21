/**
* Item Constructor Class
* Getters and Setters for item class
* 
* @author  Pradheepan
* @since   10-03-2019 
*/

package model;

/**
 * This class is used to add to get and set
 * order parameters
*/

public class Item {	
	
	String item_id;
	String item_name;
	String item_description;
	double item_cost;
	String item_category;
	double item_time_cost;

	/**
	 * 
	 * @param item_id
	 * @param item_name
	 * @param item_description
	 * @param item_cost
	 * @param item_category
	 * @param item_time_cost
	 */
	public Item(String item_id, String item_name, String item_description, double item_cost, String item_category,
			double item_time_cost) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_cost = item_cost;
		this.item_category = item_category;
		this.item_time_cost = item_time_cost;
	}
	
	/**
	 * @return item_id
	 */

	public String getItem_id() {
		return item_id;
	}
	
	/**
	 * 
	 * @param item_id
	 */

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
	/**
	 * 
	 * @return item_name
	 */

	public String getItem_name() {
		return item_name;
	}
	
	/**
	 * 
	 * @param item_name
	 */

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	/**
	 * 
	 * @return item_description
	 */

	public String getItem_description() {
		return item_description;
	}
	
	/**
	 * 
	 * @param item_description
	 */

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	
	/**
	 * 
	 * @return item_cost
	 */

	public double getItem_cost() {
		return item_cost;
	}
	
	/**
	 * 
	 * @param item_cost
	 */

	public void setItem_cost(double item_cost) {
		this.item_cost = item_cost;
	}
	
	/**
	 * 
	 * @return item_category
	 */

	public String getItem_category() {
		return item_category;
	}
	
	/**
	 * 
	 * @param item_category
	 */

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	
	/**
	 * 
	 * @return item_cost
	 */

	public double getItem_time_cost() {
		return item_time_cost;
	}
	
	/**
	 * 
	 * @param item_time_cost
	 */
	

	public void setItem_time_cost(double item_time_cost) {
		this.item_time_cost = item_time_cost;
	}
	
	

}
