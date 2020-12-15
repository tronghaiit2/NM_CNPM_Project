/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.KhaiBaoManagerFrame;

import Bean.KhaiBaoBean;
import com.toedter.calendar.JDateChooser;
import controllers.KhaiBaoManagerController.KhaiBaoMangerPanelController;
import controllers.KhaiBaoManagerController.ThemMoiKhaiBaoController;
import models.KhaiBao;
import models.NhanKhauModel;
import services.KhaiBaoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;

/**
 * @author hieppm
 */
public class ThemMoiKhaiBao extends javax.swing.JFrame {
    public int stateButton;
    private JFrame parentFrame;
    private KhaiBaoMangerPanelController parentController;
    private KhaiBaoBean khaiBaoBean;
    private ThemMoiKhaiBaoController controller;
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JButton selectButton;
    private SelectNhanKhau selectNhanKhau;
    private com.toedter.calendar.JDateChooser testTimeChooser;

    /**
     * Creates new form ThemMoiKhaiBao
     */
    public ThemMoiKhaiBao(JFrame parentFrame) throws HeadlessException {
        this.parentFrame = parentFrame;
        initComponents();
    }

    public ThemMoiKhaiBao() {
        this.stateButton = 0;
    }

    public ThemMoiKhaiBao(KhaiBaoMangerPanelController parentController, JFrame parentJFrame) {
        this.parentController = parentController;
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.khaiBaoBean = new KhaiBaoBean();
        this.testTimeChooser = new com.toedter.calendar.JDateChooser();
        initComponents();
        setTitle("Thêm mới khai báo dịch tễ");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new ThemMoiKhaiBaoController();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }

        });
    }

    public JDateChooser getTestTimeChooser() {
        return testTimeChooser;
    }

    public void setTestTimeChooser(JDateChooser testTimeChooser) {
        this.testTimeChooser = testTimeChooser;
    }

    public int getStateButton() {
        return stateButton;
    }

    public void setStateButton(int stateButton) {
        this.stateButton = stateButton;
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }

    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public KhaiBaoMangerPanelController getParentController() {
        return parentController;
    }

    public void setParentController(KhaiBaoMangerPanelController parentController) {
        this.parentController = parentController;
    }

    public KhaiBaoBean getKhaiBaoBean() {
        return khaiBaoBean;
    }

    public void setKhaiBaoBean(KhaiBaoBean khaiBaoBean) {
        this.khaiBaoBean = khaiBaoBean;
    }

    public ThemMoiKhaiBaoController getController() {
        return controller;
    }

    public void setController(ThemMoiKhaiBaoController controller) {
        this.controller = controller;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    public JButton getSelectButton() {
        return selectButton;
    }

    public void setSelectButton(JButton selectButton) {
        this.selectButton = selectButton;
    }

    public SelectNhanKhau getSelectNhanKhau() {
        return selectNhanKhau;
    }

    public void setSelectNhanKhau(SelectNhanKhau selectNhanKhau) {
        this.selectNhanKhau = selectNhanKhau;
    }

    void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jTextField8 = new JTextField();
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        selectButton = new JButton();
        selectNhanKhau = new SelectNhanKhau();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Họ tên:");

        jLabel2.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Mã nhân khẩu:");

        jLabel3.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("CMND:");

        jLabel4.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Ngày sinh :");

        jLabel5.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Giới tính:");

        jLabel6.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Ngày khai báo :");

        jLabel7.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Vùng dịch:");

        jLabel8.setFont(new Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Biểu hiện:");

        jButton1.setFont(new Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Hủy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
        });

        jButton2.setFont(new Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Thêm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateBtnActionPerformed(e);
                stateButton = 1;
            }
        });

        selectButton.setFont(new Font("Arial", 0, 14));
        selectButton.setText("Chọn");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonAction();
            }
        });


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(testTimeChooser, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(133, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addContainerGap()
                                .addComponent(selectButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(selectButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(testTimeChooser, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Thêm mới khai báo dịch tễ");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void CreateBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        int nhankhauID;

        KhaiBaoService khaiBaoService = new KhaiBaoService();

        nhankhauID = selectNhanKhau.khaiBaoBean1.getNhanKhauModel().getID();
        String maNhanKhau = selectNhanKhau.khaiBaoBean1.getNhanKhauModel().getMaNhanKhau();

        String hoTen = selectNhanKhau.khaiBaoBean1.getNhanKhauModel().getHoTen();

        String gioiTinh = selectNhanKhau.khaiBaoBean1.getNhanKhauModel().getGioiTinh();


        if (validateValueInForm()) {
            // tao moi 1 doi tuong nhan khau
            KhaiBao temp = new KhaiBao();
            NhanKhauModel nhanKhauModel = new NhanKhauModel();
            temp.setVung_dich(jTextField7.getText());
            temp.setBieu_hien(jTextField8.getText());
            temp.setNgay_khai_bao(convertUtilToSql(testTimeChooser.getDate()));
            temp.setNhankhau_id(nhankhauID);
            nhanKhauModel.setMaNhanKhau(maNhanKhau);
            nhanKhauModel.setHoTen(hoTen);
            nhanKhauModel.setGioiTinh(gioiTinh);
            this.khaiBaoBean.setKhaiBaoModel(temp);
            this.khaiBaoBean.setNhanKhauModel(nhanKhauModel);

            try {
                if (this.controller.themKhaiBao(this.khaiBaoBean)) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                    close();
                    parentController.refreshData();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_CreateBtnActionPerformed


    // check cac gia tri duoc nhap vao form
    private boolean validateValueInForm() {
        // check null
        if (jTextField1.getText().trim().isEmpty()
                || jTextField3.getText().trim().isEmpty()
                || jTextField4.getText().trim().isEmpty()
                || jTextField5.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public void setDataTextField(KhaiBaoBean khaiBaoBean) {
        KhaiBaoService khaiBaoService = new KhaiBaoService();
        this.jTextField1.setText(khaiBaoBean.getNhanKhauModel().getHoTen());
        this.jTextField1.setEnabled(false);
        jTextField3.setText(khaiBaoBean.getNhanKhauModel().getNamSinh().toString());
        jTextField3.setEnabled(false);

        String maNhanKhau = khaiBaoService.getMaNhanKhau(khaiBaoBean.getNhanKhauModel().getHoTen(), khaiBaoBean.getNhanKhauModel().getNamSinh().toString());
        this.jTextField5.setText(maNhanKhau);
        this.jTextField5.setEnabled(false);

        this.jTextField4.setText(khaiBaoBean.getNhanKhauModel().getGioiTinh());
        jTextField4.setEnabled(false);

        String cmt = khaiBaoService.getChungMinhThu(khaiBaoBean.getNhanKhauModel().getHoTen(), khaiBaoBean.getNhanKhauModel().getNamSinh().toString());
        jTextField2.setText(cmt);

        jTextField2.setEnabled(false);
    }


    public void ButtonAction() {
        selectNhanKhau = new SelectNhanKhau(khaiBaoBean, this);
        selectNhanKhau.setLocationRelativeTo(null);
        selectNhanKhau.setResizable(false);
        selectNhanKhau.setVisible(true);
    }
    // End of variables declaration                   
}
