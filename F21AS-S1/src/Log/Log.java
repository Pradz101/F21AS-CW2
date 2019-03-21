
package Log;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Order;

/**
 * Log class using singleton design pattern
 * 
 * @author Moiz
 * @since   16-03-2019
 *
 */

public class Log {
	
	/**
	 * declare reports as string
	 */
	
	private String reportA;
	private String reportB;
	
	/** Store list of orders */
	List<Order> orderList= new ArrayList<Order>();
	/** Store list of thread1 */
	static List<Order> orderListA= new ArrayList<Order>();
	/** Store list of thread2 */
	static List<Order> orderListB= new ArrayList<Order>();
	
	/**
	 * constructor class for order list, order thread 1 and order thread 2
	 * @param orderList
	 * @param orderListA
	 * @param orderListB
	 */
	public Log(List<Order> orderList, List<Order> orderListA, List<Order> orderListB) {
		
		this.orderList = orderList;
		this.orderListA = orderListA;
		this.orderListB = orderListB;
	}
	
	/**
	 * @return log
	 * returns the order information
	 */

	public String getLog() {
		
		
		String log="";
		
		for(Order o:orderList) {
			log += o.getOrderInformation();
		}
		
		System.out.println(log);
		
		return log;
	}
	
	/**
	 * 
	 * @return reportA
	 * returns the thread report A
	 */
	
	public String getReportA() {
		return reportA;
	}
	
	/**
	 * 
	 * @param reportA
	 * assign the thread report A
	 */
	public void setReportA(String reportA) {
		this.reportA = reportA;
	}
	
	/**
	 * 
	 * @return report B
	 * returns the thread report B
	 */
	public String getReportB() {
		return reportB;
	}
	
	/**
	 * 
	 * @param reportB
	 * assigns the thread report B
	 */
	public void setReportB(String reportB) {
		this.reportB = reportB;
	}
	
	/**
	 * 
	 * @return orderList
	 * returns the order list of all orders
	 */
	public List<Order> getMainOrderList() {
		return orderList;
	}
	
	/**
	 * 
	 * @param mainOrderList
	 * sets the order list of all orders
	 */
	public void setMainOrderList(List<Order> mainOrderList) {
		this.orderList = mainOrderList;
	}
	
	/**
	 * 
	 * @return orderListA
	 * returns the order list of thread 1
	 */
	public static List<Order> getOrderListA() {
		return orderListA;
	}
	
	/**
	 * 
	 * @param orderListA
	 * set the order list of thread 1
	 */
	public static void setOrderListA(List<Order> orderListA) {
		Log.orderListA = orderListA;
	}
	
	/**
	 * @return orderListB
	 * returns the order list of thread 2
	 */
	public static List<Order> getOrderListB() {
		return orderListB;
	}
	
	/**
	 * 
	 * @param orderListB
	 * sets the order list of thread 2
	 */
	public static void setOrderListB(List<Order> orderListB) {
		Log.orderListB = orderListB;
	}
	
	/**
	 * writes the log to file
	 */
	public void logToFile() {
		String logstring = getLog();
		try {
			FileWriter OrderWriter = new FileWriter("log.txt");
			OrderWriter.write(logstring);
			OrderWriter.close();
		}
	catch (FileNotFoundException e) {System.out.println("file not found ");}
	catch (IOException e) {e.printStackTrace();}
	}
	
}
