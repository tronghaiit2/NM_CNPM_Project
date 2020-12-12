/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Bean.TestBean;
import models.Test;
import services.TestService;
import utility.ClassTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.EventObject;
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
       private ClassTableModel classTableModel = null;
       private final String[] COLUMNS = {"Mã test", "ID nhân khẩu", "Thời điểm", "Hình thức", "Kết quả" };
       private JFrame parentJFrame;
       public TestManagerPanelController(JPanel jpnView, JTextField jtfSearch){
              this.jpnView = jpnView;
              this.jtfSearch = jtfSearch;
              classTableModel = new ClassTableModel();
              this.testService = new TestService();
              this.listTestBeans = this.testService.getListTestBeans();
              //initAction();
       }
       public TestManagerPanelController(){
       }

//       public void initAction(){
//              this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
//                     @Override
//                     public void insertUpdate(DocumentEvent e) {
//                            String key = jtfSearch.getText();
//                            listTestBeans = testService.search(key);
//                     }
//
//                     @Override
//                     public void removeUpdate(DocumentEvent e) {
//
//                     }
//
//                     @Override
//                     public void changedUpdate(DocumentEvent e) {
//
//                     }
//              });
//       }

       public void setDataTable(){
              List<Test> listItem = new ArrayList<>();
              this.listTestBeans.forEach(test ->{
                     listItem.add(test.getTest());
              });
              DefaultTableModel model = classTableModel.setTableTest(listItem, COLUMNS);
              JTable table = new JTable(model){
                     @Override
                     public boolean editCellAt(int row, int column, EventObject e){
                            return false;
                     }
              };

              table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
              table.getTableHeader().setPreferredSize(new Dimension(100, 50));
              table.setRowHeight(50);
              table.validate();
              table.repaint();
              table.setFont(new Font("Arial", Font.PLAIN, 14));
              table.getColumnModel().getColumn(0).setMaxWidth(80);
              table.getColumnModel().getColumn(0).setMinWidth(80);
              table.getColumnModel().getColumn(0).setPreferredWidth(80);
//              table.addMouseListener(new MouseAdapter() {
//                     @Override
//                     public void mouseClicked(MouseEvent e) {
//                            if (e.getClickCount()>1){
//                                   TestBean temp = listTestBeans.get(table.getSelectedRow());
//                                   //TestBean info = testService.getListTestBeans(temp.getNhanKhauModel());
//                            }
//                     }
//              });
              JScrollPane scroll = new JScrollPane();
              scroll.getViewport().add(table);
              scroll.setPreferredSize(new Dimension(1350, 400));
              jpnView.removeAll();
              jpnView.setLayout(new BorderLayout());
              jpnView.add(scroll);
              jpnView.validate();
              jpnView.repaint();
       }
       public void setParentJFrame(JFrame parentJFrame){
              this.parentJFrame = parentJFrame;
       }

       public void refreshData(){
              this.listTestBeans = this.testService.getListTestBeans();
              setDataTable();
       }

       public JPanel getJpnView() {
              return jpnView;
       }

       public void setJpnView(JPanel jpnView) {
              this.jpnView = jpnView;
       }

       public JTextField getJtfSearch() {
              return jtfSearch;
       }

       public void setJtfSearch(JTextField jtfSearch) {
              this.jtfSearch = jtfSearch;
       }


}

