

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Simulation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	/**
	 * Create the frame.
	 * @param report 
	 */
	
	public String setTextA(){
		
		return Counter.getListOrdersA(); 
		//iot8Counter.getListOrdersB();
		
	}
public String setTextB(){
		
		return "Yo"; 
		//iot8Counter.getListOrdersB();
		
	}
	public GUI_Simulation(String aList, String bList) {
		setTitle("Coffee Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 340, 313, -193);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 71, 457, 420);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		Counter c = new Counter();
		textArea.append(Counter.getMainListOrders());
		textArea.setEditable(false);
		
		scrollPane_1.setViewportView(textArea);
		
		JButton btnOpenCoffeeShop = new JButton("Open Coffee Shop");
		btnOpenCoffeeShop.setBounds(138, 505, 202, 29);
		contentPane.add(btnOpenCoffeeShop);
		
		
		
		JLabel lblOrderQueue = new JLabel("Order Queue");
		lblOrderQueue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblOrderQueue.setBounds(138, 32, 184, 33);
		contentPane.add(lblOrderQueue);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(498, 327, 417, -205);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(498, 71, 417, 190);
		contentPane.add(scrollPane_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_3.setViewportView(textArea_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(498, 309, 417, 182);
		contentPane.add(scrollPane_4);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		scrollPane_4.setViewportView(textArea_2);
		
		
		
		
		
		JLabel lblWaiter = new JLabel("Waiter 1");
		lblWaiter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWaiter.setBounds(684, 43, 101, 22);
		contentPane.add(lblWaiter);
		
		JLabel lblWater = new JLabel("Waiter 2");
		lblWater.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWater.setBounds(684, 277, 101, 34);
		contentPane.add(lblWater);
		
		JButton btnSpeedUpSimulation = new JButton("Increase Simulation");
		btnSpeedUpSimulation.setBounds(529, 524, 184, 43);
		contentPane.add(btnSpeedUpSimulation);
		
		JButton btnSlowSimulation = new JButton("Slow Simulation");
		btnSlowSimulation.setBounds(728, 524, 168, 43);
		contentPane.add(btnSlowSimulation);
		
		JButton btnCreateLog = new JButton("Create Log");
		btnCreateLog.setBounds(182, 554, 115, 29);
		contentPane.add(btnCreateLog);
		
		
			textArea_2.append(bList);
			textArea_1.append(aList);
			
			btnOpenCoffeeShop.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					textArea.append("Ok\n");
					
				}});
			
			btnCreateLog.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					JFrame summary = new JFrame("Summary Report");
					String S;
					summary.getContentPane().setLayout((LayoutManager) new BoxLayout(summary.getContentPane(), BoxLayout.Y_AXIS));
				    summary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					summary.setSize(700, 800);
				    summary.setLocation(800,100);
				    JTextArea textAreaLog = new JTextArea(500, 200);
				    textAreaLog.setFont(new Font("Monospaced", Font.PLAIN, 20));
				    textAreaLog.setEditable(false);
				    textAreaLog.setBackground(Color.LIGHT_GRAY);
				    
				    //----------------------------------------------------------------------------
				    S= c.bullLog(); 
				    
				    textArea.append(S);
			
				    summary.getContentPane().add(textArea);
				
				    summary.setVisible(true);
				    
					
					}});
			
			btnSpeedUpSimulation.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int speed;
					speed = c.getSpeed() +50 ;
					System.out.println(c.getSpeed());
					c.setSpeed(speed);
					
				}});
			
			btnSlowSimulation.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int speed=1;
					if(c.getSpeed()>=4) {
					speed = c.getSpeed() -4 ;
					}
					else if(c.getSpeed()<4 && c.getSpeed()>1) {
						speed = c.getSpeed() -1 ;
					}
					else if(c.getSpeed()==1) {
						System.out.println("Minumum Smulation Speed Reached");
					}
					System.out.println(c.getSpeed());
					c.setSpeed(speed);
					
				}});
		}
		
}

