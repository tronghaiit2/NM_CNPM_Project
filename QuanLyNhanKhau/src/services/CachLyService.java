/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Bean.CachLyBean;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Bean.KhaiBaoBean;
import Bean.TestBean;
import models.CachLyModel;
import models.KhaiBao;
import models.NhanKhauModel;
import models.Test;
import views.CachLyPanel;

/**
 *
 * @author DungLHT
 */
public class CachLyService{

    public List<CachLyBean> getListCachLyBeans(String hoTen) {
        List<CachLyBean> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query;
                //need fix query
            query = "select * from cach_ly left join nhan_khau nk on cach_ly.id_nhankhau = nk.ID";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();


            //old
            while (rs.next()){
                CachLyBean cachLyBean = new CachLyBean();

                CachLyModel cachly = cachLyBean.getCachLyModel();
                NhanKhauModel nhanKhauModel = cachLyBean.getNhanKhauModel();
                nhanKhauModel.setHoTen(rs.getString("hoTen"));
                nhanKhauModel.setID(rs.getInt("ID"));
                cachly.setCachly_id(rs.getInt("id_cachly"));

                cachly.setTgian_bat_dau(rs.getDate("tgian_bat_dau"));
                cachly.setMuc_do_cach_ly(rs.getString("muc_do_cach_ly"));
                cachly.setIs_tested(rs.getBoolean("is_tested"));
                cachly.setNhankhau_id(rs.getInt("id_nhankhau"));

                list.add(cachLyBean);
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    //Tìm kiếm
    public List<CachLyBean> search(String keyword) {
        List<CachLyBean> list = new  ArrayList<>();
        String query;
        if (keyword.trim().isEmpty()) {
            return getListCachLyBeans("");
        }
        // truy cap db
        // create query
        try {
            long a = Long.parseLong(keyword);
            query = "SELECT * "
                    + "FROM cach_ly as cl "
                    + "INNER JOIN nhan_khau as nk "
                    + "ON nk.ID = cl.id_nhankhau "
                    + "Inner join chung_minh_thu "
                    + "on nk.ID = chung_minh_thu.idNhanKhau "
                    + "WHERE chung_minh_thu.soCMT LIKE '%"
                    + keyword
                    + "%'";
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM cach_ly "
                    + "inner join nhan_khau as nk1 "
                    + "on nk1.ID = cach_ly.id_nhankhau "
                    + "WHERE nk1.hoTen LIKE '%"
                    + keyword
                    + "%'";
        }

        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                CachLyBean cachLyBean = new CachLyBean();
                CachLyModel cachly = cachLyBean.getCachLyModel();
                NhanKhauModel nhanKhauModel = cachLyBean.getNhanKhauModel();
                nhanKhauModel.setHoTen(rs.getString("hoTen"));
                nhanKhauModel.setID(rs.getInt("ID"));
                cachly.setCachly_id(rs.getInt("id_cachly"));
                cachly.setTgian_bat_dau(rs.getDate("tgian_bat_dau"));
                cachly.setMuc_do_cach_ly(rs.getString("muc_do_cach_ly"));
                cachly.setIs_tested(rs.getBoolean("is_tested"));
                cachly.setNhankhau_id(rs.getInt("id_nhankhau"));

                list.add(cachLyBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            mysqlException.printStackTrace();
        }
        return list;
    }

    private void exceptionHandle(String message){
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
