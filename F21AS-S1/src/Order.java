import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* <h1>Order Constructor Class</h1>
* Getters and Setters for order class
* 
* @author  Clavin D'Souza, Pradheep Raghavan
* @since   04-02-2019
*/

public class Order
{
	
	/**
	   * This method is used to add to get and set
	   * order parameters
	   * @param order_id this is the order ID
	   * @param order_timestamp this is the order timestamp
	   * @param item_detail this is the item details
	   * @param item_quantity this is the item quantity
	   * @param customer_detail this is the customer detail
	   * @param rate this is the rate
	   * @return order_id this is the order ID
	   * @return order_timestamp this is the order timestamp
	   * @return item_detail this is the item details
	   * @return item_quantity this is the item quantity
	   * @return customer_detail this is the customer detail
	   * @return rate this is the rate 
	   */
	
    private String order_id;
    private Date order_timestamp;
    private String item_detail;
    private int item_quantity;
    private String customer_detail;
    private double rate;


    public Order(String order_id,Date order_timestamp,String item_detail,int item_quantity,String customer_detail,double rate)
    {
        this.order_id = order_id;
    	this.order_timestamp = order_timestamp;
        this.item_detail = item_detail;
        this.item_quantity = item_quantity;
        this.customer_detail = customer_detail;
        this.rate = rate;
    }
    
    public String getOrder_id() {return order_id;}
    public void setOrder_id(String order_id) {this.order_id = order_id;}

    public Date getOrder_timestamp() {return order_timestamp; }
    public void setOrder_timestamp(Date order_timestamp) {this.order_timestamp = order_timestamp;}

    public String getItem_detail() {return item_detail; }
    public void setItem_detail(String item_detail) {this.item_detail = item_detail; }

    public int getItem_quantity() { ;
    	return item_quantity;  }
    public void setItem_quantity(int item_quantity){this.item_quantity = item_quantity;}

    public String getCustomer_detail() { return customer_detail; }
    public void setCustomer_detail(String customer_detail) {this.customer_detail = customer_detail;}
    
    public void setRate(double rate) {this.rate= rate; }
    public double getRate() {
		return rate;
	}		
}

