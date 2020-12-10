/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Bean.CachLyBean;
import Bean.NhanKhauBean;
import models.CachLyModel;
import services.CachLyService;
import services.NhanKhauService;
import utility.ClassTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author admins
 */
public class CachLyManagerPanelController {
    private JPanel jpnView;
    private JTextField jtfSearch;
    private CachLyService cachLyService;
    private List<CachLyBean> listCachLyBeans;
    private ClassTableModel classTableModel =null;
    private final String[] COLUMNS = {"Họ tên", "Mã cách ly", "Thời gian", "Mức độ", "Đã test?"};
    private JFrame parentJFrame;

    private NhanKhauService nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;

    public CachLyManagerPanelController(JPanel jpnView, JTextField jtfSearch){
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.cachLyService = new CachLyService();
        this.listCachLyBeans = this.cachLyService.getListCachLyBeans();
        //initAction();
    }

    public CachLyManagerPanelController(){
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
        List<CachLyModel> listItem = new ArrayList<>();
        this.listCachLyBeans.forEach(cachLy ->{
            listItem.add(cachLy.getCachLy());
        });
        DefaultTableModel model = classTableModel.setTableCachLy(listItem, COLUMNS);
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
        this.listCachLyBeans = this.cachLyService.getListCachLyBeans();
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
