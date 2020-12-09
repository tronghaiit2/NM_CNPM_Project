package services;

import Bean.KhaiBaoBean;
import Bean.NhanKhauBean;
import models.ChungMinhThuModel;
import models.KhaiBao;
import models.NhanKhauModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class KhaiBaoService {
    public List<KhaiBaoBean> getListKhaiBao(String hoTen) {

        List<KhaiBaoBean> listKhaiBao = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query;
            if (hoTen != "") {
                query = String.format("SELECT * FROM khai_bao join nhan_khau on khai_bao.id_nhankhau = nhan_khau.ID where nhan_khau.hoTen = \'%s\' " , hoTen);
            } else {
                query = "SELECT * FROM khai_bao join nhan_khau on khai_bao.id_nhankhau = nhan_khau.ID";
            }

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                KhaiBaoBean khaiBaoBean = new KhaiBaoBean();
                KhaiBao khaiBao = khaiBaoBean.getKhaiBaoModel();
                NhanKhauModel nhanKhauModel = khaiBaoBean.getNhanKhauModel();
                nhanKhauModel.setID(rs.getInt("ID"));
                nhanKhauModel.setHoTen(rs.getString("hoTen"));
                nhanKhauModel.setMaNhanKhau(rs.getString("maNhanKhau"));
                nhanKhauModel.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhauModel.setNamSinh(rs.getDate("namSinh"));
                khaiBao.setNgay_khai_bao(rs.getDate("ngay_khai_bao"));
                khaiBao.setBieu_hien(rs.getString("bieu_hien"));
                khaiBao.setVung_dich(rs.getString("vung_dich"));

                listKhaiBao.add(khaiBaoBean);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e1) {
            e1.printStackTrace();

        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return listKhaiBao;
    }

    public void removeKhaiBao(String IDNhanKhau){
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query_turn_off_safe_mode = "SET SQL_SAFE_UPDATES = 0";
            PreparedStatement preparedStatement_safe_mode = (PreparedStatement) connection.prepareStatement(query_turn_off_safe_mode);
            preparedStatement_safe_mode.executeQuery();
            String query = String.format("delete from khai_bao where id_nhankhau = \'%s\'", IDNhanKhau);
            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query)) {
                int res = preparedStatement.executeUpdate(query);
                if (res == 1){
                    JOptionPane.showMessageDialog(null, "Xóa thành công ");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<KhaiBaoBean> search(String keyword) {
        List<KhaiBaoBean> list = new  ArrayList<>();
        String query;
        if (keyword.trim().isEmpty()) {
            return getListKhaiBao("");
        }
        // truy cap db
        // create query
        try {
            long a = Long.parseLong(keyword);
            query = "SELECT * "
                    + "FROM khai_bao as kb "
                    + "INNER JOIN nhan_khau as nk "
                    + "ON nk.ID = kb.id_nhankhau "
                    + "Inner join chung_minh_thu "
                    + "on nk.ID = chung_minh_thu.idNhanKhau "
                    + "WHERE chung_minh_thu.soCMT LIKE '%"
                    + keyword
                    + "%'";
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM khai_bao "
                    + "inner join nhan_khau as nk1 "
                    + "on nk1.ID = khai_bao.id_nhankhau "
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
                KhaiBaoBean temp = new KhaiBaoBean();
                NhanKhauModel nhanKhau = new NhanKhauModel();
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setMaNhanKhau(rs.getString("maNhanKhau"));
                KhaiBao khaiBao = new KhaiBao();
                khaiBao.setNgay_khai_bao(rs.getDate("ngay_khai_bao"));
                khaiBao.setVung_dich(rs.getString("vung_dich"));
                khaiBao.setBieu_hien(rs.getString("bieu_hien"));
                temp.setKhaiBaoModel(khaiBao);
                temp.setNhanKhauModel(nhanKhau);
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            mysqlException.printStackTrace();
        }
        return list;
    }




}
