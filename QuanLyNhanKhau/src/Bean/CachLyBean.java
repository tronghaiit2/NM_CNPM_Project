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
 * @author DungLHT
 */
public class CachLyBean {
    private CachLyModel cachLyModel;
    private NhanKhauCachLy nhanKhauCachLy;
    private NhanKhauModel nhanKhauModel;

    public CachLyBean(CachLyModel cachLyModel, NhanKhauModel nhanKhauModel) {
        this.cachLyModel = cachLyModel;
        this.nhanKhauModel = nhanKhauModel;
    }

    public CachLyBean(){
        this.cachLyModel = new CachLyModel();
        this.nhanKhauModel = new NhanKhauModel();
    }

    public CachLyModel getCachLyModel() {
        return cachLyModel;
    }

    public void setCachLyModel(CachLyModel cachLyModel) {
        this.cachLyModel = cachLyModel;
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
