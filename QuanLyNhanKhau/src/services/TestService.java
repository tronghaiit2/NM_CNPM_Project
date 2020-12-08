package services;

import Bean.TestBean;
import models.Test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestService {



    public List<TestBean> getListTestBeans() {
        List<TestBean> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM test t JOIN nhan_khau nk ON t.id = nk.ID JOIN cach_ly cl ON t.cachly_id = cl.id ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                TestBean testBean = new TestBean();
                Test test = testBean.getTest();
                //NhanKhauModel nhanKhauModel = testBean.getNhanKhauModel();
                test.setTestId(rs.getInt("idtest"));
                test.setHinh_thuc_test(rs.getString("hinh_thuc_test"));
                test.setThoi_diem_test(rs.getDate("thoi_diem_test"));
                test.setKet_qua(rs.getString("ket_qua"));
                test.setCachly_id(rs.getInt("cachly_id"));
                test.setId(rs.getInt("ID"));
                list.add(testBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    private void exceptionHandle(String message){
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }

}
