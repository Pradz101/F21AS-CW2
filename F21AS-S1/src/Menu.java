/**
* <h1>Menu Constructor Class</h1>
* Getters and Setters for menu class
* 
* @author  Pradheepan Raghavan
* @since   31-01-2019 
*/

public class Menu {
	
	/**
	   * This method is used to add to get and set
	   * order parameters
	   * @param item_id this is the item ID
	   * @param item_name this is the item_name
	   * @param item_description this is the item description
	   * @param item_cost this is the item cost
	   * @param item_category this is the item category
	   * @return item_id this is the item ID
	   * @return item_name this is the item_name
	   * @return item_description this is the item description
	   * @return item_cost this is the item cost
	   * @return item_category this is the item category
	   */
	
	private String item_id;
	private String item_name;
	private String item_description;
	private double item_cost;
	private String item_category;
    

	public Menu(String item_id,String item_name,String item_description,double item_cost,String item_category) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_cost = item_cost;
		this.item_category = item_category;
	}	
	public String getItem_id() {return item_id;}
	public void setItem_id(String item_id) {this.item_id = item_id;}
	
	public String getItem_name() {return item_name;}
	public void setItem_name(String item_name) {this.item_name = item_name;}
	
	public String getItem_description() {return item_description;}
	public void setItem_description(String item_description) 
	{this.item_description = item_description;}
	
	public String getItem_category() {return item_category;}
	public void setItem_category(String item_category) {this.item_category = item_category;}
	
	public double getItem_cost() {return item_cost;}
	public void setItem_cost(double item_cost) {this.item_cost = item_cost;}
	
}
