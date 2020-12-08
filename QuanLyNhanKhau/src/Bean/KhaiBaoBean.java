/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;

import models.GiaDinhModel;
import models.KhaiBao;
import models.NhanKhauModel;
import models.TieuSuModel;

/**
 * @author hieppm
 */
public class KhaiBaoBean {
    private NhanKhauModel nhanKhauModel;
    private KhaiBao khaiBaoModel;

    public NhanKhauModel getNhanKhauModel() {
        return nhanKhauModel;
    }

    public void setNhanKhauModel(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }

    public KhaiBao getKhaiBaoModel() {
        return khaiBaoModel;
    }

    public void setKhaiBaoModel(KhaiBao khaiBaoModel) {
        this.khaiBaoModel = khaiBaoModel;
    }

    public KhaiBaoBean(NhanKhauModel nhanKhauModel, KhaiBao khaiBaoModel) {
        this.nhanKhauModel = nhanKhauModel;
        this.khaiBaoModel = khaiBaoModel;
    }

    public KhaiBaoBean() {
        this.nhanKhauModel = new NhanKhauModel();
        this.khaiBaoModel = new KhaiBao();
    }
}
