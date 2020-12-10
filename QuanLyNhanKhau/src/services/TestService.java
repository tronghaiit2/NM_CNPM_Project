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

    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.getListTestBeans();
    }

    public List<TestBean> getListTestBeans() {
        List<TestBean> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM test t JOIN nhan_khau nk ON t.id_nhankhau = nk.ID LEFT JOIN cach_ly cl ON t.id_cachly = cl.id_cachly ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                TestBean testBean = new TestBean();
                Test test = testBean.getTest();
                //NhanKhauModel nhanKhauModel = testBean.getNhanKhauModel();
                test.setTestId(rs.getInt("id_test"));
                test.setHinh_thuc_test(rs.getString("hinh_thuc_test"));
                test.setThoi_diem_test(rs.getDate("thoi_diem_test"));
                test.setKet_qua(rs.getString("ket_qua"));
                test.setCachly_id(rs.getInt("id_cachly"));
                test.setId(rs.getInt("id_nhankhau"));
                //System.out.println(test.toString());
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
