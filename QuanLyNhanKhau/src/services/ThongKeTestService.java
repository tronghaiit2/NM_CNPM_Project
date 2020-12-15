package services;

import models.CachLyModel;
import models.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeTestService {

    public static boolean validateJavaDate(String strDate) {
        /* Check if date is 'null' */
        if (strDate.trim().equals("")) {
            return true;
        }
        /* Date is not 'null' */
        else {
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            }
            /* Date format is invalid */ catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }

    public List<Test> getALlListTest() {
        List<Test> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = String.format("SELECT * FROM test");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Test test = new Test();
                test.setTestId(rs.getInt("id_test"));
                test.setId_nhankhau(rs.getInt("id_nhankhau"));
                test.setHinh_thuc_test(rs.getString("hinh_thuc_test"));
                test.setThoi_diem_test(rs.getDate("thoi_diem_test"));
                test.setKet_qua(rs.getString("ket_qua"));
                list.add(test);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }


    public List<Test> getListCachLy(String tinhTrang, String tgianCachLy) {
        List<Test> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            //need fix query
            String query = String.format("SELECT * FROM test where ket_qua = '%s'", tinhTrang);
            if (!tgianCachLy.trim().equals("")) {
                query += String.format(" and thoi_diem_test >= '%s'", tgianCachLy);
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Test test = new Test();
                test.setTestId(rs.getInt("id_test"));
                test.setId_nhankhau(rs.getInt("id_nhankhau"));
                test.setHinh_thuc_test(rs.getString("hinh_thuc_test"));
                test.setThoi_diem_test(rs.getDate("thoi_diem_test"));
                test.setKet_qua(rs.getString("ket_qua"));
                list.add(test);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public String getHoTen(String id){
        String hoTen = "";
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "select hoTen from nhan_khau where ID = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                hoTen = rs.getString("hoTen");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hoTen;
    }

}
