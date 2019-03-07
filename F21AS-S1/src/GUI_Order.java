import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
/**
 * GUI of the whole system
 * @author Shahra Jafar
 * @author Pradheepan Raghavan
 * @author Khaled 
 *
 */
public class GUI_Order extends JFrame {

	/** The main GUI plane */
	private JPanel contentPane; 		
	/** Text box to imput the total quantity*/
	private JTextField txtQuantity; 	
	/**  */
	public JTextArea textArea;			
	/** TextArea for displaying menu  */
	private JTextArea textArea_1;		
	/**  Menu Label*/
	private JLabel lblMenu;				
	/**  TextArea for displaying Bill*/
	public JTextArea textArea_2;		
	/**  Bill Lable*/
	private JLabel lblBill;					
	/** OrderList which contains all the orders of the current bill */
	private ArrayList<Order> orderList; 
	/** CostList which contains all the cost of each order in the current bill*/
	private ArrayList<Double> CostList;
	/** OrderID text box, which is automatically generated */
	private JTextField txtOrderID;		
	/** stNo to keep track of the number of items in the current order  */
	public int stNo =0;
	/**  TotatlSum of the orders in the current sessions*/
	public double totalSum = 0;
	/**  alt bool is use to lock the customerID after the first item is set in the bill*/
	boolean alt = true;
	/** Variables for Current Session summary */
	private int b2=0, f1=0, b1=0, f4=0, f3=0, f2=0, s1=0, s2=0, s3=0, s4=0;
	
