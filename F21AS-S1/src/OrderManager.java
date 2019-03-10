import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Pradheepan Raghavan
 * @author Clavin D'souza
 * 
*/
public class OrderManager {
	/** Store list of foods,drinks */
	HashMap<String,Menu> MenuList;   
	/** Store list of current orders */
	ArrayList<Order> orderList;     
	/** List containing the ID of all food,drinks */
	List<String> ItemIDList;        
	/** Counts the number of orders made */
	int orderCt;                      
	/** Counts the number of customers */ 
	int custCt;                       
	/** List of all customer IDs */
	List<String> CustIDlist;          
	//change method name
	/**
	 * @return number of customers 
    */
	public int readCustomerCounter() {
		int Count = 1;
		try {
			File j = new File("CustCounter.txt");
			Scanner scanner = new Scanner(j);
			String InputLine = scanner.nextLine();
			Count = Integer.parseInt(InputLine);
			//System.out.println("This is the count" + Count);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not Found");
		}
		custCt = Count;
		return Count;
	}
	/**
	 * adds the current number of customers by 1
     */
	//change method name
	void writeCustomerCounter() {
			try {
				custCt++;
				FileWriter OrderWriter = new FileWriter("CustCounter.txt");
				OrderWriter.write(String.valueOf(custCt));
				OrderWriter.close();
			}
			catch (FileNotFoundException e){
				System.out.println("file not found ");
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	/**
	 * @return Customer ID
     */
	public String GenerateCustomerID()
	{
        writeCustomerCounter();
        return("C00"+custCt);    
	}
	
	/**
	 * Constructor used for the OrderManager class
     */
	public OrderManager()
	{
		MenuList =new HashMap<String,Menu>();
		orderList = new ArrayList<Order>();
		orderCt = readOrderCounter();
		ItemIDList = new ArrayList<String>();
		CustIDlist = new ArrayList<String>();
	}
	
	/**
	 * Scans the OrderCounter.txt file to find the number of orders made
	 * @return number of orders
     */
	public int readOrderCounter() {

		int Count = 1;
		try {
			File j = new File("OrderCounter.txt");
			Scanner scanner = new Scanner(j);
			String InputLine = scanner.nextLine();
			Count = Integer.parseInt(InputLine);
			//System.out.println("This is the count" + Count);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not Found");
		}
		return Count;
	}
	
	/**
	 * Writes the current number of orders to the OrderCounter.txt file
     */
	private void writeOrderCounter() {
		try {
			orderCt++;
			FileWriter OrderWriter = new FileWriter("OrderCounter.txt");
			OrderWriter.write(String.valueOf(orderCt));
			OrderWriter.close();
		}
		catch (FileNotFoundException e){
			System.out.println("file not found ");
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Find the food/drink in the Menulist using the menu ID
	 * @param id : The ID of the food or drink
	 * @return ID,name and cost of the food/drink
     */
	public String findByNo(String id) {
		try {
			if(MenuList.containsKey(id)) {
				Menu Found = MenuList.get(id);
				return(Found.getItem_id()+ "\t" + Found.getItem_name()+ "\t" +Found.getItem_cost());
			}
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage().toString());
		}
		return null;
	}
	
	/**
	 * Find out if the food/drink exists in the menu
	 * @param id : The ID of the food/drink
	 * @return the found Menu object
	 */
	public Menu MenufindByNo(String id) {
		try {
			if(MenuList.containsKey(id)) {
				Menu Found = MenuList.get(id);
				return Found;
			}
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage().toString());
		}
		return null;
	}
	/**
	 * Get all the contents of the menu
	 * @return String that contains the Menu items
     */
	public String Show_Menu()
	{
		String K = "";
		try {
			for(Map.Entry<String, Menu> M:MenuList.entrySet()){    	    
		        Menu b=M.getValue();  
		        K = K+ b.getItem_id()+","+b.getItem_name()+","+b.getItem_description()+","+b.getItem_category()+","+b.getItem_cost()+System.lineSeparator();   
		    }
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage().toString());
		}
		return K;
	}
	
	/**
	 * Get all the contents of the menu
	 * @return String that contains the Menu items
     */
	public String menuSystem()
	{
		String K = "";
		try {
			for(Map.Entry<String, Menu> M:MenuList.entrySet()){    	    
		        Menu b=M.getValue();  
		        K = K+b.getItem_id()+"  "+b.getItem_name()+"  "+b.getItem_description()+"  "+b.getItem_cost()+System.lineSeparator();   
		    }
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage().toString());
		}
		return K;
	}
	
//----------------------------------------------READ FILE----------------------------------	
	/**
	 * Reads the .csv and .txt files for the Orders,Customers,Menu
	 * @param file : The file that contains the data for the Orders,Customers,Menu
     */
	void readFile(String file)
	{
		try
		{
			File ja = new File(file);
			Scanner scanner = new Scanner(ja);
			while (scanner.hasNextLine())
			{
				String InputLine = scanner.nextLine();
				if(InputLine.length() != 0) {
					if(file.equals("Orders.txt"))
						ProcessLine_Order(InputLine);
					
					else if(file.equals("Menu.csv"))
						ProcessLine_Menu(InputLine);
					
					else if(file.equals("Customers.txt"))
						ProcessLine_Customer(InputLine);
				}
			}
		}catch (FileNotFoundException fnf){
			System.out.println( file + " not found ");
			System.exit(0);
		}
	}
	
