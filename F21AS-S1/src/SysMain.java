//V 2.0
public class SysMain {
	
	/**
	   * This is the main method which makes initiates the
	   * OrderManager and GUI_Order method.
	   * @param args Unused.
	   * @return Nothing.
	   */
	
	public static void main(String args[]) {  
		OrderManager L = new OrderManager();

//		GUI_Order guiOrder = new GUI_Order(L);
//
//		guiOrder.setVisible(true);
		L.readFile("Menu.csv");
		L.readFile("Customers.txt");
		L.readFile("Orders.txt");
		L.readingthreadsorder();

	}
}
