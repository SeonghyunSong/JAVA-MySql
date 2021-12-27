import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class computeryes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public computeryes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBD80\uD488\uC744 \uAC00\uC9C0\uACE0 \uC788\uC2B5\uB2C8\uB2E4");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		lblNewLabel.setBounds(100, 58, 311, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC774\uC804\uD398\uC774\uC9C0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computerSearch b = new computerSearch();
				b.setVisible(true);
			}
		});
		btnNewButton.setBounds(140, 142, 118, 34);
		contentPane.add(btnNewButton);
	}
}
