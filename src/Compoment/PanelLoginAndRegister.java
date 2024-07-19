
package Compoment;


import Model.ModelLogin;
import Model.ModelNguoiDung;
import Swing.Button;
import Swing.MyPasswordField;
import Swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.text.PasswordView;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    //Lấy tài khoản đăng ký
    public ModelNguoiDung getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    //Lấy thông tin đăng nhập
    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    private ModelNguoiDung user; //Model Tài khoản người dùng
    private String name; //Tên Khách Hàng
    private ModelLogin dataLogin; //Model thông tin đăng nhập
    private Icon hide;
    private Icon show;
    private char def;
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister();
        initLogin(eventLogin);
        Login.setVisible(false);
        Register.setVisible(true);
    }

    private void initRegister(){
        Register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        //Label
        JLabel label = new JLabel("TẠO TÀI KHOẢN");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(Color.decode("#6C5B7B"));
        Register.add(label);

        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/Icon_Login/User.png")));
        txtUser.setHint("Name");
        Register.add(txtUser, "w 60%");
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Icon_Login/mail.png")));
        txtEmail.setHint("Email");
        Register.add(txtEmail, "w 60%");
        
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/Icon_Login/Lock.png")));
        txtPassword.setHint("Mật khẩu ...");
        Register.add(txtPassword, "w 60%");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(108,91,123));
        cmd.setForeground(new Color(255,255,255));
        cmd.setText("SIGN UP");
        Register.add(cmd,"w 40%, h 40");
        
    }
    
    public void showRegister(boolean show){
        if(show){
            Register.setVisible(true);
            Login.setVisible(false);
        }else{
            Register.setVisible(false);
            Login.setVisible(true); 
        }
    }
     private void initLogin(ActionListener eventLogin) {
        //Set Layout
        Login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("ĐĂNG NHẬP");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(Color.decode("#6C5B7B"));
        Login.add(label);
        //TextField Email
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Icons/mail.png")));
        txtEmail.setHint("Email");
        Login.add(txtEmail, "w 60%");
        //TextField Mật khẩu
        MyPasswordField txtPassword = new MyPasswordField();
        def = txtPassword.getEchoChar();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/Icons/pass.png")));
        txtPassword.setHint("Mật khẩu");
        txtPassword.setSuffixIcon(show);
        Login.add(txtPassword, "w 60%");
        txtPassword.addMouseListener(new MouseAdapter() {
         
            public void mouseClicked(MouseEvent e) {
                if (txtPassword.getSuffixIcon().equals(hide)) {
                    txtPassword.setSuffixIcon(show);
                    txtPassword.setEchoChar((char) 0);

                } else {
                    txtPassword.setSuffixIcon(hide);
                    txtPassword.setEchoChar(def);
                }
            }

        });
        //Button "Quên mật khẩu"
        JButton cmdForget = new JButton("Quên mật khẩu của bạn ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Login.add(cmdForget);
        //Button "ĐĂNG NHẬP"
        Button cmd = new Button();
        cmd.setBackground(Color.decode("#6C5B7B"));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ĐĂNG NHẬP");
        Login.add(cmd, "w 40%, h 40");
        //Add Event cho Button "ĐANWGN NHẬP"
        cmd.addActionListener(eventLogin);
        //Add Event cho Button "ĐANWGN NHẬP"
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                dataLogin = new ModelLogin(email, password);
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        Register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        Login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(Login, "card3");

        Register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout RegisterLayout = new javax.swing.GroupLayout(Register);
        Register.setLayout(RegisterLayout);
        RegisterLayout.setHorizontalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        RegisterLayout.setVerticalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(Register, "card2");
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Register;
    // End of variables declaration//GEN-END:variables
}
