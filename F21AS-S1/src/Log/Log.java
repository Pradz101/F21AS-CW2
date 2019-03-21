package Log;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class Log {
	
	private String reportA;
	private String reportB;
	
	List<Order> orderList= new ArrayList<Order>();
	
	static List<Order> orderListA= new ArrayList<Order>();
	static List<Order> orderListB= new ArrayList<Order>();
	
	
	public Log(List<Order> orderList, List<Order> orderListA, List<Order> orderListB) {
		
		this.orderList = orderList;
		this.orderListA = orderListA;
		this.orderListB = orderListB;
	}


	public String getLog() {
		
		
		String log="";
		
		for(Order o:orderList) {
			log += o.getOrderInformation();
		}
		
		System.out.println(log);
		
		return log;
		
		
	}
	
	public String getReportA() {
		return reportA;
	}


	public void setReportA(String reportA) {
		this.reportA = reportA;
	}


	public String getReportB() {
		return reportB;
	}


	public void setReportB(String reportB) {
		this.reportB = reportB;
	}


	public List<Order> getMainOrderList() {
		return orderList;
	}


	public void setMainOrderList(List<Order> mainOrderList) {
		this.orderList = mainOrderList;
	}


	public static List<Order> getOrderListA() {
		return orderListA;
	}


	public static void setOrderListA(List<Order> orderListA) {
		Log.orderListA = orderListA;
	}


	public static List<Order> getOrderListB() {
		return orderListB;
	}


	public static void setOrderListB(List<Order> orderListB) {
		Log.orderListB = orderListB;
	}
	
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
