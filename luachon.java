package qlydoanhthuveso;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class luachon {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Lựa chọn đăng nhập");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 430);
        frame.setLayout(new BorderLayout());
        
        // Đặt màu nền cho frame
        frame.setBackground(Color.yellow);
        
        // Label "Đăng nhập với tư cách" ở trên cùng và phía giữa
        JLabel titleLabel = new JLabel("CHÀO MỪNG NGƯỜI DÙNG");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);
        titleLabel.setForeground(Color.BLUE); // Đặt màu văn bản là màu xanh
        titleLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(luachon.class.getResource("nguoi.png"))));


       
        
     // Đặt màu nền cho titleLabel
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.yellow);

        frame.add(titleLabel, BorderLayout.NORTH);
        
        // Tăng kích thước của chữ
        Font titleFont = titleLabel.getFont();
        titleLabel.setFont(new Font(titleFont.getName(), Font.BOLD, 18)); // Đặt kích thước font là 18

        // Panel chứa hình ảnh và nút "Quản lý" và "Nhân viên"
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Thêm hình ảnh
        ImageIcon imageIcon = new ImageIcon("dn.jpg"); // Đặt đường dẫn hình ảnh thực tế
        JLabel imageLabel = new JLabel(imageIcon);

        // Thiết lập vị trí và căn chỉnh của hình ảnh
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2; // Sử dụng 2 hàng
        gbc.insets = new Insets(0, 10, 0, 10); // Khoảng cách với các thành phần xung quanh
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(imageLabel, gbc);

//         Tạo nút "Quản lý"
        JButton adminButton = new JButton("Đăng nhập");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Đến trang đăng nhập");
                new Login();
            }
        });
       

        // Tạo nút "Nhân viên"
        JButton employeeButton = new JButton("Đăng kí");
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Đến trang đăng kí");
                    new DangKiGui();
                
            }
        });
     // Đặt màu nền cho nút "Quản lý"
        adminButton.setBackground(Color.GREEN); // Thay đổi màu nền theo nhu cầu

        // Đặt màu nền cho nút "Nhân viên"
        employeeButton.setBackground(Color.GREEN); // Thay đổi màu nền theo nhu cầu
        
     // Đặt kích thước font cho nút "Quản lý"
        Font buttonFont = adminButton.getFont();
        adminButton.setFont(new Font(buttonFont.getName(), Font.CENTER_BASELINE, 15)); // Đặt kích thước font là 16

        // Đặt kích thước font cho nút "Nhân viên"
        buttonFont = employeeButton.getFont();
        employeeButton.setFont(new Font(buttonFont.getName(), Font.CENTER_BASELINE, 15)); // Đặt kích thước font là 16

        // Panel chứa nút "Quản lý" và "Nhân viên"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 50,50 ));
        buttonPanel.add(adminButton);
        buttonPanel.add(employeeButton);

        // Thiết lập vị trí của panel chứa nút vào phần dưới của mainPanel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(15, 15, 10, 15);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);
        
        // Đặt màu nền cho buttonPanel
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(1, 2, 50, 50));
        buttonPanel1.add(adminButton);
        buttonPanel1.add(employeeButton);
        buttonPanel1.setOpaque(true);
        buttonPanel1.setBackground(Color.yellow);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(15, 15, 10, 15);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel1, gbc);

        // Đặt màu nền cho mainPanel
        mainPanel.setBackground(Color.yellow);

        // Thêm mainPanel vào phần giữa của frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Hiển thị frame
        frame.setVisible(true);
        
    }

	protected static void DangKiGui() {
		// TODO Auto-generated method stub
		
	}
}

