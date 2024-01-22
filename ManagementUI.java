package qlydoanhthuveso;




//}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManagementUI extends JFrame {
    public ManagementUI() {
    	super("Người quản lý");
      setSize(500, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
       
      Font font_sua = new Font("Arial", Font.BOLD, 20);
		JPanel jPanel_tdtk = new JPanel();
		jPanel_tdtk.setBackground(Color.yellow);
		JLabel jLabel_tdtk = new JLabel("Tìm Kiếm");
		
		jLabel_tdtk.setSize(300, 200);
		jLabel_tdtk.setForeground(Color.BLUE);
		jLabel_tdtk.setFont(font_sua);
		jPanel_tdtk.add(jLabel_tdtk);

		JPanel jPanel_tk = new JPanel();
		jPanel_tk.setBackground(Color.YELLOW);
		JLabel jLabel_goiy = new JLabel("Khu vực,tháng...");
		JTextField jTextField_tk = new JTextField(20);
	    JButton jButton_tk = new JButton("tìm kiếm");
	    jButton_tk.setBackground(Color.white);
	    jButton_tk.setForeground(Color.BLACK);
	  
		
		jPanel_tk.setLayout(new FlowLayout());
		jPanel_tk.add(jLabel_goiy);
		jPanel_tk.add(jTextField_tk);
		jPanel_tk.add(jButton_tk);

      JPanel jp_tcn = new JPanel();
		jp_tcn.setBackground(Color.white);
		JButton jb_ql = new JButton();
	//	jb_ql.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(TCN.class.getResource("QL1.png"))));
		jb_ql.setBackground(Color.white);
		
		
		

		
		
		
		
		jp_tcn.setLayout(new FlowLayout());
	    jp_tcn.add(jb_ql);
		
		
		DefaultTableModel dtm_pt = new DefaultTableModel();
		dtm_pt.addColumn("khu vực");
		dtm_pt.addColumn("Số lượng giải");
		dtm_pt.addColumn("Tháng");
		dtm_pt.addColumn("Doanh thu");
		

		JTable jtl_pt = new JTable(dtm_pt);
		JScrollPane jscp_PT = new JScrollPane(jtl_pt);

		jButton_tk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!jTextField_tk.getText().isEmpty()) {
					try {
						dtm_pt.setRowCount(0);
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_pt1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root", "");
						PreparedStatement ps_pt1 = conn_pt1.prepareStatement("select * from quanly where `khuVuc`='"+ jTextField_tk.getText() + "' or `SoluongGiai`='" +jTextField_tk.getText() + "' or `Thang`='" + jTextField_tk.getText() + "' or `DoanhThu`='" + jTextField_tk.getText() + "'");
						ResultSet rs_pt1 = ps_pt1.executeQuery();
						while (rs_pt1.next()) {
							String mapt1 = rs_pt1.getString("khuVuc");
							String tenpt1 = rs_pt1.getString("SoluongGiai");
							String slpt1 = rs_pt1.getString("Thang");
							String malpnt1 = rs_pt1.getString("DoanhThu");
							dtm_pt.addRow(new String[] { mapt1, tenpt1, slpt1, malpnt1});
						}
						ps_pt1.close();
						conn_pt1.close();
					} catch (ClassNotFoundException | SQLException e2) {
						e2.printStackTrace();

					}
				} else {
					JOptionPane.showMessageDialog(null, "Xin mời nhập thông tin");
				}
			}
		});
		
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(jPanel_tdtk);
		con.add(jPanel_tk);
		con.add(jscp_PT);
	

  
       

        
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ManagementUI();
    }
}


