package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
public class HomeCotroller {
    private JLabel tongNhanKhauLb;
    private JLabel tongHoKhauLb;
    private JLabel nhanKhauTamTruLb;
    private JLabel nhanKhauTamVangLb;
    private JLabel tongKhaiBao;

    public HomeCotroller(JLabel tongNhanKhauLb, JLabel tongHoKhau, JLabel nhanKhauTamTruLb, JLabel nhanKhauTamVangLb, JLabel tongKhaiBao) {
        this.tongNhanKhauLb = tongNhanKhauLb;
        this.tongHoKhauLb = tongHoKhau;
        this.nhanKhauTamTruLb = nhanKhauTamTruLb;
        this.nhanKhauTamVangLb = nhanKhauTamVangLb;
        this.tongKhaiBao = tongKhaiBao;
    }


    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM nhan_khau";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongNhanKhauLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM ho_khau";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongHoKhauLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM tam_tru WHERE denNgay < NOW()";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){

                this.nhanKhauTamTruLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM tam_vang WHERE denNgay < NOW()";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.nhanKhauTamVangLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();

            query = "SELECT COUNT(DISTINCT nhankhau_id) as tong from khai_bao";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongKhaiBao.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();




            connection.close();
        } catch (Exception e) {
        }
    }

    public JLabel getTongNhanKhauLb() {
        return tongNhanKhauLb;
    }

    public void setTongNhanKhauLb(JLabel tongNhanKhauLb) {
        this.tongNhanKhauLb = tongNhanKhauLb;
    }

    public JLabel getTongHoKhauLb() {
        return tongHoKhauLb;
    }

    public void setTongHoKhau(JLabel tongHoKhauLb) {
        this.tongHoKhauLb = tongHoKhauLb;
    }

    public JLabel getNhanKhauTamTruLb() {
        return nhanKhauTamTruLb;
    }

    public void setNhanKhauTamTruLb(JLabel nhanKhauTamTruLb) {
        this.nhanKhauTamTruLb = nhanKhauTamTruLb;
    }

    public JLabel getNhanKhauTamVangLb() {
        return nhanKhauTamVangLb;
    }

    public void setNhanKhauTamVangLb(JLabel nhanKhauTamVangLb) {
        this.nhanKhauTamVangLb = nhanKhauTamVangLb;
    }

    public JLabel getTongKhaiBao() {
        return tongKhaiBao;
    }

    public void setTongKhaiBao(JLabel tongKhaiBao) {
        this.tongKhaiBao = tongKhaiBao;
    }
}
