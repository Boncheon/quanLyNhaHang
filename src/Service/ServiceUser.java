
package Service;



import JDBC.DBConnect;
import Model.ModelLogin;
import Model.ModelNguoiDung;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// Controller Đăng ký/Đăng nhập vào hệ thống
public class ServiceUser {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;
    
    //Connect tới DataBase       

    /*
        Kiểm tra thông tin đăng nhập
        Trả về : null <- Nếu Thông tin đăng nhập sai
                 ModelNguoiDung <- Nếu thông tin đăng nhập đúng
    */
    public ModelNguoiDung login(ModelLogin login) throws SQLException{
        ModelNguoiDung user=null;
        sql = "SELECT * FROM NguoiDung WHERE Email=? AND Matkhau=? FETCH FIRST 1 ROWS ONLY";
        PreparedStatement p =con.prepareStatement(sql);
        p.setString(1, login.getEmail());
        p.setString(2, login.getPassword());
        ResultSet r= p.executeQuery();
        if(r.next()){
            int UserID=r.getInt("ID_ND");
            String email=r.getString("Email");
            String password=r.getString("Matkhau");
            String role=r.getString("Vaitro");
            user=new ModelNguoiDung(UserID,email,password,role);
        }
        r.close();
        p.close();
        return user;
    }
    //Thay đổi mật khẩu tài khoản
    public void changePassword(int userID,String newPass) throws SQLException{
        String sql="UPDATE NguoiDung SET MatKhau = ? WHERE ID_ND = ?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setString(1, newPass);
        p.setInt(2, userID);
        p.execute();
        p.close();
    }
}