	/**
	 * Pops a frame to display the summary of the current session and the total revenue of all orders
	 * @param Summary
	 * @return frame to display
	 * @throws InvalidItemQuantityException
	 */
	public JFrame summaryFrame(String Summary) throws InvalidItemQuantityException {
		
		JFrame summary = new JFrame("Summary Report");
		String S;
		summary.setLayout(new BoxLayout(summary.getContentPane(), BoxLayout.Y_AXIS));
	    summary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		summary.setSize(700, 700);
	    summary.setLocation(300,200);
	    textArea = new JTextArea(5, 20);
	    textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	    textArea.setEditable(false);
	    textArea.setBackground(Color.LIGHT_GRAY);
	    
	    S= "======================================\n"
	    		+"SUMMARY:\n"
	    		+ "======================================\n"
	    		+ "CURRENT SESSION\n"
	    		+"======================================\n"
	    		+"BEVE002 Coffee x "+b2+"\r\n" + 
	 	       "FOOD001 Vegetable Pizza x "+f1+ "\r\n"+
	 	       "BEVE001 Coke x "+b1+"\r\n" + 
	 	       "FOOD004 B.Chicken x "+f4+"\r\n" + 
	 	       "FOOD003 Burger x "+f3+"\r\n" + 
	 	       "FOOD002 Shawarma x "+f3+"\r\n"+
	 	       "SWEET01 Strawberry Cake x"+s1+"\r\n" +
	 	       "SWEET02 Cheese Cake x"+s2+"\r\n" +
	 	       "SWEET03 Chocolate Cake x"+s3+"\r\n" +
	 	       "SWEET04 Violate Cake x"+s4+"\r\n\n" +
	 	       "Total Income for this session = "+totalSum 
	 	       +"\n======================================\n"
	 	       +"REVENUE SUMMARY\n"
	 	      +"======================================\n";
	    
	    S= S+ Summary+"\n======================================";
	    textArea.append(S);
	    
	    writeSummary(S);
	    System.out.println(S);
	    summary.add(textArea);
	    summary.pack();
	    summary.setVisible(true);
	    
	    return summary;
	}
	/**
	 * Main GUI where all the orders are placed
	 * @param order contains the ordermanager which has read the file
	 */
	public GUI_Order(OrderManager order) {
		
		orderList = new ArrayList<Order>();
		CostList = new ArrayList<Double>();
		
		setTitle("Ordering System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1441, 1045);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblFoodId = new JLabel("Food ID");
		lblFoodId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFoodId.setBounds(733, 48, 94, 34);
		contentPane.add(lblFoodId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(842, 47, 174, 40);
		contentPane.add(comboBox);
		
        txtQuantity = new JTextField();
        txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtQuantity.setBounds(842, 103, 89, 40);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQuantity.setBounds(733, 98, 121, 43);
		contentPane.add(lblQuantity);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(429, 36, 215, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBoxCust = new JComboBox();
		comboBoxCust.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxCust.setBounds(29, 100, 156, 39);
		panel.add(comboBoxCust);
		
		JButton btnAddItem = new JButton("Add item");
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAddItem.setBounds(822, 170, 139, 43);
		contentPane.add(btnAddItem);
		btnAddItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			try {
					String orderID = txtOrderID.getText();
					System.out.println(orderID);
					String customerID = comboBoxCust.getSelectedItem().toString();
					String itemDetails = comboBox.getSelectedItem().toString();
					int itemQuantity = 0 ;
					//Checking if the textbox contains valid number for quantity
					try {
						itemQuantity = Integer.parseInt(txtQuantity.getText());
					}
					catch(Exception sd) {
						txtQuantity.setText("");
						throw new InvalidItemQuantityException("Quanitity should be a valid number");						
					}
					if (itemQuantity <=0 || itemQuantity >=50)
						throw new InvalidItemQuantityException("You can't order more then 50 item");
					//Displaying the bill headers
					String line = "________________________________________________________________";
					if (stNo==0  && alt == true){
						textArea_2.append("Order ID: "+orderID + "\t" + "Customer ID: "+customerID+"\n"+ "\n");
						textArea_2.append("No" +"      "+"Item-ID     "+"Item-Name     "+"Cost    "+"Quantity   "+"Sub-Total"+ "\n" + line + "\n" + "\n");
						comboBoxCust.setEnabled(false);
						alt = false;
						
					}
					//Adding the orders to the current list
					if(order.MenuList.containsKey(itemDetails)) {
						stNo++;
						Menu CurrentItem = order.MenufindByNo(itemDetails);
						Date date = new Date();
						String ItemID = CurrentItem.getItem_id();
						double rate=1;
						
						//Discount Methods based on the quantity of the item
						if(itemQuantity>= 10)
							rate = 0.75;
						else if(itemQuantity>= 5)
						rate = 0.8; 
						else if(itemQuantity>= 3)
							rate = 0.85;
						
						Order thisOrder = new Order("N",date,ItemID,itemQuantity,customerID,rate);
						//Calculating and adding the cost to the list
						double cost = rate * itemQuantity*CurrentItem.getItem_cost();
						CostList.add(cost);
						orderList.add(thisOrder);
						if(CurrentItem.getItem_category().equals("Food"))
							textArea_2.append(stNo + "\t" + ItemID + "\t" + "    " + CurrentItem.getItem_name() + "\t" + "  "+ CurrentItem.getItem_cost() + "\t" + "    " + itemQuantity +"\t"+ "     " +cost+ System.lineSeparator());	
						else
							textArea_2.append(stNo + "\t" + ItemID + "\t" + "    " + CurrentItem.getItem_name() + "     " + "\t" + "  "+ CurrentItem.getItem_cost() + "\t" + "    " + itemQuantity +"\t"+ "     " +cost+ System.lineSeparator());	
						
						
					}
			} 
			catch (InvalidItemQuantityException er) {					
				JOptionPane.showMessageDialog(null, er.getMessage(), "Error", JOptionPane.QUESTION_MESSAGE, null);
			}
		
			
		}});
		
		lblMenu = new JLabel("Menu");
		lblMenu.setBackground(Color.BLACK);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblMenu.setBounds(256, 250, 121, 39);
		contentPane.add(lblMenu);
		
		lblBill = new JLabel("Reciept");
		lblBill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblBill.setBounds(1111, 251, 144, 37);
		contentPane.add(lblBill);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnOrder.setBounds(751, 912, 139, 55);
		contentPane.add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			try {
					textArea_2.append("\n\n"+"TOTAL BILL"+"\n"+String.valueOf(getTotal())+"\n");
					textArea_2.append("=================================================================");
					textArea_2.append("\n");
					printBill2();
					String bill = "TOTAL BILL"+"\n"+String.valueOf(getTotal());
					setTotalSum(totalSum+getTotal());
					int orderID = Integer.parseInt(txtOrderID.getText());
					String FinalBillBox = "Your Final OrderID(s) are :"+System.lineSeparator();
					for(Order o:orderList) {
						order.addOrder(o.getItem_detail(), o.getItem_quantity(),o.getCustomer_detail(), "Orders.txt", o.getRate());
						FinalBillBox += "OR/ - "+orderID+ " - " + o.getItem_detail()+ System.lineSeparator();
						itemTotalQuantity(o.getItem_detail(),o.getItem_quantity());
						orderID++;
					}
					//FinalBill added and then shown in a message box as well
					FinalBillBox += System.lineSeparator() + bill;
					JOptionPane.showMessageDialog(null,FinalBillBox, "Total Bill", JOptionPane.QUESTION_MESSAGE, null);
					//Clearing and reseting the billing system for the new order
					textArea_2.setText("");
					stNo = 0;
					CostList = new ArrayList<Double>();
					orderList = new ArrayList<Order>();
					txtOrderID.setText(String.valueOf(order.readOrderCounter()+1));
					txtQuantity.setText("");
					alt = true;
					comboBoxCust.setEnabled(true);
			} 
			catch (Exception er) {					
				JOptionPane.showMessageDialog(null, "Problem Calculating Total", "Error", JOptionPane.QUESTION_MESSAGE, null);
			}
		}});
		
		JButton btnClose = new JButton("Exit Report");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnClose.setBounds(580, 912, 156, 55);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {

			//Close button action to write the report========================================
			public void actionPerformed(ActionEvent e) {try {
				summaryFrame(order.SummaryReport()).setVisible(true);
			} catch (InvalidItemQuantityException e1) {
				e1.printStackTrace();
			}}});
		
		order.readFile("Menu.csv");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 293, 702, 591);
		contentPane.add(scrollPane);
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea_1.setEditable(false);
		textArea_1.setBackground(Color.LIGHT_GRAY);
		textArea_1.append(order.menuSystem());
		
	
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(762, 293, 658, 588);
		contentPane.add(scrollPane_1);
		
		textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		textArea_2.setForeground(Color.BLACK);
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea_2.setEditable(false);
		textArea_2.setBackground(Color.WHITE);

		
		String finalOrder = "";
		finalOrder = String.valueOf(order.readOrderCounter()+1);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setBounds(60, 4, 94, 29);
		lblOrderId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblOrderId);
		
		txtOrderID = new JTextField();
		txtOrderID.setBounds(29, 35, 156, 26);
		panel.add(txtOrderID);
		txtOrderID.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtOrderID.setEnabled(false);
		txtOrderID.setColumns(10);
		txtOrderID.setHorizontalAlignment(JTextField.CENTER);
		txtOrderID.setText((finalOrder));
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setBounds(40, 70, 134, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel_1);
		
		JButton btnAddCust = new JButton("New Customer");
		btnAddCust.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddCust.setBounds(30,145, 156, 29);
		panel.add(btnAddCust);
		btnAddCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Customer guiCustomer;
				try {
					guiCustomer = new GUI_Customer(order, comboBoxCust);
					guiCustomer.setVisible(true);
				} catch (InvalidNameException e1) {

					e1.printStackTrace();
				}
			}
		});
		
		//Cancel or Exiting the application
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedOption = JOptionPane.showConfirmDialog(null, "Do you really want to exit the order?", "Choose", JOptionPane.YES_NO_OPTION); 
               if (selectedOption == JOptionPane.YES_OPTION) {
            	   System.exit(0);
               }
				

			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBounds(1281, 9, 139, 53);
		contentPane.add(button);
		
		//Clearing the Order
		JButton button2 = new JButton("Clear");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedOption = JOptionPane.showConfirmDialog(null, "Do you really want to Clear the order?", "Choose", JOptionPane.YES_NO_OPTION); 
               if (selectedOption == JOptionPane.YES_OPTION) {
            	   textArea_2.setText("");
					stNo = 0;
					CostList = new ArrayList<Double>();
					orderList = new ArrayList<Order>();
					txtOrderID.setText(String.valueOf(order.readOrderCounter()+1));
					txtQuantity.setText("");
					alt = true;
					comboBoxCust.setEnabled(true);
               }
				

			}
		});
		button2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button2.setBounds(1281, 150, 139, 53);
		contentPane.add(button2);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(417, 16, 616, 236);
		contentPane.add(panel_2);
		
		try {
			String[] ItemArray = order.ItemIDList.toArray(new String[order.ItemIDList.size()]);
			for (int i = 0; i < ItemArray.length; i++) {
				comboBox.addItem(ItemArray[i].toString());
				//comboBox.add(ItemArray[0].toString());
			}	
		}
		catch (NullPointerException npe) {
			System.out.println(npe);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		order.readFile("Customers.txt");
		
		try {
			String[] CustArray = order.CustIDlist.toArray(new String[order.CustIDlist.size()]);
			//JOptionPane.showMessageDialog(null, CustArray, "Display no of Customers", JOptionPane.QUESTION_MESSAGE, null);
			for (int i = 0; i < CustArray.length; i++) {
				comboBoxCust.addItem(CustArray[i].toString());
		}
		}
		catch (NullPointerException npe) {
			System.out.println(npe);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
	}
	/**
	 * Gets the total cost of the current order in #.## decimal format
	 * Adds the cost to the Total Sum of current session
	 * @return returns the cost of the order
	 */
	public double getTotal() {
		double sum = 0;
		for(double i:CostList)
			sum=sum+i;
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(sum));
	}
	/**
	 * sets the total sum
	 * @param totalSum
	 */
	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}
	/**
	 * gets the totalsum valuu
	 * @return
	 */
	public double getTotalSum() {
		return this.totalSum;
	}
	/**
	 * saves the bill to the bill.txt file
	 */
	public void printBill2() {
		 try {
				 File writeFile;
				 Writer writer = null;
	
				 writeFile = new File("bill.txt");
			   
			     writer = new BufferedWriter(new OutputStreamWriter(
			                new FileOutputStream(writeFile,true), "utf-8"));
			     textArea_2.write(writer);
			     writer.close();
		    } catch (FileNotFoundException fne) {
		    	System.out.println(fne.getMessage().toString());
		        // report
		    }
		 	catch (IOException ex) {
		 		System.out.println(ex.getMessage().toString());
		 	}
			finally {
			}
		
	}
	
	/**
	 * Calculates the frequency of the items based on the item id
	 * @param key the Item ID in that order
	 * @param quantity the Quantity in that order
	 */
		public void itemTotalQuantity(String key, int quantity) {
			
			switch (key) {
	        case "BEVE002":  b2=b2+quantity;
	                 break;
	        case "FOOD001":  f1=f1+quantity;
	                 break;
	        case "BEVE001":  b1=b1+quantity;
	                 break;
	        case "FOOD004":  f4=f4+quantity;
	                 break;
	        case "FOOD003":  f3=f3+quantity;
	                 break;
	        case "FOOD002":  f2=f2+quantity;
	                 break;
	        case "SWEET01":  s1=s1+quantity;
	       			 break;
	        case "SWEET02":  s2=s2+quantity;
				 break;
	        case "SWEET03":  s3=s3+quantity;
				 break;
	        case "SWEET04":  s4=s4+quantity;
				 break;
	       			 
	        default: 
	                 break;
			}
		}
	/**
	 * Writes the summary to the summary.txt file
	 * @param summary the Summary of the whole session and the revenue 
	 */
	private void writeSummary(String summary) {
		try {
			FileWriter OrderWriter = new FileWriter("Summary.txt");
			OrderWriter.write(summary);
			OrderWriter.close();
		}
		catch (FileNotFoundException e){
			System.out.println("file not found ");
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
