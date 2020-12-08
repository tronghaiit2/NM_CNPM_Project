/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author hieppm
 */
public class KhaiBao {
    private int id;
    private String vung_dich;
    private String bieu_hien;
    private Date ngay_khai_bao;
    private int nhankhau_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVung_dich() {
        return vung_dich;
    }

    public void setVung_dich(String vung_dich) {
        this.vung_dich = vung_dich;
    }

    public String getBieu_hien() {
        return bieu_hien;
    }

    public void setBieu_hien(String bieu_hien) {
        this.bieu_hien = bieu_hien;
    }

    public java.sql.Date getNgay_khai_bao() {
        return ngay_khai_bao;
    }

    public void setNgay_khai_bao(Date ngay_khai_bao) {
        this.ngay_khai_bao = ngay_khai_bao;
    }

    public int getNhankhau_id() {
        return nhankhau_id;
    }

    public void setNhankhau_id(int nhankhau_id) {
        this.nhankhau_id = nhankhau_id;
    }


}
