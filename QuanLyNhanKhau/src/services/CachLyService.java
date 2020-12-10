/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Bean.CachLyBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.CachLyModel;
import models.NhanKhauModel;

/**
 *
 * @author Dung
 */
public class CachLyService {
    public List<CachLyBean> getListCachLyBeans() {
        List<CachLyBean> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query;

                //need fix query
            query = "SELECT * FROM cach_ly cl JOIN nhankhau_cachly nkcl ON nkcl.id_cachly = cl.id_cachly JOIN nhan_khau nk ON nkcl.id_nhankhau = nk.ID";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                CachLyBean cachLyBean = new CachLyBean();
                CachLyModel cachly = cachLyBean.getCachLy();
                NhanKhauModel nhanKhauModel = cachLyBean.getNhanKhauModel();

                //need fix column hoTen
                nhanKhauModel.setHoTen(rs.getString("hoTen"));
                cachly.setCachly_id(rs.getInt("id_cachly"));
                cachly.setTgian_bat_dau(rs.getDate("tgian_bat_dau"));
                cachly.setMuc_do_cach_ly(rs.getString("muc_do_cach_ly"));
                cachly.setIs_tested(rs.getBoolean("is_tested"));

                list.add(cachLyBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

//    public List<TestBean> search(String keyword){
//        List<TestBean> list = new ArrayList<>();
//        String query;
//        if (keyword.trim().isEmpty()){
//            return this.getListTestBeans();
//        }
//
//        try {
//
//        } catch (Exception e){
//
//        }
//        return list;
//    }

    private void exceptionHandle(String message){
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
