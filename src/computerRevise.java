import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class computerRevise extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtcname;
	static private JTextField txtcnumber;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	
	public computerRevise() {
		setTitle("��ǰ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBD80\uD488\uBA85");
		lblNewLabel.setFont(new Font("���� ���", Font.PLAIN, 15));
		lblNewLabel.setBounds(40, 61, 115, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC218\uB7C9");
		lblNewLabel_1.setFont(new Font("���� ���", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(40, 107, 115, 27);
		contentPane.add(lblNewLabel_1);
		
		txtcname = new JTextField();
		txtcname.setBounds(104, 67, 222, 21);
		contentPane.add(txtcname);
		txtcname.setColumns(10);
		
		txtcnumber = new JTextField();
		txtcnumber.setColumns(10);
		txtcnumber.setBounds(104, 113, 222, 21);
		contentPane.add(txtcnumber);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				try {
					query("update", "update computer set cnumber = '" + txtcnumber.getText() + "' where cname = '" + txtcname.getText() + "'");
					//viewData();
					System.out.println("�����ͺ��̽� �����Ϸ�");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dbDis();
			}
		});
		btnNewButton.setFont(new Font("���� ���", Font.PLAIN, 16));
		btnNewButton.setBounds(40, 171, 130, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC774\uC804\uD398\uC774\uC9C0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computer1 com = new Computer1();
				com.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("���� ���", Font.PLAIN, 15));
		btnNewButton_1.setBounds(196, 171, 130, 41);
		contentPane.add(btnNewButton_1);
	}
	public static void dbConnect() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("����̹� �˻� ����!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
        
    	
        url = "jdbc:odbc:computer"; //�������� (����)
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/computer";//�������� (����)
        String sql = "Select * From computer";//�������� (���̺��)
		try {
         
            conn = DriverManager.getConnection(url,"root","apmsetup");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("�����ͺ��̽� ���� ����!");            
         
        }
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����!");
        }
	}
	public static void query(String order, String sql) throws SQLException {
		if (order == "select") {
			rs = stmt.executeQuery(sql);
		} 
		else {
			stmt.executeUpdate(sql);
		}
	}
	public static void dbDis(){
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			System.out.println("�����ͺ��̽� ���� ����!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void viewData() throws SQLException {
		if(!rs.next()){
			System.out.println("!rs.next()");
			
		}
		else{		
				System.out.println("rs.next()");
				txtcname.setText(String.valueOf(rs.getString("cname")));
				txtcnumber.setText(String.valueOf(rs.getString("cnumber")));//��������
	
				
		}
	}

}
