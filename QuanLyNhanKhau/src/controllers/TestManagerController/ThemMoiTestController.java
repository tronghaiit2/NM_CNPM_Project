package controllers.TestManagerController;

import Bean.TestBean;
import models.NhanKhauModel;
import models.Test;
import services.MysqlConnection;

import java.sql.*;

public class ThemMoiTestController {
    public boolean themMoiTest(TestBean testBean) throws SQLException, ClassNotFoundException{
        NhanKhauModel nhanKhauModel = testBean.getNhanKhauModel();
        Test test = testBean.getTest();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO test (id_test, id_nhankhau, thoi_diem_test, hinh_thuc_test, ket_qua)"
                + "values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, test.getTestId());
        preparedStatement.setInt(2, test.getId());
        Date ngayTest = new Date(test.getThoi_diem_test().getTime());
        preparedStatement.setDate(3, ngayTest);
        preparedStatement.setString(4, test.getHinh_thuc_test());
        preparedStatement.setString(5, test.getKet_qua());
        preparedStatement.executeUpdate();
        connection.close();
        return true;
    }
}
