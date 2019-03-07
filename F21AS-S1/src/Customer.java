/**
* <h1>Customer Constructor Class</h1>
* Getters and Setters for customer class
* 
* @author  Calvin D'Souza
* @since   04-02-2019 
*/

public class Customer
{
	
	/**
	   * This method is used to add to get and set
	   * customer parameters
	   * @param customer_id this is the customer ID
	   * @param customer_name this is the customer Name
	   * @return customer ID this is the customer ID
	   * @return customer_name this is the customer Name
	   */
    
	private String customer_id;
    private String customer_name;

    public Customer(String customer_id,String name)
    { this.customer_id = customer_id;
      this.customer_name = name;}

    public String getCustomerid(){ return customer_id; }

    public String getCustomername() {return customer_name; }
    
    public void setCustomerid(String customer_iD)  { this.customer_id = customer_iD; }

    public void setCustomername(String customer_name) {this.customer_name = customer_name; }
}
