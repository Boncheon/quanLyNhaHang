
package Compoment;

import Swing.ButtonOutLine;
import Swing.ImageLogo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {
    private final DecimalFormat df = new DecimalFormat("##0.###");
    private ActionListener event;
    private MigLayout layout;
    private ImageLogo logo;
    private JLabel title;
    private JLabel subtitle;    
    private JLabel description;
    private JLabel description1;
    private ButtonOutLine button;
    private boolean isLogin;
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }
    public void init(){
        logo= new ImageLogo();
        logo.setPreferredSize(new Dimension(250,250));
        logo.setIcon(new ImageIcon(getClass().getResource("/Icon_Login/ESTD.png")));
        add(logo);
        
        title= new JLabel("Chào mừng bạn đến với nhà hàng");
        title.setFont(new Font("sansserif",1,18));
        title.setForeground(new Color(245,245,245));
        add(title);
        
        subtitle= new JLabel("Meo Meo restaurant");
        subtitle.setFont(new Font("sansserif",1,28));
        subtitle.setForeground(new Color(245,245,245));
        add(subtitle);
        
        description = new JLabel("Để sử dụng dịch vụ tại đây vui lòng");
        description.setForeground(new Color(245,245,245));
        add(description);
        
        description1 = new JLabel("đăng nhập với tài khoản cá nhân của bạn");
        description1.setForeground(new Color(245,245,245));
        add(description1);
        
        button = new ButtonOutLine();
        button.setBackground(new Color(255,255,255));
        button.setForeground(new Color(255,255,255));
        button.setText("<<  Đăng nhập");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
        });
        add(button,"w 60%, h 40");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    protected void paintComponent(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(191,107,131), 0, getHeight(), new Color(108,91,123));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
    public void addEvent(ActionListener event){
        this.event = event;
    }
    
    public void registerLeft(double v){
        v = Double.valueOf(df.format(v));
        Login(false);
        layout.setComponentConstraints(logo, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(title, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(subtitle, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -"+v+"% 0 0");    }
    public void registerRight(double v){
        v = Double.valueOf(df.format(v));
        Login(false);
        layout.setComponentConstraints(logo, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(title, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(subtitle, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -"+v+"% 0 0");    }
    public void LoginLeft(double v){
        v = Double.valueOf(df.format(v));
        Login(true);
        layout.setComponentConstraints(logo, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(title, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(subtitle, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description1, "pad 0 "+v+"% 0 "+v+"%"); 
    }
    public void LoginRight(double v){
        v = Double.valueOf(df.format(v));
        Login(true);
        layout.setComponentConstraints(logo, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(title, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(subtitle, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description, "pad 0 "+v+"% 0 "+v+"%");
        layout.setComponentConstraints(description1, "pad 0 "+v+"% 0 "+v+"%"); 
    }
    private void Login(boolean Login){
         if(this.isLogin!=Login){
            //Set Data cho Panel cover khi ở màn hình đăng nhập
            if(Login){
                logo.setIcon(new ImageIcon(getClass().getResource("/Icon_Login/Lg1.png")));
                title.setText("Bạn chưa có tài khoản tại");
                description.setText("Đừng lo, tạo mới một tài khoản");
                description1.setText("và bắt đầu trải nghiệm của bạn với nhà hàng chúng tôi");
                button.setText("Đăng ký  >>");
            }else{
                //Set Data cho Panel cover khi ở màn hình đăng ký
                logo.setIcon(new ImageIcon(getClass().getResource("/Icon_Login/ESTD.png")));
                title.setText("Chào mừng bạn đến với nhà hàng");
                description.setText("Để sử dụng dịch vụ tại đây vui lòng");
                description1.setText("đăng nhập với tài khoản cá nhân của bạn");
                button.setText("<<  Đăng nhập");
            }
            this.isLogin=Login;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
