package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Log.Log;
import model.Item;
import model.Order;
import model.OrderGenerator;
import view.Close;
import view.GUI_Simulation;

public class Controller implements Runnable {
	/** Lists to store the items and orders read from the orders.csv and items.csv */
	static HashMap<String,Item> itemList = new HashMap<String,Item>();
	static List<String> itemIDList;
	static List<Order> orderList= new ArrayList<Order>();
	static List<Order> mainOrderList= new ArrayList<Order>();
	
	static List<Order> orderListA= new ArrayList<Order>();
	static List<Order> orderListB= new ArrayList<Order>();
	static List<Order> orderListC= new ArrayList<Order>();
	static List<Order> orderListD= new ArrayList<Order>();
	
	boolean flag= true;
	boolean i = true;	
	private static int s = 1; // simulation speed variable
	static int oID = 0;
	static boolean ia =true, exit = false, th1= false, th2= false, th3= false, th4= false;
	
	Log log = new Log(orderList,orderListA,orderListB);
	boolean g = true;
	static GUI_Simulation gui = new GUI_Simulation(getListOrdersA(), getListOrdersB(), true);
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void run() {
		try {
			g = true;
			
			
			
			 if(i == true) {
				gui.setVisible(true);
				
				i = false;
				}
			
 /** Run thread for Counter 1 and get list of orders handled by Counter 1*/
			if(Thread.currentThread().getName().equals("Counter 1")) {
				
				{
					
				for(Order o:orderList) {
					
					if(o.getOrderIDno()%2 == 0) {
					orderListA.add(o);
					
					
					
					System.out.println(Thread.currentThread().getName());
					System.out.println(getListOrdersA());
					
					gui.validate();
					gui.repaint();
					Thread.sleep((long) o.getTotalTime(s));
					}
				}
				
				th1 = true;
				
				}
			}
			/** Run thread for Counter 2 and get list of orders handled by Counter 2*/
			else if(Thread.currentThread().getName().equals("Counter 2")) {
				
				for(Order o:orderList) {
					if(o.getOrderIDno()%2 == 1) {
					orderListB.add(o);
				
					Thread.sleep((long) o.getTotalTime(s));
					}
					th2 = true;
				}
				/**get the log*/
				bullLog();
			}//----------------------------------------------------------------vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv---------------------------
			/**Run thread for Counter 3 and get list of orders handled by order 3*/
			else if(Thread.currentThread().getName().equals("Counter 3")) {
					
					for(Order o:orderList) {
						if(o.getOrderIDno()%2 == 1) {
						orderListC.add(o);
					
						Thread.sleep((long) o.getTotalTime(s));
						}
					}
					th3 = true;
					
					}
			/** Run thread for Counter 4 and get list of orders handled by order 4*/
			else if(Thread.currentThread().getName().equals("Counter 4")) {
					
					for(Order o:orderList) {
						if(o.getOrderIDno()%2 == 1) {
						orderListD.add(o);
					
						Thread.sleep((long) o.getTotalTime(s));
						}
					}
					th4 = true;
					
					
				}
				//-----------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-------------------	
			/** Let the thread sleep for 1000 milliseconds*/
			Thread.sleep(1000);
			flag = true;
			}catch (InterruptedException e) {
			e.printStackTrace();
			}
			/** If all orders are processed by the threads,close the Coffee Shop GUI */
		if(th1 == true && th2 == true && th3 == true && th4 == true) {
		Close.Closing_GUI();
		
		th1 = false;
		}
	}
	
	

	
	public static void start() throws InterruptedException 
    {

    	/** Read data from Items.csv and Orders.csv file*/
        readFile("Items.csv");
        readFile("Orders.csv");

        /** Generate random orders and add to orderlist*/
        OrderGenerator oG = new OrderGenerator();
		for(int c = 10; c<70; c++) {
		orderList.add(oG.generateOrder(c));
		}
		
		
		/** Make 4 threads and set name of the threads*/
	 	Thread  t1 = new Thread(new Controller());
		Thread  t2 = new Thread(new Controller());
		Thread  t3 = new Thread(new Controller());
		Thread  t4 = new Thread(new Controller());
		
		t1.setName("Counter 1");
        t2.setName("Counter 2");
        t3.setName("Counter 3");
        t4.setName("Counter 4");
        
		/** Start the thread and make the thread sleep for 500 milliseconds,once the thread's job is done*/
	 	t1.start();
	 	Thread.sleep(500);
		t2.start();
		Thread.sleep(500);
		t3.start();
		Thread.sleep(500);
		t4.start();
		Thread.sleep(500);

		/** Appending orders to the waiters */
		Runnable workRunner = new Runnable() {
	        public void run() {
	            try {
	                while(true) {
	                   gui.updateCounter();
	                    Thread.sleep(1000/s);
	                }
	            } catch (InterruptedException e) {
	                //e.printStackTrace();
	            }
	        }
	    };
	    
	    new Thread(workRunner).start();

	    /** All orders are loaded into the GUI through the thread*/
	    Runnable que = new Runnable() {
	        public void run() {
	            try {
	                while(!exit) {
	                   for(Order o: orderList) {
	                	   mainOrderList.add(o);
	                   gui.updateQue();
	                   Random r = new Random();
	                    Thread.sleep((long) ((500 + (2000 - 500) * r.nextDouble())/s));
	                   }
	                   exit = true;
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    };
	    
	    new Thread(que).start();
    }

    /** Read the Items.csv and Orders.csv files*/
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

	/** Gather data from Items.csv file and add it to the itemList */
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
	/** Gather data from Orders.csv file and add it to the orderList */
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

	/** Get and set the simulation speed */
	public int getSpeed() { return s ; }
	public void setSpeed(int speed) { s = speed; }

	/** Get all orders */
	public static String getMainListOrders() {
		
		String report="";
			for(Order o:mainOrderList) {
			
					report = o.getOrderID(); 
			}
			
			return report;
			}

	/** Get all orders for orderListA */
	public static String getListOrdersA() {
		String report="";
		
		for(Order o:orderListA) {
		
			report = o.getOrderInformation();
	
		}
		return report;
	}
	/** Get all orders for orderListB */
	public static String getListOrdersB() {
		String report="";
		
		for(Order o:orderListB) {

			report = o.getOrderInformation();
	
		}
		return report;
	}
	/** Get all orders for orderListC */
	public static String getListOrdersC() {
		String report="";
		
		for(Order o:orderListC) { 

			report = o.getOrderInformation();
	
		}
		return report;
	}
	/** Get all orders for orderListD */
	public static String getListOrdersD() {
		String report="";
		
		for(Order o:orderListD) { 

			report = o.getOrderInformation();
	
		}
		return report;
	}

	/** Get all the log information */
	public String bullLog() {
		
		return log.getLog();
	}

	/** Returns the value of g */
	public boolean getG() {
		
		return g;
		
	}
	/**
	 * for removing the element
	 * @param o
	 */
	public synchronized void removeElement(Order o) {
		
		orderList.remove(o);
		
	}
	/**
	 * writing log to file
	 */
	public void logtofile() {
		log.logToFile();		
	}
	
}
