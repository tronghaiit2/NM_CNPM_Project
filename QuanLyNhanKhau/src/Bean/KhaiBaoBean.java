/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;

import models.GiaDinhModel;
import models.KhaiBao;
import models.NhanKhauModel;
import models.TieuSuModel;

/**
 * @author hieppm
 */
public class KhaiBaoBean {
    private NhanKhauModel nhanKhauModel;
    private KhaiBao khaiBaoModel;
    private List<GiaDinhModel> listGiaDinhModels;

    public NhanKhauModel getNhanKhauModel() {
        return nhanKhauModel;
    }

    public void setNhanKhauModel(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }

    public KhaiBao getKhaiBaoModel() {
        return khaiBaoModel;
    }

    public void setKhaiBaoModel(KhaiBao khaiBaoModel) {
        this.khaiBaoModel = khaiBaoModel;
    }

    public KhaiBaoBean(NhanKhauModel nhanKhauModel, KhaiBao khaiBaoModel) {
        this.nhanKhauModel = nhanKhauModel;
        this.khaiBaoModel = khaiBaoModel;
    }

    public KhaiBaoBean() {
        this.nhanKhauModel = new NhanKhauModel();
        this.khaiBaoModel = new KhaiBao();
    }

    @Override
    public String toString() {
        String res = "<html><style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                + "<h3>Thông tin cơ bản:"
                + "<p>Họ tên: <b>" + nhanKhauModel.getHoTen() + "</p>"
                + "<p>Năm sinh: <b>" + nhanKhauModel.getNamSinh() + "</p>"
                + "<p>Giới tính: <b>" + nhanKhauModel.getGioiTinh() + "</p>"
                + "<p>Nguyên Quán: <b>" + nhanKhauModel.getNguyenQuan() + "</p>"
                + "<p>Dân tộc: <b>" + nhanKhauModel.getDanToc() + "</p>"
                + "<p>Tôn giáo: <b>" + nhanKhauModel.getTonGiao() + "</p>"
                + "<p>Quốc tịch: <b>" + nhanKhauModel.getQuocTich() + "</p>";

        res += "</table><h4>Gia đình<table>"
                + "<tr>"
                + "<th>Họ tên</th>"
                + "<th>Ngày sinh</th>"
                + "<th>Giới tính</th>"
                + "<th>Quan hệ với nhân khẩu</th>"
                + "<th>Nghề nghiệp</th>"
                + "<th>Địa chỉ hiện tại</th>"
                + "</tr>";
        for (GiaDinhModel giaDinhModel : listGiaDinhModels) {
            res += "<tr>"
                    + "<td>"
                    + giaDinhModel.getHoTen()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getNamSinh().toString()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getGioiTinh()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getQuanHeVoiNhanKhau()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getNgheNghiep()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getDiaChiHienTai()
                    + "</td>"
                    + "</tr>";
        }
        res += "<h5> Khai báo thông tin liên quan đến dịch Covid 19:"
                + "<p> Đã đi đến vùng dịch hay chưa? Vùng nào ? <b>" + khaiBaoModel.getVung_dich() + "<p>"
                + "<p> Có biểu hiện gì bất thường hay không ? <b>" + khaiBaoModel.getBieu_hien() + "<p>"
                + "<p> Ngày khai báo: <b>" + khaiBaoModel.getNgay_khai_bao() + "<p>";

        res += "</table>"
                + "</div></html>";
        return res;
    }


}
