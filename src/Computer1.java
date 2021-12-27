import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Computer1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Computer1() {
		setTitle("Ω√¿€»≠∏È");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uCEF4\uD4E8\uD130 \uBD80\uD488 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 23));
		lblNewLabel.setBounds(69, 10, 353, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uBD80\uD488 \uAC1C\uC218 \uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computerRevise com = new computerRevise();
				com.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		btnNewButton.setBounds(224, 156, 167, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBD80\uD488 \uCD94\uAC00");
		btnNewButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computerAdd add = new computerAdd();
				add.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(25, 80, 167, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uBD80\uD488 \uC0AD\uC81C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computerdelete com = new computerdelete();
				com.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		btnNewButton_2.setBounds(25, 156, 167, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uBD80\uD488 \uBCF4\uC720\uC5EC\uBD80 \uAC80\uC0C9");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computerSearch com = new computerSearch();
				com.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		btnNewButton_3.setBounds(224, 80, 167, 44);
		contentPane.add(btnNewButton_3);
	}
}
