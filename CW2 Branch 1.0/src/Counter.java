import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Counter implements Runnable {
	
	static HashMap<String,Item> itemList = new HashMap<String,Item>();
	static List<String> itemIDList;
	static List<Order> orderList= new ArrayList<Order>();
	static List<Order> mainOrderList= new ArrayList<Order>();
	
	static List<Order> orderListA= new ArrayList<Order>();
	static List<Order> orderListB= new ArrayList<Order>();
	
	static String report;
	
	private int s = 1; // simulation speed variable
	
	Log log = new Log(orderList,orderListA,orderListB);
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void run() {
		try {
			
			
			
			if(Thread.currentThread().getName().equals("Counter 1")) {
				
				for(Order o:orderList) {
					if(o.getOrderIDno()%2 == 0) {
					orderListA.add(o);
					GUI_Simulation gui = new GUI_Simulation(getListOrdersA(), getListOrdersB());
					System.out.println(Thread.currentThread().getName());
					System.out.println(getListOrdersA());
					
					Thread.sleep((long) o.getTotalTime(s));
					}
				}
				
				
				
			}
			else if(Thread.currentThread().getName().equals("Counter 2")) {
				
				for(Order o:orderList) {
					if(o.getOrderIDno()%2 == 1) {
					orderListB.add(o);
					GUI_Simulation gui = new GUI_Simulation(getListOrdersA(), getListOrdersB());
					System.out.println(Thread.currentThread().getName());
					System.out.println(getListOrdersB());
				
					Thread.sleep((long) o.getTotalTime(s));
					}
				}
				
				bullLog();
			}
				else if(Thread.currentThread().getName().equals("Counter 3")) {
					
					
					}
					
					
			Thread.sleep(1000);
			}catch (InterruptedException e) {
			e.printStackTrace();
			}}
	
	public static void main(String[] args) throws InterruptedException 
    { 
		System.out.println("Welcom to Kingdoms Coffe shop\n-----------------------------\n");
		
		
		
        readFile("Items.csv");
        readFile("Orders.csv");
	
        OrderGenerator oG = new OrderGenerator();
		for(int c = 10; c<17; c++) {
		orderList.add(oG.generateOrder(c));
		}
		
		
		GUI_Simulation gui = new GUI_Simulation("", "");
		gui.setVisible(true);
	 	Thread  t1 = new Thread(new Counter());
		Thread  t2 = new Thread(new Counter());
		Thread  t3 = new Thread(new Counter());
		
		t1.setName("Counter 1");    
        t2.setName("Counter 2");
        t3.setName("Counter 3");
		
	 	t1.start();
	 	Thread.sleep(500);
		t2.start();
		Thread.sleep(500);
		t3.start();
		Thread.sleep(500);

		
		
    }
	
	public static void readFile(String file) throws InterruptedException
	{
		try
		{
			File ja = new File(file);
			Scanner scanner = new Scanner(ja);
			while (scanner.hasNextLine())
			{
				String InputLine = scanner.nextLine();
				if(InputLine.length() != 0) {
					
					if(file.equals("Orders.csv"))
						processLineOrders(InputLine);
					}
					else if(file.equals("Items.csv"))
					processLineItems(InputLine);
				
			}
		}catch (FileNotFoundException fnf){
			System.out.println( file + " not found ");
			System.exit(0);
		}
	}
	
	private static void processLineItems(String inputLine) {
		try {
			String parts [] = inputLine.split(",");
			String item_id=parts[0];
			String item_name=parts[1];
			String item_description=parts[2];
			String item_category=parts[3];
			Double item_cost= Double.parseDouble(parts[4]);
			Double item_time_cost= Double.parseDouble(parts[4]);
			Item i = new Item(item_id,item_name,item_description,item_cost,item_category, item_time_cost);
			itemList.put(item_id,i);
			}
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + inputLine + "'  - " + nfe.getMessage();
			System.out.println(error);
		}
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in  : '" + inputLine
			                        + "' index position : " + air.getMessage();
			System.out.println(error);
		}	
		
	}
	
	private static void processLineOrders(String inputLine) throws InterruptedException {
		try {
			String parts [] = inputLine.split(",");
			
			String order_id=parts[0];
			
			String item_id1=parts[1];
			String item_id2=parts[2];
			String item_id3=parts[3];
			String item_id4=parts[4];
			
			int item_quantity1=Integer.parseInt(parts[5]);
			int item_quantity2=Integer.parseInt(parts[6]);
			int item_quantity3=Integer.parseInt(parts[7]);
			int item_quantity4=Integer.parseInt(parts[8]);
			
			double totalCost=Double.valueOf(parts[9]);
			
			double totalTime= Double.parseDouble(parts[10]);
			
			Order o = new Order(order_id,item_id1, item_id2, item_id3, item_id4,item_quantity1,item_quantity2,item_quantity3,item_quantity4,totalTime, totalCost);
			orderList.add(o);
			}
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + inputLine + "'  - " + nfe.getMessage();
			System.out.println(error);
		}
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in  : '" + inputLine
			                        + "' index position : " + air.getMessage();
			System.out.println(error);
		}	
		
		
	}
	public int getSpeed() { return s ; }
	public void setSpeed(int speed) { s = speed; }
	
	public static String getMainListOrders() {
		String report="";
		
		for(Order o:orderList) {

			report += o.getOrderID()+ "\n";
	
		}
		return report;
	}
	
	public static String getListOrdersA() {
		String report="";
		
		for(Order o:orderListA) {

			report += o.getOrderID()+ "\n";
	
		}
		return report;
	}
	
	public static String getListOrdersB() {
		String report="";
		
		for(Order o:orderListB) {

			report += o.getOrderID()+ "\n";
	
		}
		return report;
	}
	
	public String bullLog() {
		
		return log.getLog();
	}

	public static synchronized void count() {
		
		for (int i=1; i<=3;i++) {
			//System.out.println("Thread ("+Thread.currentThread().getId()+") = "+i);
		}
		
	}
}
