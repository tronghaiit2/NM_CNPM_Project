/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import models.CachLyModel;
import models.NhanKhauModel;
import models.Test;
import models.NhanKhauCachLy;
/**
 *
 * @author Admin
 */
public class CachLyBean {
    private CachLyModel cachLyModel;
    private Test test;
    private NhanKhauCachLy nhanKhauCachLy;
    private NhanKhauModel nhanKhauModel;

    public CachLyBean(CachLyModel cachLyModel, Test test, NhanKhauCachLy nhanKhauCachLy) {
        this.cachLyModel = cachLyModel;
        this.test = test;
        this.nhanKhauCachLy = nhanKhauCachLy;
    }

    public CachLyBean(){
        this.cachLyModel = new CachLyModel();
        this.nhanKhauCachLy = new NhanKhauCachLy();
        this.nhanKhauModel = new NhanKhauModel();
    }

    public CachLyModel getCachLy() {
        return cachLyModel;
    }

    public void setCachLy(CachLyModel cachLyModel) {
        this.cachLyModel = cachLyModel;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public NhanKhauCachLy getNhanKhauCachLy() {
        return nhanKhauCachLy;
    }

    public void setNhanKhauCachLy(NhanKhauCachLy nhanKhauCachLy) {
        this.nhanKhauCachLy = nhanKhauCachLy;
    }

    public NhanKhauModel getNhanKhauModel() {
        return nhanKhauModel;
    }

    public void setNhanKhauModel(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }
}
