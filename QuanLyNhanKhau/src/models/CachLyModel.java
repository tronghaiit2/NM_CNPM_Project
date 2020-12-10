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
public class CachLyModel {
    private int id;
    private Date tgian_bat_dau;
    private String muc_do_cach_ly;
    private boolean is_tested;
    private int cachly_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTgian_bat_dau() {
        return tgian_bat_dau;
    }

    public void setTgian_bat_dau(Date tgian_bat_dau) {
        this.tgian_bat_dau = tgian_bat_dau;
    }

    public String getMuc_do_cach_ly() {
        return muc_do_cach_ly;
    }

    public void setMuc_do_cach_ly(String muc_do_cach_ly) {
        this.muc_do_cach_ly = muc_do_cach_ly;
    }

    public boolean isIs_tested() {
        return is_tested;
    }

    public void setIs_tested(boolean is_tested) {
        this.is_tested = is_tested;
    }

    public int getCachly_id() {
        return cachly_id;
    }

    public void setCachly_id(int cachly_id) {
        this.cachly_id = cachly_id;
    }


}
