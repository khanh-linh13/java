package qlydoanhthuveso;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class EmployeeUI extends JFrame {
    public EmployeeUI() {
        super("Giao diện nhân viên");
        JFrame frame = new JFrame("Thông tin");
	    frame.setSize(600, 350);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel container = new JPanel(new CardLayout());
	    
	    JPanel panel2 = createPanel2();
	    JPanel panel3 = createPanel3();
	    JPanel panel4 = createPanel4();
	    JPanel panel5 = createPanel5();

	    container.add(panel2, "panel2");
	    container.add(panel3, "panel3");
	    container.add(panel4, "panel4");
	    container.add(panel5, "panel5");
	    
	    
	    JMenuBar menuBar = new JMenuBar();
	    JMenu menu = new JMenu("Menu");


       JMenuItem menuItem2 = new JMenuItem("Nhân viên");
       menuItem2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cardLayout = (CardLayout) container.getLayout();
	            cardLayout.show(container, "panel2");
	        }
	    });
	    menu.add(menuItem2);
	    //kh nhận giải
	    JMenuItem menuItem3 = new JMenuItem("Số lượng giải");
	    menuItem3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cardLayout = (CardLayout) container.getLayout();
	            cardLayout.show(container, "panel3");
	        }
	    });
	    menu.add(menuItem3);
	    
	    JMenuItem menuItem4 = new JMenuItem("Khách hàng nhận giải");
	    menuItem4.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cardLayout = (CardLayout) container.getLayout();
	            cardLayout.show(container, "panel4");
	        }
	    });
	    menu.add(menuItem4);
	    
	    JMenuItem menuItem5 = new JMenuItem("Doanh thu");
	    menuItem5.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cardLayout = (CardLayout) container.getLayout();
	            cardLayout.show(container, "panel5");
	        }
	    });
	    menu.add(menuItem5);
	    
	    
	    

	    menuBar.add(menu);
	    frame.setJMenuBar(menuBar);
	    frame.add(container);
	    frame.setVisible(true);
	    }
    ///////
    public JTextField jt_ngay;
    public JTextField jt_thang;
    public JTextField jt_nam;
    static String maNt;
    static String dChi;
    static String nam1;
        private JPanel createPanel5() {
		JPanel jp1 = new JPanel();
		jp1.setBackground(Color.yellow);
		//
		 Font font_sua = new Font("Arial", Font.BOLD, 20);
		 JPanel jp_dt = new JPanel();
		 jp_dt.setBackground(Color.yellow);
		
		 JLabel jl_dt = new JLabel("Doanh thu",JLabel.CENTER);
		 jl_dt.setFont(font_sua);
		 jp_dt.add(jl_dt);
		 
		 //
		
		 DefaultTableModel dtm1 = new DefaultTableModel();
			dtm1.addColumn("Ngày");
			dtm1.addColumn("Tháng");
			dtm1.addColumn("Năm");
			
			
			JTable jtl_nhatro1 = new JTable(dtm1);
			JScrollPane jscp_nhatro1 = new JScrollPane(jtl_nhatro1);
			// kết nối sql//
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root", "");
				// String sql = "select * from nhatro";
				PreparedStatement ps1 = conn.prepareStatement("select * from doanhthu");
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					String maNhaTro1 = rs1.getString("Ngàyy");
					String diaChi1 = rs1.getString("Tháng");
					String nam1 = rs1.getString("Năm");
					dtm1.addRow(new String[] {maNhaTro1, diaChi1, nam1});
				}
				ps1.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			JPanel jp_lb = new JPanel();
			jp_lb.setBackground(Color.yellow);
			
			JLabel jl_ngay = new JLabel("Ngày",JLabel.CENTER);
			JLabel jl_thang = new JLabel("Tháng",JLabel.CENTER);
		    JLabel jl_nam = new JLabel("Năm",JLabel.CENTER);
			
		    JTextField jt_ngay = new JTextField(20);
		    JTextField jt_thang = new JTextField(20);
		    JTextField jt_nam = new JTextField(20);
		    jp_lb.setLayout(new GridLayout(3,3,5,5));
		    jp_lb.add(jl_ngay);
		    jp_lb.add(jt_ngay);
		    jp_lb.add(jl_thang);
		    jp_lb.add(jt_thang);
		    jp_lb.add(jl_nam);
		    jp_lb.add(jt_nam);
		    
		    
		    JPanel jp_buton = new JPanel();
		    jp_buton.setBackground(Color.yellow);
		    JButton jb_them = new JButton("Thêm");
			JButton jb_load = new JButton("Cập nhật");
			JButton jb_sua = new JButton("sửa");
			JButton jb_xoa = new JButton("xóa");
			
			
			jp_buton.setLayout(new FlowLayout());
			jp_buton.add(jb_them);
			jp_buton.add(jb_load);
			jp_buton.add(jb_sua);
			jp_buton.add(jb_xoa);
			
		
		jp1.setLayout(new GridLayout(4,1));
		jp1.add(jp_dt);
	 jp1.add(jscp_nhatro1);
		jp1.add(jp_lb);
		jp1.add(jp_buton);
		  
		
		//
		
		
