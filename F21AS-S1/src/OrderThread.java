
public class OrderThread implements Runnable{
	    private final Order O;
	    //Constructor to assign a message when creating a new thread
	    public OrderThread(Order O ){  
	        this.O=O; 
	    }
	    @Override
	    /**
	     *
	     */
	   public void run() {  
	        try
			{
				Thread.sleep(1000);
				workToBeDone();

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	    }  
	    private void workToBeDone()
		{
			System.out.println(Thread.currentThread().getName()+
					" (Start)  Order = " + O.getOrder_id() + " ");
			//call workToBeDone method to simulate a delay
			System.out.println(Thread.currentThread().getName()+
					" (End) Reading Order " + O.getOrder_id());//prints thread name
	    }  
}
