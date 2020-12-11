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

import Bean.TestBean;
import models.CachLyModel;
import models.NhanKhauModel;
import models.Test;

/**
 *
 * @author Dung
 */
public class CachLyService {
    public static void main(String[] args){
        CachLyService cachLyService = new CachLyService();
        cachLyService.getListCachLyBeans();
    }
    public List<CachLyBean> getListCachLyBeans() {
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



    private void exceptionHandle(String message){
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
