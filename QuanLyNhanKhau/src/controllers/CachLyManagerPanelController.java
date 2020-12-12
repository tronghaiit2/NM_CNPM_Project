/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Bean.CachLyBean;
import Bean.NhanKhauBean;
import Bean.TestBean;
import models.CachLyModel;
import models.NhanKhauModel;
import models.Test;
import services.CachLyService;
import services.MysqlConnection;
import services.NhanKhauService;
import utility.ClassTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author DungLHT
 */
public class CachLyManagerPanelController {
    private JPanel jpnView;
    private JTextField jtfSearch;
    private CachLyService cachLyService;
    public List<CachLyBean> listCachLyBeans;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Họ tên","Mã nhân khẩu", "Mã cách ly", "Thời gian", "Mức độ", "Đã test?"};
    private JFrame parentJFrame;

    private NhanKhauService nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;
    private JButton deleteBtn;
    private CachLyBean cachLyBeanSelected;

    public CachLyManagerPanelController(JPanel jpnView, JTextField jtfSearch){
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.cachLyService = new CachLyService();
        this.listCachLyBeans = this.cachLyService.getListCachLyBeans("");
        initAction();
        //setDataTable();
    }

    public CachLyManagerPanelController(){
    }

    public void initAction() {
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // What to do
                String key = jtfSearch.getText();
                listCachLyBeans = cachLyService.search(key);
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // what to do
                String key = jtfSearch.getText();
                listCachLyBeans = cachLyService.search(key);
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // what to do
                String key = jtfSearch.getText();
                listCachLyBeans = cachLyService.search(key);
                setDataTable();
            }
        });
    }


    public void setDataTable(){
        /*
        DefaultTableModel model = classTableModel.setTableCachLy(listCachLyBeans , COLUMNS);

        JTable table = new JTable(model){
            @Override
            public boolean editCellAt(int row, int column, EventObject e){
                return false;
            }
        };

         */
        List<CachLyModel> listItem = new ArrayList<>();
        this.listCachLyBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getCachLyModel());
        });
        DefaultTableModel model = classTableModel.setTableCachLy(listCachLyBeans, COLUMNS);
        JTable table = new JTable(model) {
            @Override

            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
        };


        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMinWidth(150);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(100);


//              table.addMouseListener(new MouseAdapter() {
//                     @Override
//                     public void mouseClicked(MouseEvent e) {
//                            if (e.getClickCount()>1){
//                                   TestBean temp = listTestBeans.get(table.getSelectedRow());
//                                   //TestBean info = testService.getListTestBeans(temp.getNhanKhauModel());
//                            }
//                     }
//              });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              CachLyBean select = listCachLyBeans.get(table.getSelectedRow());
              cachLyBeanSelected = select;
              setCachLyBeanSelected(select);
            }
        });

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
        this.listCachLyBeans = this.cachLyService.getListCachLyBeans("");
        setDataTable();
    }

    public boolean xoaCachLy(CachLyBean cachLyBean) throws SQLException, ClassNotFoundException{
        CachLyModel cachLyModel = cachLyBean.getCachLyModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "DELETE FROM cach_ly WHERE id_cachly = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, cachLyModel.getCachly_id());
        preparedStatement.executeUpdate();
        connection.close();
        refreshData();
        return true;
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

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(JButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public CachLyBean getCachLyBeanSelected() {
        return cachLyBeanSelected;
    }

    public void setCachLyBeanSelected(CachLyBean cachLyBeanSelected) {
        this.cachLyBeanSelected = cachLyBeanSelected;
    }
}
