package qlydoanhthuveso;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
	private ManagementUI g;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chkShowPassword;

    public Login() {
        super("Đăng Nhập");

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(65, 105, 225));
        headerPanel.setLayout(new BorderLayout());
//        ImageIcon headerIcon = new ImageIcon("dn.jpg"); // Thay đổi đường dẫn hình ảnh thực tế
        // Header Label
        
        JLabel lblHeader = new JLabel("Quản lý doanh thu vé số ", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 25));
        lblHeader.setForeground(Color.WHITE);
        headerPanel.add(lblHeader, BorderLayout.CENTER);

        // Body Panel
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Body Components
        JLabel lblUsername = new JLabel("Tài khoản:");
        JLabel lblPassword = new JLabel("Mật khẩu:");

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        chkShowPassword = new JCheckBox("Hiển thị mật khẩu");
        chkShowPassword.setBackground(new Color(240, 248, 255));
        chkShowPassword.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPassword.setEchoChar((char) 0);
                } else {
                    txtPassword.setEchoChar('\u2022');
                }
            }
        });

        JButton btnQuanLy = new JButton("Quản lý");
        btnQuanLy.setBackground(new Color(65, 105, 225));
        btnQuanLy.setForeground(Color.WHITE);
        btnQuanLy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	loginQuanLy();
            }
        });

        JButton btnLogin = new JButton("Nhân viên");
        btnLogin.setBackground(new Color(65, 105, 225));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              new ManagementUI();
            	 new EmployeeUI();
            }
        });

        // Create a new JPanel for the buttons with GridLayout (1 row, 2 columns)
        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        btnPanel.setBackground(new Color(240, 248, 255));
        btnPanel.add(btnLogin);
        btnPanel.add(btnQuanLy);

        // Adding Components to Body Panel
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(chkShowPassword);
        panel.add(btnPanel); // Add the button panel instead of individual buttons

        // Main Layout
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
//   
    private void loginQuanLy() {
        String username = txtUsername.getText();
        char[] passwordChars = txtPassword.getPassword();
        String password = new String(passwordChars);

        // Kiểm tra xem người dùng có phải là quản trị viên không
        if ("Nguyễn Văn A".equals(username) && "admin123".equals(password)) {
            JOptionPane.showMessageDialog(this, "Đăng nhập quản lý thành công!");
            // Tạo và hiển thị giao diện quản lý
            new ManagementUI();
            // Đóng cửa sổ đăng nhập
            dispose();
        } else {
            // Kiểm tra xem người dùng có phải là nhân viên không
            if (checkLogin(username, password, "nhanvien")) {
                JOptionPane.showMessageDialog(this, "Đăng nhập nhân viên thành công!");
                // Tạo đối tượng EmployeeUI và hiển thị nó
                        new EmployeeUI();
                    
                // Đóng cửa sổ đăng nhập
                dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thất bại. Vui lòng thử lại.");
                txtUsername.setText("");
                txtPassword.setText("");
            }
        }
    }
    private boolean checkLogin(String username, String password, String role) {
        String dbUrl = "jdbc:mysql://localhost:3306/school";
        String dbUser = "root";
        String dbPassword = "W@2915djkq#";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM nhanvien WHERE tên đăng nhập = ? AND mật khẩu = ? AND vai trò = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, role);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Nếu có một hàng được trả về, thì đăng nhập thành công
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        new Login();
    }
}