/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
/**
 *
 * @author hieppm
 */
public class Test {
    private int id;
    private String hinh_thuc_test;
    private Date thoi_diem_test;
    private String ket_qua;
    private int cachly_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinh_thuc_test() {
        return hinh_thuc_test;
    }

    public void setHinh_thuc_test(String hinh_thuc_test) {
        this.hinh_thuc_test = hinh_thuc_test;
    }

    public Date getThoi_diem_test() {
        return thoi_diem_test;
    }

    public void setThoi_diem_test(Date thoi_diem_test) {
        this.thoi_diem_test = thoi_diem_test;
    }

    public String getKet_qua() {
        return ket_qua;
    }

    public void setKet_qua(String ket_qua) {
        this.ket_qua = ket_qua;
    }

    public int getCachly_id() {
        return cachly_id;
    }

    public void setCachly_id(int cachly_id) {
        this.cachly_id = cachly_id;
    }


}
