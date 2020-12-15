/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.CachLyManagerController;

import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import services.NhanKhauService;
import utility.ClassTableModel;

/**
 *
 * @author DungLHT
 */
public class ChooseCachLyController {
    private NhanKhauBean nhanKhauBean;
    private JTextField searchJtf;
    private JTextField selectedJtf;
    private JPanel tablePanel;
    private List<NhanKhauBean> listNhanKhauBeans;
    private final NhanKhauService nhanKhauService = new NhanKhauService();
    private final ClassTableModel classTableModel = new ClassTableModel();
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay"};
    public ChooseCachLyController(NhanKhauBean nhanKhauBean, JTextField jtfSearch, JTextField selectedJtf, JPanel tablePanel) {
        this.nhanKhauBean = nhanKhauBean;
        this.selectedJtf = selectedJtf;
        this.tablePanel = tablePanel;
        this.searchJtf = jtfSearch;
        //classTableModel = new ClassTableModel();
        //this.nhanKhauService = new NhanKhauService();
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
        //initAction();
        setDataTable();
    }
    public ChooseCachLyController(){}

    public void setDataTable() {

        List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }

        };

        // thiet ke bang

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    JOptionPane.showMessageDialog(null, "Chọn thành công!");
                }
                NhanKhauBean temp = listNhanKhauBeans.get(table.getSelectedRow());
                nhanKhauBean.setNhanKhauModel(temp.getNhanKhauModel());
                selectedJtf.setText(nhanKhauBean.getNhanKhauModel().getHoTen());
            }
        });

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        tablePanel.removeAll();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scroll);
        tablePanel.validate();
        tablePanel.repaint();
    }
}
