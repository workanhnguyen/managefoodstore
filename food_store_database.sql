-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: foodstoredb
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban` (
  `MaBan` char(5) NOT NULL,
  `SoLuongChoNgoi` int NOT NULL,
  `TinhTrang` tinyint NOT NULL,
  PRIMARY KEY (`MaBan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
INSERT INTO `ban` VALUES ('BAN01',2,1),('BAN02',2,1),('BAN03',4,1),('BAN04',4,1),('BAN05',6,1),('BAN06',6,1),('BAN07',8,1),('BAN08',8,1),('BAN09',10,1),('BAN10',10,1);
/*!40000 ALTER TABLE `ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHoaDon` char(10) NOT NULL,
  `ThoiGian` datetime NOT NULL,
  `MaNV` char(10) NOT NULL,
  `MaBan` char(5) NOT NULL,
  `MaKhachHang` char(10) DEFAULT NULL,
  `GiamGia` int NOT NULL DEFAULT '0',
  `ThanhTien` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`MaHoaDon`),
  KEY `MaNV_idx` (`MaNV`),
  KEY `MaBan_idx` (`MaBan`),
  CONSTRAINT `MaBan` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`),
  CONSTRAINT `MaNV` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES ('HD00000001','2022-01-26 15:54:53','0395457430','BAN03','0704770902',0,115000),('HD00000002','2022-01-26 19:12:49','0395457430','BAN02','',0,135000),('HD00000003','2022-02-26 19:12:49','0395457430','BAN09','0395457432',0,60000),('HD00000004','2022-02-26 19:12:49','0395457430','BAN06','0704770902',0,120000),('HD00000005','2022-03-26 19:12:49','0395457430','BAN01','',0,40000),('HD00000006','2022-04-26 19:12:49','0395457430','BAN03','0395457432',32600,137400),('HD00000007','2021-11-26 19:12:49','0395457430','BAN06','0965484182',0,85000),('HD00000008','2021-11-26 19:12:49','0395457430','BAN07','0965484182',20850,184150),('HD00000009','2021-11-26 19:12:49','0395457430','BAN09','',0,40000),('HD00000010','2022-11-26 19:12:49','0395457430','BAN07','0393617000',0,70000),('HD00000011','2022-11-26 19:12:49','0395457430','BAN04','0976981453',0,50000),('HD00000012','2022-11-26 19:12:49','0395457430','BAN07','0393617000',0,20000),('HD00000013','2022-11-26 19:12:49','0395457430','BAN02','',0,60000),('HD00000014','2022-11-27 14:45:19','0395457430','BAN08','0395457432',0,140000),('HD00000015','2022-11-27 14:54:12','0395457430','BAN03','0706206292',0,80000),('HD00000016','2022-11-27 14:54:12','0395457430','BAN07','0329117042',0,80000),('HD00000017','2022-11-27 14:54:12','0395457430','BAN01','',0,80000),('HD00000018','2022-11-27 14:54:12','0395457430','BAN10','0329117042',0,35000),('HD00000019','2022-11-27 14:54:12','0395457430','BAN07','',0,40000),('HD00000020','2022-11-27 15:03:31','0395457430','BAN01','',0,35000),('HD00000021','2022-11-27 15:18:49','0395457430','BAN01','',0,70000),('HD00000022','2022-11-27 15:21:09','0395457430','BAN01','',0,30000),('HD00000023','2022-11-27 15:32:53','0395457430','BAN01','',0,40000),('HD00000024','2022-11-27 15:32:53','0395457430','BAN02','',0,35000),('HD00000025','2022-11-27 15:32:53','0395457430','BAN02','',0,20000),('HD00000026','2022-11-27 15:37:32','0395457430','BAN02','',0,20000),('HD00000027','2022-11-27 15:41:01','0395457430','BAN02','',0,60000),('HD00000028','2022-11-27 15:44:22','0395457430','BAN02','',0,80000),('HD00000029','2022-11-27 15:47:32','0395457430','BAN02','',0,35000),('HD00000030','2022-11-27 15:53:14','0395457430','BAN01','',0,40000),('HD00000031','2022-11-27 15:53:14','0395457430','BAN02','',0,60000),('HD00000032','2022-11-27 15:53:14','0395457430','BAN02','',0,100000),('HD00000033','2022-11-27 15:53:14','0395457430','BAN10','',0,65000),('HD00000034','2022-11-27 15:53:14','0395457430','BAN07','',0,50000),('HD00000035','2022-12-04 16:11:59','0395457430','BAN02','0312890890',0,20000);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon_monan`
--

DROP TABLE IF EXISTS `hoadon_monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon_monan` (
  `MaHoaDon` char(10) NOT NULL,
  `MaMonAn` char(5) NOT NULL,
  `SoLuong` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`MaHoaDon`,`MaMonAn`),
  KEY `MaMonAn_idx` (`MaMonAn`),
  CONSTRAINT `MaHoaDon` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`) ON DELETE CASCADE,
  CONSTRAINT `MaMA` FOREIGN KEY (`MaMonAn`) REFERENCES `monan` (`MaMonAn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon_monan`
--

LOCK TABLES `hoadon_monan` WRITE;
/*!40000 ALTER TABLE `hoadon_monan` DISABLE KEYS */;
INSERT INTO `hoadon_monan` VALUES ('HD00000001','MA002',1),('HD00000001','MA003',1),('HD00000001','MA004',1),('HD00000002','MA001',1),('HD00000002','MA003',2),('HD00000002','MA004',1),('HD00000003','MA001',1),('HD00000003','MA005',1),('HD00000004','MA002',2),('HD00000004','MA005',1),('HD00000005','MA001',1),('HD00000006','MA002',2),('HD00000006','MA004',2),('HD00000007','MA002',1),('HD00000007','MA004',1),('HD00000008','MA001',1),('HD00000008','MA002',1),('HD00000008','MA003',2),('HD00000008','MA004',1),('HD00000008','MA005',1),('HD00000009','MA001',1),('HD00000010','MA004',2),('HD00000011','MA002',1),('HD00000012','MA005',1),('HD00000013','MA003',2),('HD00000014','MA002',2),('HD00000014','MA005',2),('HD00000015','MA002',1),('HD00000015','MA003',1),('HD00000016','MA001',2),('HD00000017','MA001',2),('HD00000018','MA004',1),('HD00000019','MA005',2),('HD00000020','MA004',1),('HD00000021','MA004',2),('HD00000022','MA003',1),('HD00000023','MA001',1),('HD00000024','MA004',1),('HD00000025','MA005',1),('HD00000026','MA005',1),('HD00000027','MA003',2),('HD00000028','MA001',2),('HD00000029','MA004',1),('HD00000030','MA001',1),('HD00000031','MA001',1),('HD00000031','MA005',1),('HD00000032','MA002',2),('HD00000033','MA003',1),('HD00000033','MA004',1),('HD00000034','MA003',1),('HD00000034','MA005',1),('HD00000035','MA005',1);
/*!40000 ALTER TABLE `hoadon_monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadontamthoi`
--

DROP TABLE IF EXISTS `hoadontamthoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadontamthoi` (
  `MaHoaDonTamThoi` char(10) NOT NULL,
  `MaNhanVienTamThoi` char(10) NOT NULL,
  `MaBanTamThoi` char(5) NOT NULL,
  PRIMARY KEY (`MaHoaDonTamThoi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadontamthoi`
--

LOCK TABLES `hoadontamthoi` WRITE;
/*!40000 ALTER TABLE `hoadontamthoi` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadontamthoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadontamthoi_monan`
--

DROP TABLE IF EXISTS `hoadontamthoi_monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadontamthoi_monan` (
  `MaHoaDonTamThoi` char(10) NOT NULL,
  `MaMonAnTamThoi` char(5) NOT NULL,
  `TenMonAnTamThoi` longtext NOT NULL,
  `SoLuongTamThoi` int NOT NULL DEFAULT '0',
  `DonGiaTamThoi` int NOT NULL DEFAULT '0',
  `ThanhTienTamThoi` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`MaHoaDonTamThoi`,`MaMonAnTamThoi`),
  CONSTRAINT `MaHoaDonTamThoi` FOREIGN KEY (`MaHoaDonTamThoi`) REFERENCES `hoadontamthoi` (`MaHoaDonTamThoi`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadontamthoi_monan`
--

LOCK TABLES `hoadontamthoi_monan` WRITE;
/*!40000 ALTER TABLE `hoadontamthoi_monan` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadontamthoi_monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKhachHang` char(10) NOT NULL,
  `Ho` varchar(40) NOT NULL,
  `Ten` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `DiemThuong` int DEFAULT '0',
  PRIMARY KEY (`MaKhachHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('0312890890','Nguyễn','Bình',200),('0329117042','Phạm Nguyễn Như','Bình',1150),('0393617000','Vũ Nguyễn Mai','Linh',900),('0394881245','Lâm Hoàng','Phúc',12000),('0395457432','Nguyễn Vân','Anh',3100),('0704770902','Trịnh Tấn','Sĩ',26350),('0706206292','Phạm Thị Thùy','Hương',800),('0712346892','Nguyễn Thị Thùy','Trâm',9600),('0875641289','Dương Trọng','Thiên',17000),('0965484182','Phạm Thu','Thủy',2050),('0971740345','Nguyễn Trọng Huỳnh','Phát',6000),('0976981453','Trần Mỹ','Duyên',500);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan`
--

DROP TABLE IF EXISTS `monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan` (
  `MaMonAn` char(5) NOT NULL,
  `TenMonAn` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `DonGia` int NOT NULL,
  PRIMARY KEY (`MaMonAn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
INSERT INTO `monan` VALUES ('MA001','Cơm chiên hải sản',40000),('MA002','Mỳ cay kim chi',50000),('MA003','Cơm cuộn Hàn Quốc',30000),('MA004','Súp bí đỏ',35000),('MA005','Canh rong biển',20000);
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan_nguyenlieu`
--

DROP TABLE IF EXISTS `monan_nguyenlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan_nguyenlieu` (
  `MaMonAn` char(5) NOT NULL,
  `MaNguyenLieu` char(10) NOT NULL,
  PRIMARY KEY (`MaMonAn`,`MaNguyenLieu`),
  KEY `MaNguyenLieu_idx` (`MaNguyenLieu`),
  CONSTRAINT `MaMonAn` FOREIGN KEY (`MaMonAn`) REFERENCES `monan` (`MaMonAn`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MaNL` FOREIGN KEY (`MaNguyenLieu`) REFERENCES `nguyenlieu` (`MaNguyenLieu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan_nguyenlieu`
--

LOCK TABLES `monan_nguyenlieu` WRITE;
/*!40000 ALTER TABLE `monan_nguyenlieu` DISABLE KEYS */;
INSERT INTO `monan_nguyenlieu` VALUES ('MA001','NL00000001'),('MA003','NL00000001'),('MA001','NL00000002'),('MA002','NL00000002'),('MA003','NL00000002'),('MA004','NL00000002'),('MA001','NL00000003'),('MA002','NL00000003'),('MA001','NL00000004'),('MA003','NL00000004'),('MA004','NL00000004'),('MA002','NL00000005'),('MA002','NL00000006'),('MA004','NL00000007'),('MA003','NL00000008'),('MA003','NL00000009'),('MA001','NL00000011'),('MA003','NL00000011'),('MA001','NL00000012'),('MA002','NL00000013'),('MA004','NL00000014'),('MA005','NL00000014');
/*!40000 ALTER TABLE `monan_nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `Id` char(10) NOT NULL,
  `MatKhau` varchar(20) NOT NULL,
  `Ho` varchar(40) DEFAULT NULL,
  `Ten` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` longtext,
  `VaiTro` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES ('0329117040','123456Nhanvien@','Phạm Nguyễn Như','Bình','2002-01-01','TP.HCM',0),('0329117041','123456Admin@','Phạm Nguyễn Như','Bình','2002-01-01','TP.HCM',1),('0395457430','123456Nhanvien@','Nguyễn Vân','Anh','2002-10-09','Đồng Tháp',0),('0395457431','123456Admin@','Nguyễn Vân','Anh','2002-10-09','Đồng Tháp',1),('0395457432','123456Anh@','Nguyễn',' Anh','2022-11-30','TPHCM',0),('0704770900','123456Nhanvien@','Trịnh Tấn','Sĩ','2002-01-01','TP.HCM',0),('0704770901','123456Admin@','Trịnh Tấn','Sĩ','2002-01-01','TP.HCM',1),('0706206290','123456Nhanvien@','Phạm Thị Thùy','Hương','2002-01-01','TP.HCM',0),('0706206291','123456Admin@','Phạm Thị Thùy','Hương','2002-01-01','TP.HCM',1),('0931861134','123456Nhanvien@','Trần Mỹ',' Duyên','2002-03-03','Bình Định',0),('0965484180','123456Nhanvien@','Phạm Thu','Thủy','2002-01-01','TP.HCM',0),('0965484181','123456Admin@','Phạm Thu','Thủy','2002-01-01','TP.HCM',1);
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguyenlieu`
--

DROP TABLE IF EXISTS `nguyenlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguyenlieu` (
  `MaNguyenLieu` char(10) NOT NULL,
  `TenNguyenLieu` longtext NOT NULL,
  `SoLuong` int NOT NULL DEFAULT '0',
  `DonVi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`MaNguyenLieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyenlieu`
--

LOCK TABLES `nguyenlieu` WRITE;
/*!40000 ALTER TABLE `nguyenlieu` DISABLE KEYS */;
INSERT INTO `nguyenlieu` VALUES ('NL00000001','Gạo',50,'Kg'),('NL00000002','Tôm',20,'Kg'),('NL00000003','Mực',9,'Kg'),('NL00000004','Đậu que',4,'Kg'),('NL00000005','Mì sợi',15,'Gói'),('NL00000006','Bắp cải tím',8,'Kg'),('NL00000007','Bí đỏ',30,'Kg'),('NL00000008','Rong biển',10,'Gói'),('NL00000009','Dưa leo',10,'Kg'),('NL00000010','Chả cá viên',12,'Gói'),('NL00000011','Xúc xích',19,'Gói'),('NL00000012','Đậu Hà Lan',24,'Gói'),('NL00000013','Kim chi',32,'Gói'),('NL00000014','Thịt băm',21,'Kg');
/*!40000 ALTER TABLE `nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `Id` char(10) NOT NULL,
  `HeSoLuong` float NOT NULL,
  `LuongCoBan` int NOT NULL,
  `NgayVaoLam` date NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  CONSTRAINT `IdNhanVien` FOREIGN KEY (`Id`) REFERENCES `nguoidung` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('0329117040',2.5,4200000,'2021-03-02'),('0395457430',1.5,4100000,'2021-01-01'),('0395457431',2,3000000,'2022-12-12'),('0704770900',2,4000000,'2021-03-01'),('0704770901',2,3000000,'2022-12-12'),('0706206290',1,4500000,'2021-05-05'),('0931861134',1,3500000,'2022-11-30'),('0965484180',3,4600000,'2021-04-02');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuahang`
--

DROP TABLE IF EXISTS `phieumuahang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieumuahang` (
  `MaPhieuMuaHang` char(10) NOT NULL,
  `SoLuongMatHang` int NOT NULL DEFAULT '0',
  `DonGiaMatHang` int NOT NULL,
  `MaNguyenLieu` char(10) NOT NULL,
  `NgayNhapPhieu` datetime NOT NULL,
  `ThanhTien` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`MaPhieuMuaHang`),
  KEY `MaNguyenLieu_idx` (`MaNguyenLieu`),
  CONSTRAINT `MaNguyenLieu` FOREIGN KEY (`MaNguyenLieu`) REFERENCES `nguyenlieu` (`MaNguyenLieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuahang`
--

LOCK TABLES `phieumuahang` WRITE;
/*!40000 ALTER TABLE `phieumuahang` DISABLE KEYS */;
INSERT INTO `phieumuahang` VALUES ('MH00000001',20,6000,'NL00000005','2022-11-08 12:12:31',50000),('MH00000002',30,18000,'NL00000001','2022-11-08 12:34:21',30000),('MH00000003',15,120000,'NL00000002','2022-11-08 12:36:56',100000),('MH00000004',30,12000,'NL00000004','2022-12-01 21:01:52',360000),('MH00000005',20,18000,'NL00000001','2022-12-02 10:36:37',360000),('MH00000006',10,10000,'NL00000002','2022-12-02 10:36:37',100000),('MH00000007',10,5000,'NL00000003','2022-12-02 10:36:37',50000),('MH00000008',10,1000,'NL00000004','2022-12-02 12:59:15',10000),('MH00000009',10,2000,'NL00000005','2022-12-02 12:59:15',20000),('MH00000010',10,2000,'NL00000006','2022-12-02 12:59:15',20000),('MH00000011',5,2000,'NL00000007','2022-12-02 12:59:15',10000),('MH00000012',20,500,'NL00000008','2022-12-02 12:59:15',10000),('MH00000013',15,500,'NL00000009','2022-12-02 12:59:15',7500),('MH00000014',10,200,'NL00000010','2022-12-02 12:59:15',2000),('MH00000015',10,2000,'NL00000011','2022-12-02 12:59:15',20000),('MH00000016',5,1500,'NL00000012','2022-12-02 12:59:15',7500),('MH00000017',5,100,'NL00000013','2022-12-02 12:59:15',500),('MH00000018',1,20000,'NL00000014','2022-12-02 12:59:15',20000),('MH00000019',10,2000,'NL00000001','2022-12-02 12:59:15',20000);
/*!40000 ALTER TABLE `phieumuahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quantrivien`
--

DROP TABLE IF EXISTS `quantrivien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quantrivien` (
  `Id` char(10) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  CONSTRAINT `IdQuanTriVien` FOREIGN KEY (`Id`) REFERENCES `nguoidung` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quantrivien`
--

LOCK TABLES `quantrivien` WRITE;
/*!40000 ALTER TABLE `quantrivien` DISABLE KEYS */;
INSERT INTO `quantrivien` VALUES ('0329117041'),('0395457431'),('0704770901'),('0706206291'),('0965484181');
/*!40000 ALTER TABLE `quantrivien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timefield`
--

DROP TABLE IF EXISTS `timefield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timefield` (
  `Id` int NOT NULL,
  `Name` mediumtext NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timefield`
--

LOCK TABLES `timefield` WRITE;
/*!40000 ALTER TABLE `timefield` DISABLE KEYS */;
INSERT INTO `timefield` VALUES (1,'Thống kê theo thời gian tùy chỉnh'),(2,'Thống kê theo tháng'),(3,'Thống kê theo năm');
/*!40000 ALTER TABLE `timefield` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 16:17:09
