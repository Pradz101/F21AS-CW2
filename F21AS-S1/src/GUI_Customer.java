import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.border.LineBorder;

/**
* <h1>Add a New Customer</h1>
* The GUI_Customer class just lets addition of a
* new customer while on the Order GUI screen
* 
* @author  Moiz Dhanerawala
* @since   16-02-2019 
*/

public class GUI_Customer extends JFrame {
	
	/**
	   * This method is used to add a new Customer
	   * @param customerId this is the customer ID
	   * @param customerName this is the customer Name
	   * @throws InvalidNameException on invalid customer name
	   * @see InvalidNameException
	   * @return customer ID after addition
	   */

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtCustomerID;
	private JTextField txtCustomerName;

	public GUI_Customer(OrderManager order, JComboBox cBox) throws InvalidNameException{
		
		setTitle("Add Customer");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(true);
		setLocationRelativeTo(null);
		
		JButton btnAdd = new JButton("Add Customer");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(50, 300, 139, 55);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(txtCustomerName.getText().isEmpty()) {
					throw new InvalidNameException("Please fill in Customer Name");
				}
				else {
					printCustomer();
					order.writeCustomerCounter();
					JOptionPane.showMessageDialog(null, "Customer Added Successfully", "Success", JOptionPane.QUESTION_MESSAGE, null);
					String customerID = "C00";
					String counter = String.valueOf(order.readCustomerCounter()+1 ); 
					customerID = customerID + counter;
					String customerID2 = "C00" + String.valueOf(order.readCustomerCounter());
					txtCustomerID.setText(customerID);
					txtCustomerName.setText("");
					cBox.addItem(customerID2);
				}
			 
			}catch (InvalidNameException er) {
				JOptionPane.showMessageDialog(null,er.getMessage() , "Problem Adding Customer", JOptionPane.QUESTION_MESSAGE, null);
			}
		}});
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setBounds(300, 300, 139, 55);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();
			}
		});
		
			String customerID = "C00";
			String counter = String.valueOf(order.readCustomerCounter() + 1); 
			customerID = customerID + counter;
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(130, 100, 215, 162);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(60, 6, 94, 29);
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCustomerId);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setBounds(29, 40, 156, 26);
		panel.add(txtCustomerID);
		txtCustomerID.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCustomerID.setEnabled(false);
		txtCustomerID.setColumns(10);
		txtCustomerID.setHorizontalAlignment(JTextField.CENTER);
		txtCustomerID.setText((customerID));
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setBounds(60, 71, 134, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCustomerName.setBounds(29, 103, 156, 39);
		panel.add(txtCustomerName);
		txtCustomerName.setColumns(10);
	}
	
	public void printCustomer() {
		
		/**
		   * This method is used to print the Customer in the Customers.txt file
		   * @param customerId this is the customer ID
		   * @param customerName this is the customer Name
		   * @throws IOException on file not found error
		   * @see IOException
		   * @return Nothing
		  */
		
		 try {
				BufferedWriter out = new BufferedWriter(new FileWriter("Customers.txt", true)); 
	            String NewCust = txtCustomerID.getText() + "," + txtCustomerName.getText() + System.lineSeparator();
	            out.write(NewCust); 
	            out.close(); 
		    } catch (IOException ex) {
		    	System.out.println(ex);
		    } finally {
		
		    }
	}
	
	public void CloseJframe(){
		   /**
		   * This method is used to close the GUI on click
		   * @return Nothing
		   */
	    super.dispose();
	}
}
