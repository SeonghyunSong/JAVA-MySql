import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class computerAdd extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtcname;
	static private JTextField txtctype;
	static private JTextField txtcprice;
	static private JTextField txtcnumber;
	static private JButton btnNewButton;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public computerAdd() {
		setTitle("��ǰ�߰�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcname = new JTextField();
		txtcname.setBounds(97, 23, 287, 21);
		contentPane.add(txtcname);
		txtcname.setColumns(10);
		
		txtctype = new JTextField();
		txtctype.setColumns(10);
		txtctype.setBounds(97, 77, 287, 21);
		contentPane.add(txtctype);
		
		txtcprice = new JTextField();
		txtcprice.setColumns(10);
		txtcprice.setBounds(97, 128, 287, 21);
		contentPane.add(txtcprice);
		
		txtcnumber = new JTextField();
		txtcnumber.setColumns(10);
		txtcnumber.setBounds(97, 176, 287, 21);
		contentPane.add(txtcnumber);
		
		JLabel lblNewLabel = new JLabel("\uBD80\uD488\uBA85");
		lblNewLabel.setFont(new Font("���� ���", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 23, 73, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBD80\uD488\uC885\uB958");
		lblNewLabel_1.setFont(new Font("���� ���", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(29, 69, 64, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAC00\uACA9");
		lblNewLabel_2.setFont(new Font("���� ���", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(29, 122, 73, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uB7C9");
		lblNewLabel_3.setFont(new Font("���� ���", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(29, 170, 73, 30);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton = new JButton("\uBD80\uD488 \uCD94\uAC00");
		btnNewButton.setFont(new Font("���� ���", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				try {
					query("insert", "insert into computer values('"+txtcname.getText()+"','"+txtctype.getText()+"','"+txtcprice.getText()+"','"+txtcnumber.getText()+"')"); //��������
					                           //^�������� (���̺��)
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
				System.out.println("���׸� �߰��Ϸ�");
				dbDis();

				txtcname.setText(""); //��������
				txtctype.setText(""); //��������
				txtcprice.setText(""); //��������
				txtcnumber.setText("");
			}
		});
		btnNewButton.setBounds(56, 221, 166, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uC774\uC804\uD398\uC774\uC9C0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computer1 com = new Computer1();
				com.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("���� ��� Semilight", Font.PLAIN, 15));
		btnNewButton_1.setBounds(234, 221, 120, 30);
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
				txtcname.setText(String.valueOf(rs.getString("cname"))); //��������
	
				txtctype.setText(rs.getString("ctype"));
					
				txtcprice.setText(rs.getString("cprice"));
				
				txtcnumber.setText(rs.getString("cnumber"));
		}
	}
}
