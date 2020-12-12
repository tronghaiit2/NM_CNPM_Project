-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema quan_ly_nhan_khau
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema quan_ly_nhan_khau
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `quan_ly_nhan_khau` DEFAULT CHARACTER SET latin1 ;
USE `quan_ly_nhan_khau` ;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(50) NOT NULL,
  `passwd` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`nhan_khau`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`nhan_khau` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `maNhanKhau` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `hoTen` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `bietDanh` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `namSinh` DATE NULL DEFAULT NULL,
  `gioiTinh` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `noiSinh` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `nguyenQuan` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `danToc` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `tonGiao` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `quocTich` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `soHoChieu` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `noiThuongTru` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `diaChiHienNay` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `trinhDoHocVan` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `TrinhDoChuyenMon` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `bietTiengDanToc` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `trinhDoNgoaiNgu` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngheNghiep` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `noiLamViec` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `tienAn` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngayChuyenDen` DATE NULL DEFAULT NULL,
  `lyDoChuyenDen` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngayChuyenDi` DATE NULL DEFAULT NULL,
  `lyDoChuyenDi` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `diaChiMoi` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngayTao` DATE NULL DEFAULT NULL,
  `idNguoiTao` INT(11) NULL DEFAULT NULL,
  `ngayXoa` DATE NULL DEFAULT NULL,
  `idNguoiXoa` INT(11) NULL DEFAULT NULL,
  `lyDoXoa` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ghiChu` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idNguoiTao` (`idNguoiTao` ASC) ,
  INDEX `idNguoiXoa` (`idNguoiXoa` ASC) ,
  FULLTEXT INDEX `hoTen` (`hoTen`, `bietDanh`) ,
  CONSTRAINT `nhan_khau_ibfk_1`
    FOREIGN KEY (`idNguoiTao`)
    REFERENCES `quan_ly_nhan_khau`.`users` (`ID`),
  CONSTRAINT `nhan_khau_ibfk_2`
    FOREIGN KEY (`idNguoiXoa`)
    REFERENCES `quan_ly_nhan_khau`.`users` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`chung_minh_thu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`chung_minh_thu` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` INT(11) NULL DEFAULT NULL,
  `soCMT` VARCHAR(12) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `ngayCap` DATE NULL DEFAULT NULL,
  `noiCap` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idNhanKhau` (`idNhanKhau` ASC) ,
  FULLTEXT INDEX `soCMT` (`soCMT`) ,
  CONSTRAINT `chung_minh_thu_ibfk_1`
    FOREIGN KEY (`idNhanKhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`ho_khau`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`ho_khau` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `maHoKhau` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `idChuHo` INT(11) NULL DEFAULT NULL,
  `maKhuVuc` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `diaChi` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngayLap` DATE NULL DEFAULT NULL,
  `ngayChuyenDi` DATE NULL DEFAULT NULL,
  `lyDoChuyen` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `nguoiThucHien` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idChuHo` (`idChuHo` ASC) ,
  FULLTEXT INDEX `maHoKhau` (`maHoKhau`) ,
  CONSTRAINT `ho_khau_ibfk_1`
    FOREIGN KEY (`idChuHo`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`dinh_chinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`dinh_chinh` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `idHoKhau` INT(11) NULL DEFAULT NULL,
  `thongTinThayDoi` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `thayDoiTu` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `thayDoiThanh` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngayThayDoi` DATE NULL DEFAULT NULL,
  `nguoiThayDoi` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idHoKhau` (`idHoKhau` ASC) ,
  INDEX `nguoiThayDoi` (`nguoiThayDoi` ASC) ,
  CONSTRAINT `dinh_chinh_ibfk_1`
    FOREIGN KEY (`idHoKhau`)
    REFERENCES `quan_ly_nhan_khau`.`ho_khau` (`ID`),
  CONSTRAINT `dinh_chinh_ibfk_2`
    FOREIGN KEY (`nguoiThayDoi`)
    REFERENCES `quan_ly_nhan_khau`.`users` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`gia_dinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`gia_dinh` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` INT(11) NULL DEFAULT NULL,
  `hoTen` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `namSinh` DATE NULL DEFAULT NULL,
  `gioiTinh` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `quanHeVoiNhanKhau` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngheNghiep` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `diaChiHienTai` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idNhanKhau` (`idNhanKhau` ASC) ,
  CONSTRAINT `gia_dinh_ibfk_1`
    FOREIGN KEY (`idNhanKhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 34
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`khai_tu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`khai_tu` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `soGiayKhaiTu` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `idNguoiKhai` INT(11) NULL DEFAULT NULL,
  `idNguoiChet` INT(11) NULL DEFAULT NULL,
  `ngayKhai` DATE NULL DEFAULT NULL,
  `ngayChet` DATE NULL DEFAULT NULL,
  `lyDoChet` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idNguoiKhai` (`idNguoiKhai` ASC) ,
  INDEX `idNguoiChet` (`idNguoiChet` ASC) ,
  CONSTRAINT `khai_tu_ibfk_1`
    FOREIGN KEY (`idNguoiKhai`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`),
  CONSTRAINT `khai_tu_ibfk_2`
    FOREIGN KEY (`idNguoiChet`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`tam_tru`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`tam_tru` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` INT(11) NULL DEFAULT NULL,
  `maGiayTamtru` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `soDienThoaiNguoiDangKy` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `tuNgay` DATE NOT NULL,
  `denNgay` DATE NOT NULL,
  `lyDo` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idNhanKhau` (`idNhanKhau` ASC) ,
  CONSTRAINT `tam_tru_ibfk_1`
    FOREIGN KEY (`idNhanKhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`tam_vang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`tam_vang` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` INT(11) NULL DEFAULT NULL,
  `maGiayTamVang` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `noiTamtru` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `tuNgay` DATE NULL DEFAULT NULL,
  `denNgay` DATE NULL DEFAULT NULL,
  `lyDo` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idNhanKhau` (`idNhanKhau` ASC) ,
  CONSTRAINT `tam_vang_ibfk_1`
    FOREIGN KEY (`idNhanKhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`thanh_vien_cua_ho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`thanh_vien_cua_ho` (
  `idNhanKhau` INT(11) NOT NULL,
  `idHoKhau` INT(11) NOT NULL,
  `quanHeVoiChuHo` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`idNhanKhau`, `idHoKhau`),
  INDEX `idHoKhau` (`idHoKhau` ASC) ,
  CONSTRAINT `thanh_vien_cua_ho_ibfk_1`
    FOREIGN KEY (`idNhanKhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`),
  CONSTRAINT `thanh_vien_cua_ho_ibfk_2`
    FOREIGN KEY (`idHoKhau`)
    REFERENCES `quan_ly_nhan_khau`.`ho_khau` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`tieu_su`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`tieu_su` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` INT(11) NULL DEFAULT NULL,
  `tuNgay` DATE NULL DEFAULT NULL,
  `denNgay` DATE NULL DEFAULT NULL,
  `diaChi` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ngheNghiep` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `noiLamViec` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `idNhanKhau` (`idNhanKhau` ASC) ,
  CONSTRAINT `tieu_su_ibfk_1`
    FOREIGN KEY (`idNhanKhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `chung_minh_thu` (`ID`, `idNhanKhau`, `soCMT`, `ngayCap`, `noiCap`) VALUES
(13, 26, '000000000001', NULL, NULL),
(14, 27, '000000000002', NULL, NULL),
(15, 28, '000000000003', NULL, NULL),
(16, 29, '000000000004', NULL, NULL),
(17, 30, '000000000005', NULL, NULL),
(18, 31, '000000000006', NULL, NULL),
(19, 32, '000000000007', NULL, NULL),
(20, 33, '000000000008', NULL, NULL),
(21, 34, '000000000009', NULL, NULL),
(22, 35, '100000000001', NULL, NULL),
(23, 36, '100000000002', NULL, NULL),
(24, 37, '000000000010', NULL, NULL),
(25, 38, '000000000011', NULL, NULL);

INSERT INTO `gia_dinh` (`ID`, `idNhanKhau`, `hoTen`, `namSinh`, `gioiTinh`, `quanHeVoiNhanKhau`, `ngheNghiep`, `diaChiHienTai`) VALUES
(2, 27, 'Nguyễn Minh Quân', '1995-05-31', 'Nam', 'Chồng', 'Kỹ sư', 'Số 2 Tạ Quang Bửu, Hai Bà Trưng, Hà Nội'),
(3, 28, 'Trần Thanh Duyên', '1997-12-23', 'Nữ', 'Vợ', 'Nhân viên văn phòng', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(4, 29, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Vợ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(5, 29, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Con trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(6, 29, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Con gái', 'Luật sư', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(7, 30, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Chồng', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(8, 30, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Con trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(9, 30, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Con Gái', 'Luật sư', ''),
(10, 31, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Bố', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(11, 31, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Mẹ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(12, 31, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Em gái', 'Luật sư', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(13, 32, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Bố', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(14, 32, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Mẹ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(15, 32, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Anh trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(16, 33, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ', 'Vợ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(17, 33, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Con trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(18, 33, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Con gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(19, 34, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Con trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(20, 34, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Con gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(21, 34, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Chồng', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(22, 35, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Bố', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(23, 35, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ', 'Mẹ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(24, 35, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Em gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(25, 36, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Bố', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(26, 36, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ ', 'Mẹ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(27, 36, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Anh trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(28, 37, 'Bùi Thị Hà', '1948-02-03', 'Nữ', 'Vợ', 'Nội trợ', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(29, 37, 'Lý Thành Nam', '1968-06-12', 'Nam', 'Con Trai', 'Công nhân', 'Số 89, ngõ 98 Trường Chinh, Hà Nội'),
(30, 37, 'Lý Thu Thủy', '1971-03-05', 'Nữ', 'Con Gái', 'Nhân viên văn phòng', 'Số 3, ngõ 568 Đường Láng, Hà Nội'),
(31, 38, 'Lý Văn Công', '1945-06-04', 'Nam', 'Chồng', 'Bộ đội về hưu', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(32, 38, 'Lý Thành Nam', '1968-06-12', 'Nam', 'Con trai', 'Công nhân', 'Số 89, ngõ 98 Trường Chinh, Hà Nội'),
(33, 38, 'Lý Thu Thủy', '1971-03-05', 'Nữ', 'Con gái', 'Nhân viên văn phòng', 'Số 3, ngõ 568 Đường Láng, Hà Nội');

INSERT INTO `ho_khau` (`ID`, `maHoKhau`, `idChuHo`, `maKhuVuc`, `diaChi`, `ngayLap`, `ngayChuyenDi`, `lyDoChuyen`, `nguoiThucHien`) VALUES
(13, 'TQB002', 28, 'HN03', 'Số 2 Tạ Quang Bửu, quần Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL),
(14, 'TQB001', 26, 'HN03', 'Số 1 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL),
(15, 'TQB003', 29, 'HN03', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL),
(16, 'TQB004', 33, 'HN03', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL);

INSERT INTO `nhan_khau` (`ID`, `maNhanKhau`, `hoTen`, `bietDanh`, `namSinh`, `gioiTinh`, `noiSinh`, `nguyenQuan`, `danToc`, `tonGiao`, `quocTich`, `soHoChieu`, `noiThuongTru`, `diaChiHienNay`, `trinhDoHocVan`, `TrinhDoChuyenMon`, `bietTiengDanToc`, `trinhDoNgoaiNgu`, `ngheNghiep`, `noiLamViec`, `tienAn`, `ngayChuyenDen`, `lyDoChuyenDen`, `ngayChuyenDi`, `lyDoChuyenDi`, `diaChiMoi`, `ngayTao`, `idNguoiTao`, `ngayXoa`, `idNguoiXoa`, `lyDoXoa`, `ghiChu`) VALUES
(26, 'TA26', 'Trinh Văn An', '', '1990-12-07', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình đọ B', 'Giáo Viên', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(27, 'TD27', 'Trần Thanh Duyên', '', '1997-12-23', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3, đường Đình Đông, phường Đình Đông, quận Ngô Quyền, Hải Phòng', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Nhân viên văn phòng', 'Công ty ABC', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(28, 'NQ28', 'Nguyễn Minh Quân', '', '1995-05-31', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Kỹ sư', 'Viettel', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(29, 'ND29', 'Nguyễn Tiến Dũng', '', '1964-06-03', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'Không', 'Không', 'Phó giám đốc', 'Công ty EXE', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(30, 'VL30', 'Vũ Mỹ Linh', '', '1965-12-06', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12', 'Cử Nhân', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(31, 'ND31', 'Nguyễn Tiến Đạt', '', '1990-09-09', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'không', 'Anh trình độ C', 'Kỹ sư điện', 'Công ty điện EVN', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(32, 'NM32', 'Nguyễn Trà My', '', '1997-12-12', 'Nữ', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'không', 'Anh trình đố D', 'Luật sư', 'Văn phòng luật sư 123', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(33, 'TN33', 'Trần Văn Nam', '', '1980-07-09', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Tiến sĩ', 'Không', 'Anh trình độ D', 'Giảng viên đại học', 'Đại học Bách khoa Hà Nội', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(34, 'NT34', 'Nguyễn Minh Tuyết', '', '1985-09-02', 'Nữ', NULL, 'Nam Định', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Bác sĩ', 'Bệnh viện quốc tế HJK', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(35, 'TK35', 'Trần Trung Kiên', '', '2008-12-25', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '6/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(36, 'TN36', 'Trần Thúy Ngọc', '', '2013-01-15', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '1/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường tiểu học Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(37, 'LC37', 'Lý Văn Công', '', '1945-06-04', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12 chính quy', 'Không', 'Không', 'Không', 'Về hưu', 'Không', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(38, 'BH38', 'Bùi Thị Hà', '', '1948-02-03', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12', 'Không', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);

INSERT INTO `thanh_vien_cua_ho` (`idNhanKhau`, `idHoKhau`, `quanHeVoiChuHo`) VALUES
(26, 14, 'Chủ hộ'),
(27, 13, 'Vợ'),
(29, 15, 'Chủ hộ'),
(30, 15, 'Vợ'),
(31, 15, 'Con trai'),
(32, 15, 'Con gái'),
(33, 16, 'Chủ hộ'),
(34, 16, 'Vợ'),
(35, 16, 'Con trai'),
(36, 16, 'Con gái');

INSERT INTO `tieu_su` (`ID`, `idNhanKhau`, `tuNgay`, `denNgay`, `diaChi`, `ngheNghiep`, `noiLamViec`) VALUES
(2, 27, '2015-09-05', '2015-09-05', 'Số 45, ngõ 56, Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Viên', 'Đại học Thương mại'),
(3, 28, '2012-09-05', '2017-09-05', '556 La Thành, Hà Nội', 'Sinh Viên', 'Đại học Bách khoa Hà Nội'),
(4, 29, '1989-05-10', '2000-08-25', 'Số 5 Nguyễn Khuyến, Hà Nội', 'Quản lý nhận sự', 'Công ty BCC'),
(5, 30, '1987-05-23', '1997-03-01', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Nhân viên văn phòng', 'Công ty Zezs'),
(6, 31, '2008-09-05', '2013-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Bách khoa Hà Nội'),
(7, 32, '2015-09-05', '2019-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Luật Hà Nội'),
(8, 33, '1998-09-05', '2003-09-05', 'Số 66, ngõ 445 Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Vvên', 'Đại học Bách khoa Hà Nội'),
(9, 33, '2003-10-03', '2018-08-06', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Giảng viên', 'Đại học Công ngiệp Hà Nội'),
(10, 34, '2003-09-05', '2011-09-05', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Sinh viên', 'Đại học Y Hà Nội'),
(11, 34, '2011-10-03', '2015-08-09', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Bác sĩ nội trú', 'Bệnh viện Bạch Mai'),
(12, 37, '1961-01-01', '1963-01-01', 'Không rõ', 'Bộ đội', 'Hà Nội');

INSERT INTO `users` (`ID`, `userName`, `passwd`) VALUES
(1, 'admin', '1');



-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`khai_bao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`khai_bao` (
  `id_khaibao` INT(11) NOT NULL auto_increment,
  `id_nhankhau` INT(11) NOT NULL,
  `vung_dich` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `bieu_hien` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `ngay_khai_bao` DATE NOT NULL,
  PRIMARY KEY (`id_khaibao`),
  INDEX `fk_nhankhau_id_1` (`id_nhankhau` ASC) ,
  CONSTRAINT `fk_nhankhau_khaibao`
    FOREIGN KEY (`id_nhankhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`cach_ly`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`cach_ly` (
  `id_cachly` INT(11) NOT NULL auto_increment,
  `id_nhankhau` INT(11) NOT NULL,
  `noi_cach_ly` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `tgian_bat_dau` DATETIME NOT NULL,
  `muc_do_cach_ly` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `is_tested` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_cachly`),
    INDEX `fk_nhankhau_id_2` (`id_nhankhau` ASC) ,
  CONSTRAINT `fk_nhankhau_cachly`
    FOREIGN KEY (`id_nhankhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `quan_ly_nhan_khau`.`test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quan_ly_nhan_khau`.`test` (
  `id_test` INT(11) NOT NULL auto_increment,
  `id_nhankhau` INT(11) NOT NULL,
  `thoi_diem_test` DATETIME NOT NULL,
  `hinh_thuc_test` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `ket_qua` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  PRIMARY KEY (`id_test`),
	INDEX `fk_nhankhau_id_3` (`id_nhankhau` ASC) ,
  CONSTRAINT `fk_nhankhau_test`
    FOREIGN KEY (`id_nhankhau`)
    REFERENCES `quan_ly_nhan_khau`.`nhan_khau` (`ID`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO `khai_bao` VALUES (1,30,'Đà Nẵng','ốm, sốt','2020-12-08 08:20:00');
INSERT INTO `cach_ly` VALUES (1,30, 'Bệnh viện Thanh Nhàn','2020-12-09 09:00:00','F1',1);
INSERT INTO `test` VALUES (1,30,'2020-12-09 07:00:00','nhanh','âm tính');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;