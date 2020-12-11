package controllers.KhaiBaoManagerController;

import Bean.KhaiBaoBean;
import models.KhaiBao;
import services.MysqlConnection;

import java.sql.*;


/**
 * @author hieppm
 */
public class ThemMoiKhaiBaoController {
    public boolean themKhaiBao(KhaiBaoBean khaiBaoBean) throws SQLException, ClassNotFoundException {
        KhaiBao khaiBao = khaiBaoBean.getKhaiBaoModel();
        System.out.println(khaiBao.getVung_dich());
        System.out.println(khaiBao.getBieu_hien());
        System.out.println(khaiBao.getNgay_khai_bao());
        System.out.println(khaiBao.getNhankhau_id());
        Connection connection = MysqlConnection.getMysqlConnection();
        if (connection == null) {
            System.out.println("Connection fail");
        }
        String query = "INSERT INTO khai_bao (vung_dich, bieu_hien, ngay_khai_bao, id_nhankhau) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, khaiBao.getVung_dich());
        preparedStatement.setString(2, khaiBao.getBieu_hien());
        preparedStatement.setDate(3, khaiBao.getNgay_khai_bao());

        preparedStatement.setInt(4, khaiBao.getNhankhau_id());
        preparedStatement.execute();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            return true;
        } else
            return false;

    }

    public int getNhanKhauID(String ma_nhan_khau) {
        int res = -1;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = String.format("Select ID from nhan_khau where maNhanKhau = \'%s\'" , ma_nhan_khau);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                res = rs.getInt(1);
            }


        } catch (SQLException e1) {
            e1.printStackTrace();

        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return res;

    }

}
