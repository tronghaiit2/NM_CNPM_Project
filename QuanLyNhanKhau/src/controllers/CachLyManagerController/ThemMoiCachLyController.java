package controllers.CachLyManagerController;

import Bean.CachLyBean;
import models.CachLyModel;
import models.NhanKhauModel;
import services.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

/**
 *
 * @author DungLHT
 */

public class ThemMoiCachLyController {
    public boolean themMoiCachLy(CachLyBean cachLyBean) throws SQLException, ClassNotFoundException{
        NhanKhauModel nhanKhauModel = cachLyBean.getNhanKhauModel();
        CachLyModel cachLy = cachLyBean.getCachLyModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO cach_ly (id_cachly, tgian_bat_dau , muc_do_cach_ly, noi_cach_ly, is_tested, id_nhankhau)"
                + "values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, cachLy.getCachly_id());
        Date ngayCachLy = new Date(cachLy.getTgian_bat_dau().getTime());
        preparedStatement.setDate(2, ngayCachLy);
        preparedStatement.setString(3, cachLy.getMuc_do_cach_ly());
        preparedStatement.setString(4, cachLy.getNoi_cach_ly());
        preparedStatement.setBoolean(5,cachLy.isIs_tested());
        preparedStatement.setInt(6, cachLy.getNhankhau_id());

        preparedStatement.executeUpdate();
        connection.close();
        return true;
    }
}
