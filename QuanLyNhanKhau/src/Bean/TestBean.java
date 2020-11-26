/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import models.Test;
import models.NhanKhauModel;
/**
 *
 * @author ducnm
 */
public class TestBean {
    private Test test;
    private NhanKhauModel nhanKhauModel;
    public TestBean(Test test, NhanKhauModel nhanKhauModel){
        this.test=test;
        this.nhanKhauModel=nhanKhauModel;
    }
    public TestBean(){
        this.test=new Test();
        this.nhanKhauModel=new NhanKhauModel();
    }
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public NhanKhauModel getNhanKhauModel() {
        return nhanKhauModel;
    }

    public void setNhanKhauModel(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }
    
    
}
