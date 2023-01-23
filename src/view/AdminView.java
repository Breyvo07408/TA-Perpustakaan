package view;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.AdminController;
import java.awt.Font;

public class AdminView extends Frame{
    AdminController admin = new AdminController();
    private JLabel emailLabel,passwordLabel,juduLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginBtn;

    public AdminView(){
        super("LOGIN", 600, 700);
    }

    @Override
    protected void component() {

        juduLabel = new JLabel("PERPUSTAKAAN.COM");
        setFontSize(juduLabel, 40);
        setFontStyle(juduLabel, Font.BOLD);
        boundedAdd(juduLabel, 95, 58, 524, 160);

        emailLabel = new JLabel("EMAIL");
        setFontSize(emailLabel, 20);
        setFontStyle(emailLabel, Font.ROMAN_BASELINE);
        boundedAdd(emailLabel, 260, 198, 281, 78);

        emailField = new JTextField();
        boundedAdd(emailField, 190, 260, 200, 35);

        passwordLabel = new JLabel("PASSWORD");
        setFontSize(passwordLabel, 20);
        setFontStyle(passwordLabel, Font.ROMAN_BASELINE);
        boundedAdd(passwordLabel, 240, 290, 281, 78);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 190, 352, 200, 35);

        loginBtn = new JButton("Login");
        loginBtn.setBackground(color("#00D4FF"));
        loginBtn.setForeground(color("#FFFFFF"));
        loginBtn.setFocusPainted(false);
        boundedAdd(loginBtn, 250, 450, 85, 32);
    }

    @Override
    protected void event() {
        loginBtn.addActionListener((e) -> {
            String emaail = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean status = admin.status(emaail, password);

            if (status) {
                new DataBukuView().setVisible(true);
                dispose();
                
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username atau Password Salah",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
        
    }
}
