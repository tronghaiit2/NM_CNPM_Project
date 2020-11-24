/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hieppm
 */
public class NhanKhauCachLy {
    private int id;
    private int cachly_id;
    private int nhankhau_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCachly_id() {
        return cachly_id;
    }

    public void setCachly_id(int cachly_id) {
        this.cachly_id = cachly_id;
    }

    public int getNhankhau_id() {
        return nhankhau_id;
    }

    public void setNhankhau_id(int nhankhau_id) {
        this.nhankhau_id = nhankhau_id;
    }


}
