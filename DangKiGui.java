package qlydoanhthuveso;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangKiGui extends JFrame {

	 private JTextField txtUsername;
	    private JPasswordField txtPassword;
	    private JPasswordField txtConfirmPassword;
	    private JCheckBox chkLuuMatKhau;

	    public DangKiGui() {
	        setTitle("Đăng Kí");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(500,300);
	        setLocationRelativeTo(null);

	        JPanel jpn = new JPanel();
			jpn.setLayout(new BorderLayout());
			jpn.setBackground(Color.YELLOW);
			Font  ft = new Font("arial", Font.BOLD,20);
			JLabel jl_tkm = new JLabel("Tạo Tài Khoản",JLabel.CENTER);
			jl_tkm.setFont(ft);
			jl_tkm.setForeground(Color.RED);
			jpn.add(jl_tkm,BorderLayout.CENTER);
			jl_tkm.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DangKiGui.class.getResource("home.png"))));
			JPanel jp_trua = new JPanel();
			jp_trua.setBackground(Color.yellow);
			Font ft1=new Font("arial",	Font.BOLD,	14);
			JLabel jl_tkmoi = new JLabel("Tài Khoản:",JLabel.CENTER);
			jl_tkmoi.setFont(ft1);
			JLabel jl_pass = new JLabel("Mật Khẩu:",JLabel.CENTER);
			jl_pass.setFont(ft1);
			JLabel jl_nhaplaipass = new JLabel("Nhập Lại: ",JLabel.CENTER);
			jl_nhaplaipass.setFont(ft1);
			
			JTextField jt_taikhoan = new JTextField(20);
			JPasswordField jt_pass = new JPasswordField(30);
			JPasswordField jt_nhaplaipass = new JPasswordField(30);
			
			JCheckBox cbox = new JCheckBox(" Lưu Mật Khẩu");
			cbox.setBackground(Color.yellow);
			jp_trua.setLayout(new GridLayout(4,2));
			jp_trua.add(jl_tkmoi);
			jp_trua.add(jt_taikhoan);
			jp_trua.add(jl_pass);
			jp_trua.add(jt_pass);
			jp_trua.add(jl_nhaplaipass);
			jp_trua.add(jt_nhaplaipass);
			jp_trua.add(cbox);		
		
			JPanel jpn_btn = new JPanel();
			jpn_btn.setBackground(Color.YELLOW);
			JButton jbt_dangky = new JButton("Đăng Ký");
			jbt_dangky.setBackground(new Color(65,105,225));
			jbt_dangky.setForeground(Color.WHITE);
			JButton jbt_dangnhap = new JButton("Đăng Nhập");
			jbt_dangnhap.setBackground(new Color(65, 105, 225));
			jbt_dangnhap.setForeground(Color.WHITE);
			jpn_btn.setLayout(new GridLayout(3,1));
			
			jpn_btn.setLayout(new FlowLayout());
			jpn_btn.add(jbt_dangky);
			jpn_btn.add(jbt_dangnhap);
			
			
			
			jbt_dangky.addActionListener(new ActionListener() {
				
			
			//*	@Override
				public void actionPerformed(ActionEvent e) {
				//	GD2 gd2 = new GD2();
					int ret = JOptionPane.showConfirmDialog(null,"Đăng ký thành công","Đăng ký",JOptionPane.CANCEL_OPTION);
					if(ret == JOptionPane.OK_OPTION) {
						dispose();
					}
				}
			});
			jbt_dangnhap.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Login lg = new Login();
				}
			});
			
			Container con = getContentPane();
			con.setLayout(new GridLayout(3,1,0,0));
			con.add(jpn);
			con.add(jp_trua);
			con.add(jpn_btn);
	

	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        new DangKiGui();
	    }
	}

