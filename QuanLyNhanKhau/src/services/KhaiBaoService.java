package services;

import Bean.KhaiBaoBean;
import models.KhaiBao;
import models.NhanKhauModel;

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
                query = "SELECT * FROM khai_bao join nhan_khau on khai_bao.id_nhankhau = nhan_khau.ID\n";
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



}
