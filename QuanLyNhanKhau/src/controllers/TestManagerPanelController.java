/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Bean.TestBean;
import services.TestService;
import utility.ClassTableModel;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author ducnm
 */
public class TestManagerPanelController {
       private JPanel jpnView;
       private JTextField jtfSearch;
       private TestService testService;
       private List<TestBean> listTestBeans;
       private ClassTableModel classTableModel =null;
       private final String[] COLUMNS = {"Mã test", "ID nhân khẩu", "Thời điểm", "Hình thức", "Kết quả", "Mã cách ly" };

       public TestManagerPanelController(JPanel jpnView, JTextField jtfSearch){
              this.jpnView = jpnView;
              this.jtfSearch = jtfSearch;
              classTableModel = new ClassTableModel();
              this.testService = new TestService();
              this.listTestBeans = this.testService.getListTestBeans();
       }
       public TestManagerPanelController(){
       }
}