jb_them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ngay = jt_ngay.getText();
				String thang = jt_thang.getText();
				String nam = jt_nam.getText();
				if (!ngay.isEmpty() && !thang.isEmpty() && !nam.isEmpty()) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_pt1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root","");
						java.sql.Statement st1 = conn_pt1.createStatement();
						st1.executeUpdate("insert into doanhthu(`Ngàyy`, `Tháng`, `Năm`) values ('"+jt_ngay.getText()+ "','" + jt_thang.getText() + "','" + jt_nam.getText() + "')");
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						st1.close();
						conn_pt1.close();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại");
				}

				
			}
		});

jb_load.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			dtm1.setRowCount(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root", "");
			// String sql = "select * from nhatro";
			PreparedStatement ps = conn.prepareStatement("select * from doanhthu");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maNhaTro = rs.getString("Ngàyy");
				String diaChi = rs.getString("Tháng");
				String nam1 = rs.getString("Năm");
				dtm1.addRow(new String[] { maNhaTro, diaChi, nam1 });
			}
			ps.close();
			conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
});
jtl_nhatro1.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int selectRow = jtl_nhatro1.getSelectedRow();
		maNt = jtl_nhatro1.getValueAt(selectRow, 0).toString();
		dChi = jtl_nhatro1.getValueAt(selectRow, 1).toString();
		nam1 = jtl_nhatro1.getValueAt(selectRow, 2).toString();
		System.out.println(maNt+" "+dChi+" "+nam1);
		jt_ngay.setText(maNt);
		jt_thang.setText(dChi);
		jt_nam.setText(nam1);
	}
});
jb_sua.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!jt_ngay.getText().isEmpty() && !jt_thang.getText().isEmpty() && !jt_nam.getText().isEmpty()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_pt1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root", "");
				java.sql.Statement st2 = conn_pt1.createStatement();
			 st2.executeUpdate("update doanhthu set `Ngàyy`='"+jt_ngay.getText()+"', `Tháng`='"+jt_thang.getText()+"', `Năm`='" +jt_nam.getText()+"' where `Ngàyy`="+jt_ngay.getText());
				JOptionPane.showMessageDialog(null, "Sửa thành công");
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
			}else {
				JOptionPane.showMessageDialog(null, "Sửa thất bại");
			}
		
	}
});
jb_xoa.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_pt = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root", "");
			java.sql.Statement st = conn_pt.createStatement();
			int ret = JOptionPane.showConfirmDialog(null, "Xác nhận xóa?", "Xóa", JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				st.executeUpdate("delete from doanhthu where `Ngàyy`='" + maNt + "'");
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
});
		
		return jp1;
		
        }    
		private JPanel createPanel4() {
        	//
		JPanel jp_kh = new JPanel();
		  //
	      Font font_sua = new Font("Arial", Font.BOLD, 20);
			JPanel jPanel_tdtk = new JPanel();
			jPanel_tdtk.setBackground(Color.yellow);
			JLabel jLabel_tdtk = new JLabel("Khách hàng nhận giải",JLabel.CENTER);
			
			jLabel_tdtk.setSize(400, 300);
			jLabel_tdtk.setForeground(Color.BLUE);
			jLabel_tdtk.setFont(font_sua);
			jPanel_tdtk.add(jLabel_tdtk);

			JPanel jPanel_tk = new JPanel();
			jPanel_tk.setBackground(Color.YELLOW);
			JLabel jLabel_goiy = new JLabel("Tên khách hàng");
			JTextField jTextField_tk = new JTextField(20);
		    JButton jButton_tk = new JButton("tìm kiếm");
		    jButton_tk.setBackground(Color.white);
		    jButton_tk.setForeground(Color.BLACK);
		  
			
			jPanel_tk.setLayout(new FlowLayout());
			jPanel_tk.add(jLabel_goiy);
			jPanel_tk.add(jTextField_tk);
			jPanel_tk.add(jButton_tk);

	    
			
			DefaultTableModel dtm_pt1 = new DefaultTableModel();
			dtm_pt1.addColumn("Tên khách hàng");
			dtm_pt1.addColumn("Khu vực");
			dtm_pt1.addColumn("Đạt giải");

			

			JTable jtl_pt = new JTable(dtm_pt1);
			JScrollPane jscp_PT = new JScrollPane(jtl_pt);

			jButton_tk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (!jTextField_tk.getText().isEmpty()) {
						try {
							dtm_pt1.setRowCount(0);
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn_pt1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root", "");
							PreparedStatement ps_pt1 = conn_pt1.prepareStatement("select * from nhangiai where `Tên khách hàng`='"+ jTextField_tk.getText() + "' or `Khu vực`='" +jTextField_tk.getText() + "' or `Đạt giải`='" + jTextField_tk.getText() + "'");
							ResultSet rs_pt1 = ps_pt1.executeQuery();
							while (rs_pt1.next()) {
								String mapt1 = rs_pt1.getString("Tên khách hàng");
								String tenpt1 = rs_pt1.getString("Khu vực");
								String slpt1 = rs_pt1.getString("Đạt giải");
								
								dtm_pt1.addRow(new String[] { mapt1, tenpt1, slpt1});
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
			
			
			jp_kh.setLayout(new GridLayout(3,1));
			jp_kh.add(jPanel_tdtk);
			jp_kh.add(jPanel_tk);
			jp_kh.add(jscp_PT);
		    return jp_kh;
	}
		private JPanel createPanel3() {
	    JPanel jp = new JPanel();
	    //
	    Font font_sua = new Font("Arial", Font.BOLD, 20);
		JPanel jPanel_tdtk = new JPanel();
		jPanel_tdtk.setBackground(Color.yellow);
		JLabel jLabel_tdtk = new JLabel("Số lượng giải",JLabel.CENTER);
		
		jLabel_tdtk.setSize(400, 300);
		jLabel_tdtk.setForeground(Color.BLUE);
		jLabel_tdtk.setFont(font_sua);
		jPanel_tdtk.add(jLabel_tdtk);

		JPanel jPanel_tk = new JPanel();
		jPanel_tk.setBackground(Color.YELLOW);
		JLabel jLabel_goiy = new JLabel("Khu vực");
		JTextField jTextField_tk = new JTextField(20);
	    JButton jButton_tk = new JButton("tìm kiếm");
	    jButton_tk.setBackground(Color.white);
	    jButton_tk.setForeground(Color.BLACK);
	  
		
		jPanel_tk.setLayout(new FlowLayout());
		jPanel_tk.add(jLabel_goiy);
		jPanel_tk.add(jTextField_tk);
		jPanel_tk.add(jButton_tk);

    
		
		DefaultTableModel dtm_pt1 = new DefaultTableModel();
		dtm_pt1.addColumn("Khu vực");
		dtm_pt1.addColumn("Giải đặc biệt");
		dtm_pt1.addColumn("Giải nhất");
		dtm_pt1.addColumn("Giải nhì");
		dtm_pt1.addColumn("Giải ba");
		

		JTable jtl_pt = new JTable(dtm_pt1);
		JScrollPane jscp_PT = new JScrollPane(jtl_pt);

		jButton_tk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!jTextField_tk.getText().isEmpty()) {
					try {
						dtm_pt1.setRowCount(0);
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_pt1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/duanck", "root", "");
						PreparedStatement ps_pt1 = conn_pt1.prepareStatement("select * from soluonggiai where `Khu vực`='"+ jTextField_tk.getText() + "' or `Giải đặc biệt`='" +jTextField_tk.getText() + "' or `Giải nhất`='" + jTextField_tk.getText() + "' or `Giải nhì`='" + "' or `Giải ba`='" + "'");
						ResultSet rs_pt1 = ps_pt1.executeQuery();
						while (rs_pt1.next()) {
							String mapt1 = rs_pt1.getString("Khu vực");
							String tenpt1 = rs_pt1.getString("Giải đặc biệt");
							String slpt1 = rs_pt1.getString("Giải nhất");
							String nhi = rs_pt1.getString("Giải nhì");
							String ba = rs_pt1.getString("Giải ba");
							dtm_pt1.addRow(new String[] { mapt1, tenpt1, slpt1,nhi,ba});
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
		
		
		
		jp.setLayout(new GridLayout(3,1));
		jp.add(jPanel_tdtk);
		jp.add(jPanel_tk);
		jp.add(jscp_PT);
		
		return jp;
	}
		private JPanel createPanel2() {
		JPanel jp = new JPanel();
		jp.setBackground(Color.yellow);
		
		JPanel jp_1 = new JPanel();
		jp_1.setBackground(Color.yellow);
		Font ft = new Font("arial", Font.BOLD,24);
		JLabel jl_nv = new JLabel("Thông tin nhân viên",JLabel.CENTER);
		jl_nv.setForeground(Color.BLUE);
		jl_nv.setFont(ft);
		jp_1.add(jl_nv);
		Font ft1 = new Font("arial", Font.ITALIC,16);
		JPanel jp_2 = new JPanel();
		jp_2.setBackground(Color.yellow);
		JLabel jl_ten = new JLabel("Họ tên: Lê Thị Nhung",JLabel.CENTER);
		JLabel jl_ma = new JLabel("Mã nv: 160925",JLabel.CENTER);
		jl_ma.setFont(ft1);
		jl_ten.setFont(ft1);
		
		jp_2.setLayout(new GridLayout(2,1));
		jp_2.add(jl_ten);
		jp_2.add(jl_ma);
		
		jp.setLayout(new GridLayout(3,1));
		jp.add(jp_1);
		jp.add(jp_2);
		
		
		return jp;
	}

		public static void main(String[] args) {
			new EmployeeUI();
		}
    }
