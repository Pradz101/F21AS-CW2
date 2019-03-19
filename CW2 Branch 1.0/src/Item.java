
public class Item {
	
	String item_id;
	String item_name;
	String item_description;
	double item_cost;
	String item_category;
	double item_time_cost;
	
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

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public double getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(double item_cost) {
		this.item_cost = item_cost;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public double getItem_time_cost() {
		return item_time_cost;
	}

	public void setItem_time_cost(double item_time_cost) {
		this.item_time_cost = item_time_cost;
	}
	
	

}
