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

public class computerSearch extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtcname;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	

	public computerSearch() {
		setTitle("부품검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBD80\uD488\uBA85");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 62, 124, 43);
		contentPane.add(lblNewLabel);
		
		txtcname = new JTextField();
		txtcname.setBounds(78, 76, 198, 21);
		contentPane.add(txtcname);
		txtcname.setColumns(10);
		
		JButton btnNewButton = new JButton("\uBCF4\uC720\uC5EC\uBD80 \uAC80\uC0C9 (\uB354\uBE14\uD074\uB9AD)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dbConnect();
				try {
					query("select", "select * from computer where cname = '" + txtcname.getText() + "'");
					while(rs.next()) {
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							    computeryes cc = new computeryes();
							    cc.setVisible(true);
							}
						});//수정사항
						}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					
				}
				try {
					viewData();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				txtcname.setText(""); //수정사항
				
				
				dbDis();
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(12, 150, 235, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC774\uC804\uD398\uC774\uC9C0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Computer1 com = new Computer1();
			    com.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton_1.setBounds(283, 150, 139, 34);
		contentPane.add(btnNewButton_1);
	}
	public static void dbConnect() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("드라이버 검색 성공!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
        
    	
        url = "jdbc:odbc:computer"; //수정사항 (디비명)
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/computer";//수정사항 (디비명)
        String sql = "Select * From computer";//수정사항 (테이블명)
		try {
         
            conn = DriverManager.getConnection(url,"root","apmsetup");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("데이터베이스 연결 성공!");            
         
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패!");
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
			System.out.println("데이터베이스 연결 해제!");
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
				txtcname.setText(String.valueOf(rs.getString("cname"))); //수정사항
	
				
		}
	}

}
