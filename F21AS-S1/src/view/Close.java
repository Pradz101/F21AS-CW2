package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Close extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Closing_GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Close frame = new Close();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Close() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 50, 426, 84);
		contentPane.add(scrollPane);
		
		JTextArea txtrCoffeeShopIs = new JTextArea();
		scrollPane.setViewportView(txtrCoffeeShopIs);
		txtrCoffeeShopIs.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		txtrCoffeeShopIs.setEditable(false);
		txtrCoffeeShopIs.setText("Coffee Shop is Closed! Come back later! :)");
		
		JButton btnThankYou = new JButton("Thank You");
		btnThankYou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThankYou.setBounds(232, 177, 115, 29);
		contentPane.add(btnThankYou);
	}
}