package services;

import models.CachLyModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeCachLyService {


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

    public List<CachLyModel> getListCachLy(String mucDo, String tgianCachLy) {
        List<CachLyModel> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            //need fix query
            String query = "";
            if (tgianCachLy.trim().equals("")) {
                query = String.format("SELECT * FROM cach_ly cl where cl.muc_do_cach_ly = '%s'", mucDo);

            } else {
                query = String.format("SELECT * FROM cach_ly cl where cl.muc_do_cach_ly = '%s'", mucDo);
                query += String.format(" and cl.tgian_bat_dau >= '%s'", tgianCachLy);
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                CachLyModel cachly = new CachLyModel();
                cachly.setId(rs.getInt("id_cachly"));
                cachly.setTgian_bat_dau(rs.getDate("tgian_bat_dau"));
                cachly.setMuc_do_cach_ly(rs.getString("muc_do_cach_ly"));
                cachly.setIs_tested(rs.getBoolean("is_tested"));
                cachly.setNhankhau_id(rs.getInt("id_nhankhau"));
                list.add(cachly);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<CachLyModel> getALlListCachLy() {
        List<CachLyModel> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = String.format("SELECT * FROM cach_ly");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                CachLyModel cachly = new CachLyModel();
                cachly.setCachly_id(rs.getInt("id_cachly"));
                cachly.setNhankhau_id(rs.getInt("id_nhankhau"));
                cachly.setTgian_bat_dau(rs.getDate("tgian_bat_dau"));
                cachly.setMuc_do_cach_ly(rs.getString("muc_do_cach_ly"));
                cachly.setIs_tested(rs.getBoolean("is_tested"));
                list.add(cachly);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
}
