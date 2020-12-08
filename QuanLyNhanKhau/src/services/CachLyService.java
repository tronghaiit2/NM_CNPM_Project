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
import models.CachLy;

/**
 *
 * @author Dung
 */
public class CachLyService {
    public List<CachLyBean> getListCachLyBeans() {
        List<CachLyBean> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            
            //need fix query
            String query = "SELECT * FROM test t JOIN nhan_khau nk ON t.id = nk.ID JOIN cach_ly cl ON t.cachly_id = cl.id ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                CachLyBean cachLyBean = new CachLyBean();
                CachLy cachly = cachLyBean.getCachLy();
                //NhanKhauModel nhanKhauModel = testBean.getNhanKhauModel();
                cachly.setId(rs.getInt("id"));
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
