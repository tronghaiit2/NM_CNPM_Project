package controllers.KhaiBaoManagerController;

import Bean.KhaiBaoBean;
import models.KhaiBao;
import models.NhanKhauModel;
import services.KhaiBaoService;
import services.MysqlConnection;
import utility.ClassTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.util.List;

/**
 * @author: hieppm
 */

public class KhaiBaoMangerPanelController {
    private final String[] COLUMNS = {"Họ tên", "ID nhân khẩu", "Ngày sinh", "Ngày khai báo", "Biểu hiện", "Vùng dịch"};
    public List<KhaiBaoBean> khaiBaoBeanList;
    private JPanel jpnView;
    private JTextField jtfSearch = new JTextField("");
    private KhaiBaoService khaiBaoService;
    private ClassTableModel classTableModel;
    private JFrame parentJFrame;
    private KhaiBaoBean khaiBaoBean;

    public KhaiBaoMangerPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.khaiBaoService = new KhaiBaoService();
        this.khaiBaoBeanList = this.khaiBaoService.getListKhaiBao("");
        initAction();
    }

    public KhaiBaoMangerPanelController() {
        initAction();
    }

    public String[] getCOLUMNS() {
        return COLUMNS;
    }

    public KhaiBaoService getKhaiBaoService() {
        return khaiBaoService;
    }

    public void setKhaiBaoService(KhaiBaoService khaiBaoService) {
        this.khaiBaoService = khaiBaoService;
    }

    public List<KhaiBaoBean> getKhaiBaoBeanList() {
        return khaiBaoBeanList;
    }

    public void setKhaiBaoBeanList(List<KhaiBaoBean> khaiBaoBeanList) {
        this.khaiBaoBeanList = khaiBaoBeanList;
    }

    public ClassTableModel getClassTableModel() {
        return classTableModel;
    }

    public void setClassTableModel(ClassTableModel classTableModel) {
        this.classTableModel = classTableModel;
    }

    public JFrame getParentJFrame() {
        return parentJFrame;
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }

    public KhaiBaoBean getKhaiBaoBean() {
        return khaiBaoBean;
    }

    public void setKhaiBaoBean(KhaiBaoBean khaiBaoBean) {
        this.khaiBaoBean = khaiBaoBean;
    }

    public void initAction() {
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // What to do
                String key = jtfSearch.getText();
                khaiBaoBeanList = khaiBaoService.search(key);
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // what to do
                String key = jtfSearch.getText();
                khaiBaoBeanList = khaiBaoService.search(key);
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // what to do
                String key = jtfSearch.getText();
                khaiBaoBeanList = khaiBaoService.search(key);
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
        table.getTableHeader().setPreferredSize(new Dimension(120, 50));
        table.setRowHeight(55);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMinWidth(120);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KhaiBaoBean temp = khaiBaoBeanList.get(table.getSelectedRow());
                khaiBaoBean = temp;
                System.out.println(khaiBaoBean.getNhanKhauModel().getID());
                setKhaiBaoBean(temp);
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

    public void refreshData() {
        this.khaiBaoBeanList = this.khaiBaoService.getListKhaiBao("");
        setDataTable();
    }


    public boolean xoaKhaiBao(KhaiBaoBean khaiBaoBean) throws SQLException, ClassNotFoundException {
        NhanKhauModel nhanKhauModel = khaiBaoBean.getNhanKhauModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "DELETE FROM khai_bao WHERE id_nhankhau = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, nhanKhauModel.getID());
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
}
