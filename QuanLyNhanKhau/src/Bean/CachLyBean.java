/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import models.CachLy;
import models.Test;
import models.NhanKhauCachLy;
/**
 *
 * @author Admin
 */
public class CachLyBean {
    private CachLy cachLy;
    private Test test;
    private NhanKhauCachLy nhanKhauCachLy;

    public CachLyBean(CachLy cachLy, Test test, NhanKhauCachLy nhanKhauCachLy) {
        this.cachLy = cachLy;
        this.test = test;
        this.nhanKhauCachLy = nhanKhauCachLy;
    }

    public CachLyBean(){
        this.cachLy = new CachLy();
        this.nhanKhauCachLy = new NhanKhauCachLy();
    }

    public CachLy getCachLy() {
        return cachLy;
    }

    public void setCachLy(CachLy cachLy) {
        this.cachLy = cachLy;
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

}
