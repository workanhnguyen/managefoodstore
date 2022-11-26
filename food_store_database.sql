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
INSERT INTO `hoadon` VALUES ('HD00000001','2022-11-26 15:54:53','0395457430','BAN03','0704770902',0,115000);
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
INSERT INTO `hoadon_monan` VALUES ('HD00000001','MA002',1),('HD00000001','MA003',1),('HD00000001','MA004',1);
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
  `Ho` varchar(20) NOT NULL,
  `Ten` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `DiemThuong` int DEFAULT '0',
  PRIMARY KEY (`MaKhachHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('0394881245','Lâm Hoàng','Phúc',12000),('0395457432','Nguyễn Vân','Anh',32000),('0704770902','Trịnh Tấn','Sĩ',25150),('0712346892','Nguyễn Thị Thùy','Trâm',9600),('0875641289','Dương Trọng','Thiên',17000),('0965484182','Phạm Thu','Thủy',20000),('0971740345','Nguyễn Trọng Huỳnh','Phát',6000);
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
  `Ho` varchar(20) DEFAULT NULL,
  `Ten` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
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
INSERT INTO `nguoidung` VALUES ('0395457430','123456Nhanvien@','Nguyễn Vân','Anh','2002-10-09','Đồng Tháp',0),('0395457431','123456Admin@','Nguyễn Vân','Anh','2002-10-09','Đồng Tháp',1),('0704770900','123456Nhanvien@','Trịnh Tấn','Sĩ','2002-01-01','TP.HCM',0),('0704770901','123456Admin@','Trịnh Tấn','Sĩ','2002-01-01','TP.HCM',1),('0965484180','123456Nhanvien@','Phạm Thu','Thủy','2002-01-01','TP.HCM',0),('0965484181','123456Admin@','Phạm Thu','Thủy','2002-01-01','TP.HCM',1);
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
INSERT INTO `nguyenlieu` VALUES ('NL00000001','Gạo',65,'Kg'),('NL00000002','Tôm',8,'Kg'),('NL00000003','Mực',35,'Kg'),('NL00000004','Đậu que',52,'Kg'),('NL00000005','Mì sợi',7,'Gói'),('NL00000006','Bắp cải tím',56,'Kg'),('NL00000007','Bí đỏ',8,'Kg'),('NL00000008','Rong biển',86,'Gói'),('NL00000009','Dưa leo',8,'Kg'),('NL00000010','Chả cá viên',100,'Gói'),('NL00000011','Xúc xích',65,'Gói'),('NL00000012','Đậu Hà Lan',79,'Gói'),('NL00000013','Kim chi',56,'Gói'),('NL00000014','Thịt băm',80,'Kg');
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
INSERT INTO `nhanvien` VALUES ('0395457430',2,4000000,'2021-01-01'),('0704770900',2,4000000,'2021-03-01'),('0965484180',2,4000000,'2021-04-02');
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
INSERT INTO `phieumuahang` VALUES ('MH00000001',20,6000,'NL00000005','2022-11-08 12:12:31',50000),('MH00000002',30,18000,'NL00000001','2022-11-08 12:34:21',30000),('MH00000003',15,120000,'NL00000002','2022-11-08 12:36:56',100000);
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
INSERT INTO `quantrivien` VALUES ('0395457431'),('0704770901'),('0965484181');
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
INSERT INTO `timefield` VALUES (1,'Thống kê theo thời gian tùy chỉnh'),(2,'Thống kê theo tháng'),(3,'Thống kê theo quý'),(4,'Thống kê theo năm');
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

-- Dump completed on 2022-11-26 16:02:43
