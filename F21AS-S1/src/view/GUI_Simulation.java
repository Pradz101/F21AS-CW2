
package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import controller.Controller;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUI_Simulation extends JFrame {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();
	JTextArea textArea_2 = new JTextArea();
	JTextArea textArea_5 = new JTextArea();
	JTextArea textArea_6 = new JTextArea();
	private JTextField textField;
	
	String a;
	String b, c, d;
	String m;
	
	/**
	 * Launch the application.
	/**
	 * Create the frame.
	 * @param report 
	 */
	
	public String setTextA(){
	
		try {
		
		if(a.equals(Controller.getListOrdersA()))
			return "";
		
		a = Controller.getListOrdersA();
		return a; 
		
		
	}catch(NullPointerException e) {
		a = Controller.getListOrdersA();
		return a; 
	}}
		public String setTextB(){
			
			try {
				if(b.equals(Controller.getListOrdersB()))
					return "";
				
				b = Controller.getListOrdersB();
				return b;
				
			}catch(NullPointerException e) {
				b = Controller.getListOrdersB();
				return b;
			}}
		public String setTextC(){
			
			try {
			
			if(c.equals(Controller.getListOrdersC()))
				return "";
			
			c = Controller.getListOrdersC();
			return c; 
			
			
		}catch(NullPointerException e) {
			c = Controller.getListOrdersC();
			return c; 
		}}
		public String setTextD(){
			
			try {
			
			if(d.equals(Controller.getListOrdersD()))
				return "";
			
			d = Controller.getListOrdersA();
			return d; 
			
			
		}catch(NullPointerException e) {
			d = Controller.getListOrdersD();
			return d; 
		}}

	public String setTextMain(){
		
		try {
			if(m.equals(Controller.getMainListOrders()))
				return "";
			
			m = Controller.getMainListOrders();
			return m;
			
		}catch(NullPointerException e) {
			m = Controller.getMainListOrders();
			return m;
		}}

	public void updateCounter() {
	
		textArea_1.append(setTextA());
		textArea_2.append(setTextB());
		textArea_5.append(setTextC());
		textArea_6.append(setTextD());
		
		
	}

	public void updateQue() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		textArea.append(setTextMain()+" ---------------------------  "+ dtf.format(now)+"\n");
		
		
	}
	public GUI_Simulation(String aList, String bList, boolean g) {
		setTitle("Coffee Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1511, 838);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(523, 116, 455, 470);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(textArea);
		textArea.append(Controller.getMainListOrders());
		
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		textArea.setEditable(false);
		
		
		Controller c = new Controller();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		JButton btnOpenCoffeeShop = new JButton("Open Coffee Shop");
		btnOpenCoffeeShop.setBounds(652, 602, 202, 29);
		contentPane.add(btnOpenCoffeeShop);
		
		
		JLabel lblOrderQueue = new JLabel("Order Queue");
		lblOrderQueue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblOrderQueue.setBounds(670, 56, 184, 33);
		contentPane.add(lblOrderQueue);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(26, 116, 417, 190);
		contentPane.add(scrollPane_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(26, 404, 417, 182);
		contentPane.add(scrollPane_4);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(1058, 116, 407, 190);
		contentPane.add(scrollPane_7);
		
		/**JTextArea textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		scrollPane_7.setViewportView(textArea_5);**/
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(1058, 410, 407, 176);
		contentPane.add(scrollPane_8);
		
		/**JTextArea textArea_6 = new JTextArea();
		textArea_6.setEditable(false);
		scrollPane_8.setViewportView(textArea_6);**/
		
		DefaultCaret caret_1 = (DefaultCaret)textArea_1.getCaret();
		scrollPane_3.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		 caret_1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		
		DefaultCaret caret_2 = (DefaultCaret)textArea_2.getCaret();
		scrollPane_4.setViewportView(textArea_2);
		textArea_2.setEditable(false);
		caret_2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		DefaultCaret caret_3 = (DefaultCaret)textArea_5.getCaret();
		scrollPane_7.setViewportView(textArea_5);
		textArea_5.setEditable(false);
		caret_3.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		DefaultCaret caret_4 = (DefaultCaret)textArea_6.getCaret();
		scrollPane_8.setViewportView(textArea_6);
		textArea_6.setEditable(false);
		caret_4.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	
		
		JLabel lblWaiter = new JLabel("Waiter 1");
		lblWaiter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWaiter.setBounds(199, 78, 101, 22);
		contentPane.add(lblWaiter);
		
		JLabel lblWater = new JLabel("Waiter 2");
		lblWater.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWater.setBounds(179, 368, 101, 34);
		contentPane.add(lblWater);

		JLabel lblWaiter_1 = new JLabel("Waiter 3");
		lblWaiter_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWaiter_1.setBounds(1223, 74, 101, 31);
		contentPane.add(lblWaiter_1);
		
		JLabel lblWaiter_2 = new JLabel("Waiter 4");
		lblWaiter_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWaiter_2.setBounds(1223, 371, 101, 29);
		contentPane.add(lblWaiter_2);
		
		//--------------------------------------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^---------
		
		JLabel lblCurrentSpeed = new JLabel("Current Speed");
		lblCurrentSpeed.setBounds(570, 509, 107, 29);
		contentPane.add(lblCurrentSpeed);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(702, 726, 118, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSpeedUpSimulation = new JButton("Increase Simulation");
		btnSpeedUpSimulation.setEnabled(false);
		System.out.print(c.getG());
		if(g == true) {
			btnSpeedUpSimulation.setEnabled(true);
		}
			
		btnSpeedUpSimulation.setBounds(493, 723, 184, 43);
		contentPane.add(btnSpeedUpSimulation);
		
		
		JButton btnSlowSimulation = new JButton("Slow Simulation");
		btnSlowSimulation.setEnabled(false);
		if(g==true) {
			btnSlowSimulation.setEnabled(true);
		}
		
		btnSlowSimulation.setBounds(842, 723, 168, 43);
		contentPane.add(btnSlowSimulation);
		
		JButton btnCreateLog = new JButton("Create Log");
		btnCreateLog.setBounds(702, 647, 115, 29);
		contentPane.add(btnCreateLog);
		
	
		
		
			btnOpenCoffeeShop.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						textField.setText("2");
						Controller.start();
						setVisible(false);
						btnSpeedUpSimulation.setEnabled(true);
						
						
						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}});
			
			btnCreateLog.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					JFrame summary = new JFrame("Summary Report");
					String S;
					summary.getContentPane().setLayout((LayoutManager) new BoxLayout(summary.getContentPane(), BoxLayout.Y_AXIS));
				    summary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					summary.setSize(700, 800);
				    summary.setLocation(800,100);
				    
				    JTextArea textAreaLog = new JTextArea();
				    textAreaLog.setFont(new Font("Monospaced", Font.PLAIN, 20));
				    textAreaLog.setEditable(false);
				    textAreaLog.setBackground(Color.LIGHT_GRAY);
				    
				    JScrollPane scrollPane_9 = new JScrollPane();
					scrollPane_9.setBounds(26, 404, 417, 182);
					contentPane.add(scrollPane_9);
					scrollPane_9.setViewportView(textAreaLog);
				    
				    //----------------------------------------------------------------------------
				    S= c.bullLog(); 
				    
				    textAreaLog.append(S);
			
				    summary.getContentPane().add(scrollPane_9);
				
				    summary.setVisible(true);
				    
				    c.logtofile();
					
					}});
			
			btnSpeedUpSimulation.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					btnSlowSimulation.setEnabled(true);
					int speed;
					speed = c.getSpeed() +50 ;
					System.out.println(c.getSpeed());
					c.setSpeed(speed);
					setStimulateSpeed(speed);
					
				}});
			
			btnSlowSimulation.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int speed=1;
					if(c.getSpeed()>=4) {
					speed = c.getSpeed() -4 ;
					}
					else if(c.getSpeed()<4 && c.getSpeed()>1) {
						speed = c.getSpeed() -1 ;
						btnSlowSimulation.setEnabled(false);
					}
					else if(c.getSpeed()==1) {
						System.out.println("Minumum Smulation Speed Reached");
						btnSlowSimulation.setEnabled(false);
					}
					System.out.println(c.getSpeed());
					c.setSpeed(speed);
					setStimulateSpeed(speed);
					
				}});
		}
	
	
	
	public void setStimulateSpeed(int s) {
		this.textField.setText(""+s);
	}
}