	/**
	 * Parses the values,separated by commas,from the Orders file and stores them in the assigned variables.
	 * Then added as the values for the Order object through the Order constructor and added to the order list.
	 * @param Orders : The string that contain the list of orders from the Orders file
     */
	private void ProcessLine_Order(String Orders)
	{
		try {
			String parts[] = Orders.split(",");
			String order_id = parts[0];
			Date order_timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(parts[1]);
			String item_id = parts[2];
			int item_quantity = Integer.parseInt(parts[3]);
			String customer_id = parts[4];
			double rate = Double.parseDouble(parts[5]);
			Menu m = MenuList.get(item_id);
			Order o = new Order(order_id, order_timestamp, item_id, item_quantity, customer_id,rate);
			orderList.add(o);
		}
		catch (ParseException e)
		{
			String error = "Date conversion error in '" + Orders + "'  - "
					+ e.getMessage();
			System.out.println(error);
		}
	}
	
	/**
	 * Parses the values,separated by commas,from the Menu file and stores them in the assigned variables.
	 * Then added as the values for the Menu class through the Menu constructor and added to the menu list.
	 * @param inputLine : The string that contain the list of menus from the Menu file
     */
	private void ProcessLine_Menu(String inputLine) {
		try {
			String parts [] = inputLine.split(",");
			String item_id=parts[0];
			String item_name=parts[1];
			String item_description=parts[2];
			String item_category=parts[3];
			Double item_cost= Double.parseDouble(parts[4]);
			Menu c = new Menu(item_id,item_name,item_description,item_cost,item_category);
			MenuList.put(item_id,c);
			ItemIDList.add(item_id);
			}
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + inputLine + "'  - " 
			                  + nfe.getMessage();
			System.out.println(error);
		}
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in  : '" + inputLine
			                        + "' index position : " + air.getMessage();
			System.out.println(error);
		}		
	}
	
	/**
	 * Parses the values,separated by commas,from the Customer file and stores them in the assigned variables.
	 * Then added as the values for the Customer class through the Customer constructor
	 * @param inputLine : The string that contain the list of orders from the Orders file
     */
	public void ProcessLine_Customer(String inputLine) {
		try {
			String parts [] = inputLine.split(",");
			String customer_id=parts[0];
			String customer_name=parts[1];
			Customer c = new Customer(customer_id,customer_name);
			CustIDlist.add(customer_id);
			//System.out.println(customer_id+","+customer_name); 
		}
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + inputLine + "'  - " 
			                  + nfe.getMessage();
			System.out.println(error);
		}
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough lines in  : '" + inputLine
			                        + "' index position : " + air.getMessage();
			System.out.println(error);
		}		
	}
	
	/**
	 * Gets all values used for the Order object and create it,then add it to the Order list
	 * @param item_detail : The string that contain the item details
	 * @param item_quantity : The Integer that contain the quantity of the item ordered by the user
	 * @param customer_id : The string that contain the customer ID 
	 * @param OrderFile : The string that contain the list of orders from the Orders file
	 * @param rate : The price of the item
     */
	public void addOrder(String item_detail,int item_quantity,String customer_id,String OrderFile,double rate) {
		try
		{
			String order_id=GenerateOrderID();
			Date order_timestamp = new Date();
			Order o = new Order(order_id,order_timestamp,item_detail,item_quantity,customer_id,rate);
			orderList.add(o);
			add_Order_to_file(order_id,order_timestamp,item_detail,item_quantity,customer_id,OrderFile,rate);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Adds all the list of orders to the Orders.txt file
	 * @param order_id : The string that contain the ID of the order made
	 * @param order_timestamp : The Date and time the order was created
	 * @param item_detail : The string that contain the item details
	 * @param item_quantity : The Integer that contain the quantity of the item ordered by the user
	 * @param customer_id : The string that contain the customer ID 
	 * @param Orderfile : The string that contain the list of orders from the Orders file
	 * @param rate : The price of the item
     */
	private void add_Order_to_file(String order_id,Date order_timestamp,String item_detail,int item_quantity,String customer_id,String Orderfile,double rate) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(Orderfile, true));
			String NewOrder = String.valueOf(order_id) + "," + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(order_timestamp)+"," + item_detail + "," + item_quantity + ","  +customer_id+","+rate+System.lineSeparator();
			out.write(NewOrder);
			out.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Generates the order ID from the order count and date
	 * @return Order ID string
	 */
	public String GenerateOrderID()
	{
    	Date date = new Date();
    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
        writeOrderCounter();
        return("OR-"+strDate+"/"+orderCt);
        
	}
	/**
	 * Removes one of the orders and edits,write to the order file
	 * @param Rtem
	 * @param OrderFile
	 */
	public void removeOrder(int Rtem,String OrderFile) throws InvalidItemCodeException
	{
		try {
			orderList.remove(Rtem);
			WriteOrderToFile(OrderFile);
		}
		catch (IllegalArgumentException e) {
			System.out.println(Rtem+" is not in the OrderList, \nPlease check again");
		}	
	}
	
	/**
	 * Show the current order data from the order lists,ordered by the customer
	 * @return String that contains the orders
	 */
	public String showOrder()
	{
		String k = "";
		for (Order o :orderList)
		{
			Menu m = MenuList.get(o.getItem_detail());
			String c = o.getCustomer_detail();
			k = k + String.valueOf(o.getOrder_id()) + "," + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(o.getOrder_timestamp()) + "," + m.getItem_id() + "," + o.getItem_quantity() + "," + c + "\n";
		}
		return k;
	}
	
	/**
	 * Writes the list of orders in the order list to the Orders.txt
	 * @param OrderFile : String containing the current orders
	 */
	private void WriteOrderToFile(String OrderFile) {
		FileWriter ReportWrite;
		try {
			ReportWrite = new FileWriter(OrderFile);
			ReportWrite.write(showOrder());
			ReportWrite.close();
		}
		catch (FileNotFoundException e){
			System.out.println(OrderFile + " not found ");
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Displays the orders the customer made,the items purchased and their price and the total price of the items
	 */
	void displayBill()
	{
		String B = null;
		double total = 0;
		for(Order o : orderList)
		{
			Menu m = MenuList.get(o.getItem_detail());
			String C =  o.getCustomer_detail();
			total = m.getItem_cost() * o.getItem_quantity();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Order ID " + " | Order Timestamp " + " | Customer ID " + " | Item ID " +  " | Item Name " + " | Item quantity " + " | Item unitprice " + " | Item total ");
			B = String.valueOf(o.getOrder_id()) + " | " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(o.getOrder_timestamp())  + " | " + C +  " | " + m.getItem_id() +  " | " + m.getItem_name() + " | " + o.getItem_quantity() +  " | " + m.getItem_cost() +   " | " + total;
			System.out.println(B);
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}
	
	/**
	 * Prints a summary report of all the items orders and their total amount before the app closes
	 * @return Summary : Summary report of all items ordered and their quantity
	 */
	public String SummaryReport() {
		HashMap<String,Integer> MenuS = new HashMap<String,Integer>(); ;
		Double TotalRevenue = 0.0;
		for(String ItemID:ItemIDList) {
			MenuS.put(ItemID, 0);
		}
		for(Order o:orderList) {
			String CurrentOrderItemID = o.getItem_detail(); 
			int k = MenuS.get(CurrentOrderItemID) + o.getItem_quantity();
			MenuS.put(CurrentOrderItemID, k);
			Double CurrentOrderCost = o.getItem_quantity()*o.getRate()*MenuList.get(CurrentOrderItemID).getItem_cost();
			TotalRevenue= TotalRevenue + CurrentOrderCost;
			//System.out.println(TotalRevenue + " " + o.getItem_quantity()+ " " +o.getRate()+ " " +MenuList.get(CurrentOrderItemID).getItem_cost() + " " + CurrentOrderCost + " ");
		}
		String Summary = "SUMMARY:" + System.lineSeparator() + System.lineSeparator() ; 
		try {
			for(Map.Entry<String, Integer> M:MenuS.entrySet()){    	    
		        Summary = Summary + M.getKey() +"  "+ MenuList.get(M.getKey()).getItem_name() + " x " + M.getValue() + System.lineSeparator();
		    }
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage().toString());
		}

		DecimalFormat df = new DecimalFormat("#.##");
		TotalRevenue=  Double.parseDouble(df.format(TotalRevenue));
		Summary = Summary + System.lineSeparator() + "Total Revenue = " + TotalRevenue + " AED";
		return Summary;
	}	
	
	public void readingthreadsorder() {
		ExecutorService executor = Executors.newFixedThreadPool(20);
        for (Order CurrentOrder:orderList)// reading each orders 
        {  
           // Runnable worker = new OrderThread(CurrentOrder);
            Runnable server = new ServerThread(orderList);
            //calling execute method of ExecutorService
            //executor.execute(worker);
            executor.execute(server);
          }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
  
        System.out.println("Finished reading all orders");  
	}
}