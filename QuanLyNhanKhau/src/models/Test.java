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
    private int id_nhankhau;
    private String hinh_thuc_test;

    public String getTenNguoiTest() {
        return tenNguoiTest;
    }

    public void setTenNguoiTest(String tenNguoiTest) {
        this.tenNguoiTest = tenNguoiTest;
    }

    private String tenNguoiTest;
    public int getId_nhankhau() {
        return id_nhankhau;
    }

    public void setId_nhankhau(int id_nhankhau) {
        this.id_nhankhau = id_nhankhau;
    }

    private Date thoi_diem_test;
    private String ket_qua;
    private int cachly_id;
    private int testId;

    public Test() {
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

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

    @Override
    public String toString(){
        String testString = id + " " + hinh_thuc_test + " " + thoi_diem_test + " " + ket_qua + " " + cachly_id + " " + testId;
        return testString;
    }
}
