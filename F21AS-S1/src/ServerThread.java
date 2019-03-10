import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ServerThread implements Runnable{
	ArrayList<Order> orderList;
	String k = "";
	String a = "";
	
	public ServerThread(ArrayList<Order> O)
	{
		orderList = O;
	}
	
	@Override
	/**
	 * This method is called when the thread is started.
	 */
	public void run() {
			try {
				for (Order O : orderList)
				{
					 int i=1;
					 System.out.println(Thread.currentThread().getName() + "\n" + 
				                "Processing " + O.getCustomer_detail() + " Order #: " + O.getOrder_id());
							//Menu m = MenuList.get(o.getItem_detail());

						k = k + O.getItem_detail() + "," + O.getItem_quantity() + "\n";
					}
								System.out.println(k);
					//call workToBeDone method to simulate a delay
					 workToBeDone();
			}
			catch (Exception e) {
				System.out.println("Order exc" + e.getStackTrace());
			}
	}
	
    private void workToBeDone() {  
        try {  
        		 Thread.sleep(1000); 
        	}
        catch (InterruptedException e) 
        { e.printStackTrace(); }  
    }  
}
