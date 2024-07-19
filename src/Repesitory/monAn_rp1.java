/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repesitory;

import JDBC.DBConnect;
import Model.ModelMonAn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import response.MonAn_response;

/**
 *
 * @author Admin
 */
public class monAn_rp1 {
      public ArrayList<MonAn_response> getAll(){
            ArrayList<MonAn_response> list = new ArrayList<>();
            // CODE
            //b1: tạo sql
            String sql ="""
SELECT dbo.MonAn.MaMonAn, dbo.MonAn.TenMonAn, dbo.MonAn.Gia, dbo.LoaiMonAn.TenLoaiMonAn, dbo.MonAn.TrangThai
FROM     dbo.LoaiMonAn INNER JOIN
                  dbo.MonAn ON dbo.LoaiMonAn.ID_LoaiMonAn = dbo.MonAn.ID_LoaiMonAn
                        """;
            //B2: tạo bảng kết nối
            // try ..... with......resources
            try (Connection con = DBConnect.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)){
                // kết quả trả ra 1 bảng  ==> 1ResultSet
                ResultSet rs = ps.executeQuery();
                //Sql==> Select ==> execteQuery
                // doc lan luot
                while (rs.next()) {                    
                    // B3: Tạo 1 đối tượng
                    MonAn_response  monAn = MonAn_response.builder()
                    .maMonan(rs.getString(1))
                    .tenMonan(rs.getString(2))
                    .donGia(rs.getDouble(3))
                    .TenLoaiMon(rs.getString(4))
                    .TrangThai(rs.getBoolean(5))
//                    .Id_loaiMon(rs.getInt(6))
//                    .MaMonAn(rs.getString(7))
                    .build();
                    list.add(monAn);
                }
                return list;
            } catch (Exception e) {
            e.printStackTrace(System.out);
            }
            return null;
        }
      
    public boolean add(ModelMonAn MoAn) {

        int check = 0;

        String sql = """
INSERT INTO [dbo].[MonAn]
                            ([TenMonAn]
                            ,[Gia]
                            ,[ID_LoaiMonAn]
                            ,[TrangThai])
                      VALUES
                            (?,?,?,?)
                     
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, MoAn.getTenMonan());
            ps.setDouble(2, MoAn.getDonGia());
            ps.setInt(3, MoAn.getId_loaiMon());
            ps.setBoolean(4, MoAn.getTrangThai());
            

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return check > 0;
    }
  public boolean update( String maMonAn,ModelMonAn newmonAn) {
        int check = 0;
        String sql = """
UPDATE [dbo].[MonAn]
   SET [TenMonAn] = ?
      ,[Gia] = ?
      ,[ID_LoaiMonAn] = ?
      ,[TrangThai] = ?
 WHERE MaMonAn = ?
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, newmonAn.getTenMonan());
            ps.setObject(2, newmonAn.getDonGia() );
            ps.setObject(3, newmonAn.getId_loaiMon());
            ps.setObject(4, newmonAn.getTrangThai());
            ps.setObject(5, maMonAn);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
        public static void main(String[] args) {
            System.out.println(new monAn_rp1().getAll());
    }
        
}
