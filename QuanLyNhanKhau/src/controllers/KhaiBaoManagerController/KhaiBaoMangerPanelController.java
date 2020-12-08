package controllers.KhaiBaoManagerController;

import Bean.KhaiBaoBean;
import models.KhaiBao;
import services.KhaiBaoService;
import utility.ClassTableModel;
import views.infoViews.InfoJframe;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class KhaiBaoMangerPanelController {
    private final String[] COLUMNS = { "Họ tên", "Mã nhân khẩu", "Ngày sinh", "Giới tính", "Biểu hiện", "Vùng dịch"};
    private JPanel jpnView;
    private JTextField jtfSearch = new JTextField("");
    private KhaiBaoService khaiBaoService;
    private List<KhaiBaoBean> khaiBaoBeanList;
    private ClassTableModel classTableModel;
    private JFrame parentJFrame;

    public KhaiBaoMangerPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.khaiBaoService = new KhaiBaoService();
        this.khaiBaoBeanList = this.khaiBaoService.getListKhaiBao("");
        initAction();
    }

    public void initAction() {
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // What to do
                String key = jtfSearch.getText();
                khaiBaoBeanList = khaiBaoService.getListKhaiBao(key);
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // what to do
                String key = jtfSearch.getText();
                khaiBaoBeanList = khaiBaoService.getListKhaiBao(key);
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // what to do
                String key = jtfSearch.getText();
                khaiBaoBeanList = khaiBaoService.getListKhaiBao(key);
                setDataTable();
            }
        });
    }

    public void setDataTable() {
        DefaultTableModel model = classTableModel.setTableKhaiBaoBean(khaiBaoBeanList, COLUMNS);

        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }

        };

        // thiet ke bang
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        System.out.println(table.getValueAt(0, 0));
        table.getTableHeader().setPreferredSize(new Dimension(120, 50));
        table.setRowHeight(55);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
      //          JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    KhaiBaoBean temp = khaiBaoBeanList.get(table.getSelectedRow());
                    KhaiBaoBean info;
                    info = (KhaiBaoBean) khaiBaoService.getListKhaiBao(temp.getNhanKhauModel().getHoTen());
                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
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

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }

    public void refreshData(){
        this.khaiBaoBeanList = this.khaiBaoService.getListKhaiBao("");
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
