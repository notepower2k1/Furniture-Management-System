-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: May 18, 2022 at 11:28 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fms`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietddh`
--

CREATE TABLE `chitietddh` (
  `so_luong` int(11) NOT NULL,
  `idnoi_that` int(11) NOT NULL,
  `iddon_hang` int(11) NOT NULL,
  `gia_mua` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietddh`
--

INSERT INTO `chitietddh` (`so_luong`, `idnoi_that`, `iddon_hang`, `gia_mua`) VALUES
(3, 1, 2, 2400000),
(13, 3, 2, 4900000),
(13, 2, 3, 2240000),
(4, 1, 4, 9975000),
(2, 3, 4, 4900000),
(1, 2, 5, 2240000),
(1, 3, 6, 4900000);

-- --------------------------------------------------------

--
-- Table structure for table `dondathang`
--

CREATE TABLE `dondathang` (
  `iddon_hang` int(11) NOT NULL,
  `madh` varchar(50) NOT NULL,
  `ngay_lap` date NOT NULL,
  `tinh_trang` bit(1) NOT NULL DEFAULT b'1',
  `dia_chi_nhan_hang` varchar(100) NOT NULL,
  `ghi_chu` varchar(1000) DEFAULT NULL,
  `id_khach_hang` int(11) DEFAULT NULL,
  `id_nhan_vien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dondathang`
--

INSERT INTO `dondathang` (`iddon_hang`, `madh`, `ngay_lap`, `tinh_trang`, `dia_chi_nhan_hang`, `ghi_chu`, `id_khach_hang`, `id_nhan_vien`) VALUES
(2, 'DH001', '2022-03-26', b'1', 'test', 'test', 1, 2),
(3, 'DH002', '2022-04-26', b'1', 'test', 'nothing', 1, 2),
(4, 'DH003', '2022-05-11', b'1', '31/5 Võ Thị Sáu', 'Ship đến tận nhà cho tôi', 3, 3),
(5, 'DH004', '2022-05-11', b'0', '31/5 Võ Thị Sáu', 'Nothing here', 3, 3),
(6, 'DH005', '2022-05-12', b'0', '31/5 Võ Thị', 'Nothing', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `hinhanh`
--

CREATE TABLE `hinhanh` (
  `idhinh_anh` int(11) NOT NULL,
  `ten_anh` varchar(255) NOT NULL,
  `id_noi_that` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hinhanh`
--

INSERT INTO `hinhanh` (`idhinh_anh`, `ten_anh`, `id_noi_that`) VALUES
(98, 'tu-dau-giuong-f_multi_2_364_450.png', 44),
(99, 'tu-dau-giuong-f_multi_0_33_450.png', 44),
(100, 'tu-dau-giuong-f_multi_1_739_450.png', 44),
(101, 'tu-dau-giuong-f_multi_3_282_450.png', 44),
(252, 'sofa-giuong-roy_multi_0_769_450.png', 1),
(253, 'sofa-giuong-roy_multi_1_185_450.png', 1),
(254, 'ban-sofa-04s-2.webp', 3),
(255, 'ban-sofa-04s-3.webp', 3),
(256, 'ban-sofa-04s-jpeg.webp', 3),
(257, 'cuecf101001_main_1_3.jpg', 29),
(258, 'cuecf105001_main_7.jpg', 29),
(259, 'cuecf107001_main_2.jpg', 29),
(260, 'cuecf108001_pt02_1_2.jpg', 29),
(265, '1462.png', 31),
(266, 'graffiti_bunk_bed_black_powder_coated_steel_uma_1462_front.jpg', 31),
(267, 'graffiti_bunk_bed_black_powder_coated_steel_uma_1462_side.jpg', 31),
(268, '64a7625850a5bdfb3b5b9b2487a474d8_tn.jfif', 32),
(269, '9614ee326e7ae189540e1c673a29084b_tn.jfif', 32),
(270, '575145cccc9489b78c3688b51c0a5003_tn.jfif', 32),
(271, 'bc3e208143dc091e894c7f44b8c7f998_tn.jfif', 32),
(272, '223-1603254346-noithatnhaxinh.png', 33),
(273, '1000-iris-grey1.jpg', 33),
(274, 'download.jfif', 33),
(275, 'tu-ao-4-cua-ang_main_136_450.png.webp', 34),
(276, 'tu-ao-4-cua-ang_multi_0_651_1020.png', 34),
(277, 'tu-ao-4-cua-ang_multi_1_561_1020.png', 34),
(278, 'ban-coffee-os00_multi_0_752_1020.png', 35),
(279, 'ban-coffee-os00_multi_1_145_1020.png', 35),
(280, 'ban-coffee-os00_multi_2_75_1020.png', 35),
(281, 'ban-an-cam-thac_multi_0_396_450.png', 36),
(282, 'ghe-xep-florida_multi_0_961_450.png', 38),
(283, 'ghe-xep-florida_multi_1_254_450.png', 38),
(284, 'ghe-nhua-1692-x_multi_0_869_450.png', 39),
(285, 'ghe-nhua-1692-x_multi_1_524_450.png', 39),
(286, 'ghe-nhua-1692-x_multi_2_575_450.png', 39),
(287, 'ghe-nhua-1692-x_multi_3_718_450.png', 39),
(288, 'ghe-xep-thu-gia_multi_0_403_1020.png', 40),
(289, 'ghe-xep-thu-gia_multi_1_774_1020.png', 40),
(290, 'ghe-xep-thu-gia_multi_2_630_1020.png', 40),
(295, 'giuong-16m-clai_main_585_450.png', 42),
(296, 'giuong-18m-nova_multi_0_948_1020.png', 41),
(297, 'giuong-18m-nova_multi_1_919_1020.png', 41),
(298, 'giuong-18m-nova_multi_2_867_1020.png', 41),
(299, '_slideshow_0_500_615.png', 45),
(300, 'academy_cpu_holder_baya_1049008_1_2.jpg', 30),
(301, 'academy_desk_-_metal_part_baya_1048995_1.jpg', 30),
(302, 'academy_storage_cabinet_baya_1049015_1_2.jpg', 30),
(303, 'major_office_chair_black_mesh_metal_uma_1060799_1_1.jpg', 30),
(304, 'major_office_chair_black_mesh_metal_uma_1060799_4_1.jpg', 30),
(305, 'major_office_chair_black_mesh_metal_uma_1060799_5_1.jpg', 30);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `idkhach_hang` int(11) NOT NULL,
  `makh` varchar(50) NOT NULL,
  `ho_tenkh` varchar(50) NOT NULL,
  `sdt` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dia_chi` varchar(100) NOT NULL,
  `id_tai_khoan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`idkhach_hang`, `makh`, `ho_tenkh`, `sdt`, `email`, `dia_chi`, `id_tai_khoan`) VALUES
(1, 'KH01', 'Nguyễn Thi Hưng', '0706096936', 'nguyenhung12c1@gmail.com', 'test', 5),
(3, 'KH06', 'Nguyễn Văn Thacc', '0353938402', 'nguyenthach@gmail.com', '31/5 Võ Thị', 2),
(4, 'KH03', 'Nguyễn Thị Lệ', '0353938404', 'test@gmail.com', '31/5 Võ Thị Sáu', 12),
(8, 'KH07', '', '', 'admin@gmail.com', '', 13),
(9, 'KH08', '', '', 'nvthach.c4nvt@gmail.com', '', 14);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `makm` varchar(10) NOT NULL,
  `tenkm` varchar(15) NOT NULL,
  `idkhuyen_mai` int(11) NOT NULL,
  `gia_tri` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`makm`, `tenkm`, `idkhuyen_mai`, `gia_tri`) VALUES
('KM10', 'Khuyến mãi 10%', 1, 0.1),
('KM15', 'Khuyến mãi 15%', 2, 0.15),
('KM20', 'Khuyến mãi 20%', 3, 0.2),
('KM5', 'Khuyến mãi 5%', 4, 0.05),
('KM0', 'Không KM', 5, 0),
('KM50', 'Khuyến mãi 50%', 6, 0.5),
('KM85', 'Khuyến mãi 85%', 7, 0.8),
('KM30', 'Khuyến mãi 30%', 8, 0.3),
('KM40', 'Khuyến mãi 40%', 9, 0.4);

-- --------------------------------------------------------

--
-- Table structure for table `loainoithat`
--

CREATE TABLE `loainoithat` (
  `ma_loai` varchar(10) NOT NULL,
  `ten_loai` varchar(25) NOT NULL,
  `idloai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loainoithat`
--

INSERT INTO `loainoithat` (`ma_loai`, `ten_loai`, `idloai`) VALUES
('LNT001', 'Ghế', 1),
('LNT002', 'Bàn', 2),
('LNT003', 'Tủ', 3),
('LNT004', 'Giường', 4),
('LNT005', 'Sàn nhà', 5);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `idnhan_vien` int(11) NOT NULL,
  `manv` varchar(50) NOT NULL,
  `ho_tennv` varchar(50) NOT NULL,
  `sdt` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dia_chi` varchar(100) NOT NULL,
  `id_tai_khoan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`idnhan_vien`, `manv`, `ho_tennv`, `sdt`, `email`, `dia_chi`, `id_tai_khoan`) VALUES
(2, 'NV01', 'Nguyễn Hưng', '0706096936', 'nguyenhung12c1@gmail.com', 'test123', 1),
(3, 'NV02', 'Nguyễn Văn Thạch', '0706096936', 'thachthongthai128@gmail.com', '214 Võ Thị Sáu', 2),
(5, 'NV03', 'Nguyễn Thành Nhân', '0706096936', 'nhannnnttuuu@gmail.com', '214 Võ Thị Sáu', 3),
(6, 'NV04', 'Nguyễn Nhật Trường', '0706096936', 'truong_ng221@gmail.com', 'test123', 4);

-- --------------------------------------------------------

--
-- Table structure for table `noithat`
--

CREATE TABLE `noithat` (
  `idnoi_that` int(11) NOT NULL,
  `ma_noi_that` varchar(50) NOT NULL,
  `tennt` varchar(100) NOT NULL,
  `don_gia` float NOT NULL,
  `kich_thuoc` varchar(50) NOT NULL,
  `tgbao_hanh` int(11) NOT NULL,
  `hinh_anh` varchar(200) NOT NULL,
  `chat_lieu` varchar(100) NOT NULL,
  `don_vi_tinh` varchar(10) NOT NULL,
  `mo_ta` text NOT NULL,
  `idkm` int(11) DEFAULT NULL,
  `id_loai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `noithat`
--

INSERT INTO `noithat` (`idnoi_that`, `ma_noi_that`, `tennt`, `don_gia`, `kich_thuoc`, `tgbao_hanh`, `hinh_anh`, `chat_lieu`, `don_vi_tinh`, `mo_ta`, `idkm`, `id_loai`) VALUES
(1, 'NT002', 'Sofa Giường ROYAL H18S02 Nâu', 10500000, '2.5*1.7*0.85m', 12, 'sofa-giuong-roy_main_157_450.png', 'Vải Bố', 'Chiếc', 'Theo xu hướng hiện đại, các dòng ghế sofa phòng khách với chất liệu bằng nệm được ưu chuộng trong kiến trúc  nội thất gia đình. Bàn ghế sofa giá rẻ không chỉ đẹp về mẫu mã, bền bỉ theo thời gian mà giá trị tinh thần nó mang lại cũng hết sức quan trọng\r\nTrên thị trường nội thất hiện nay, chúng ta có rất nhiều mẫu bàn ghế sofa phòng khách với thiết kế đẹp mắt, đa dạng mẫu mã, màu sắc phù hợp với nhiều không gian phòng khác nhau. Bên cạnh đó là các mức giá cả khác nhau tùy theo chất liệu cầu tạo nên sản phẩm.', 6, 1),
(2, 'NT001', 'Tủ Bếp Giá Rẻ 1001T', 2800000, '0.35 x 0.65', 14, 'tu-bep-gia-re-1001t.jpg', 'MDF lõi xanh chống ẩm, phủ Verneer xoan đào/sồi sơn PU.', 'Chiếc', 'là vật dụng không thể thiếu trong gia đình việt, theo xu hướng hiện nay tủ bếp không còn và vật dụng chuyên cho việc nội trợ mà nó còn là vật dung trang trí, tô điểm cho không gian sống của mỗi gia đình. Không gian bếp không chỉ là nơi của những người nội chợ mà còn là nơi xum họp, quay quần của các thành viên gia đình trong mỗi bữa ăn, sau những lúc làm việc mệt mỏi, hoặc nhưng bận rộn bên ngoài xã hội..\r\nChính vì thế việc thiết kế cho gia đình bạn một không gian bếp đẹp là điều không dễ, việc lựa chọn màu sắc, thiết kế và chất liệu làm nên Tủ bếp Đẹp là những yếu tố cực kỳ quang trọng trong mỗi không gian bếp. Việc lựa chọn vật dụng làm tủ bếp sao cho theo kịp với xu hướng hiện đại và hợp với không gian nhà bạn là vấn đề không đơn giản.\r\nDecoViet chuyên Biên Hòa, Miễn phí thiết kế 3D và ráp đặt Tủ bếp giá rẻ (kệ bếp giá rẻ) tại TP HCM, Biên Hòa, . Với nhiều năm kinh nghiệm trong ngành nội thất gia đình, tự hào sẽ mang điến cho bạn một không gian bếp hoàn hảo nhất.', 3, 3),
(3, 'NT003', 'Bàn Sofa Mặt Kính 04s', 4900000, '0.7m', 12, 'ban-sofa-04s-1.webp', 'chân sắt sơn đen mặt kính cường lực.', 'bộ', 'sự lựa chọn lý tưởng cho không gian phòng khách. Chất liệu cao cấp nhập khẩu trưc tiếp từ Châu Âu, Châu Á với nhiều mẫu mã và màu sắc đa dạng mang tính hiện đại cao. DecoViet không ngừng cố gắng để mang đến cho khách hàng một không gian vô cùng hiện đại và sang trọng hơn.', 5, 2),
(29, 'NT004', 'Bộ bàn ghế văn phòng ICONICO', 9990000, 'CB52', 12, 'hobby-1-modern-white-_-oak.jpg', 'gỗ', 'bộ', 'Phòng làm việc, phòng sở thích là nơi chứa rất nhiều đồ đạc từ sách vở, tài liệu cho tới các món đồ lưu niệm, vật dụng hằng ngày.\r\n\r\nNếu như bạn đang phân vân không biết làm thế nào để sắp xếp chúng cho thật gọn gàng và khoa học, thì BAYA sẽ mang đến cho bạn một giải pháp hoàn hảo. \r\n\r\nCombo bao gồm 4 sản phẩm chi tiết như sau: \r\n\r\n      1. Kệ gỗ đa năng 3 ngăn – Màu gỗ sồi tự nhiên (02 cái): Kích thước 100 x 30 x 33cm (Dài x Rộng x Cao). \r\n\r\n      2. Tủ gỗ 4 ngăn kéo phong cách hiện đại – Màu gỗ sồi tự nhiên (01 cái): Kích thước 80 x 44.5 x 113cm (Dài x Rộng x Cao). \r\n\r\n     3. Kệ sách gỗ đứng 6 tầng – Màu gỗ sồi tự nhiên (01 cái): Kích thước 60 x 30 x 190.5cm (Dài x Rộng x Cao). \r\n\r\n     4. Bàn làm việc - Màu gỗ sồi tự nhiên (01 cái): Kích thước 100 x 55.5 x 76cm (Dài x Rộng x Cao). \r\n\r\nCác sản phẩm kệ, tủ và bàn làm việc đều được thiết kế và sản xuất tại Ý sau đó nhập khẩu nguyên kiện về Việt Nam.\r\n\r\nToàn bộ các sản phẩm trong combo đều an toàn tới sức khỏe, thân thiện với người dùng và dễ dàng để vệ sinh và bảo quản. \r\n\r\nLưu ý: Bộ nội thất chỉ gồm các sản phẩm chi tiết đã liệt kê, không bao gồm sản phẩm khác.', 4, 2),
(30, 'NT005', 'Bộ bàn và ghế văn phòng ACADEMY', 7869000, 'L120xW60xH67 - 100', 12, '2._1080_x_1080_1.jpg', 'Gỗ keo/ kim loại', 'bộ', 'Bàn giám đốc kèm tủ phụ – BGDDK29.Bàn làm việc quản lý giám đốc 1m6 màu vân gỗ là dòng sản phẩm được thiết kế riêng dùng cho các giám đốc, lãnh đạo công ty, cơ quan sử dụng chất liệu gỗ cao cấp, thiết kế sang trọng, đẳng cấp.\r\n\r\nRất nhiều vị lãnh đạo, giám đốc của công ty yêu cầu phòng làm việc của mình phải toát lên được sự sang trọng, đẳng cấp, phù hợp với tác phong làm việc của chính chủ nhân. Để làm nổi lên tất cả những điều kiện đó, bàn làm việc chắc chắn chiếm vị trí quan trọng hơn cả.', 1, 1),
(31, 'NT006', 'Giường tầng Graffiti', 5990000, 'D90/138xW190xH175', 12, 'graffiti_bunk_bed_baya_1462_inspiration.jpg', 'Thép sơn tĩnh điện', 'Chiếc', 'Giường tầng GRAFFITI là một trong những giải pháp tốt nhất cho không gian phòng ngủ nhỏ. Sản phẩm được làm từ chất liệu kim loại phủ sơn tĩnh điện đen sang trọng có thiết kế vững chãi, giúp tiết kiệm diện tích hiệu quả. Thiết kế thông minh giường đi kèm cầu thang tiện dụng để dễ di chuyển', 1, 4),
(32, 'NT007', 'Giường tầng trẻ em', 4500000, '2000x1000x1700 mm', 12, 'fede070d4564cef1112c90de1e71efc8_tn.jfif', 'Gỗ Thông Newzealand', 'Chiếc', 'GIƯỜNG TÂNG – HÀNG XUẤT KHẨU\r\n\r\nMÀU SƠN THEO YÊU CẦU ( TRẮNG , HỒNG PHẤN , ĐEN )\r\n\r\nKích thước: 2000x1000x1700 mm\r\n\r\nVật liệu: Gỗ Thông Newzealand', 2, 4),
(33, 'NT008', 'Giường Hộc Kéo Iris', 14630000, 'D2000- R1600- C1112 mm', 24, 'phong-ngu-giuong-hoc-keo-iris-4.jpg', 'Vải Belfast 41', 'Chiếc', 'Hiện tại chưa có mô tả sản phẩm\r\n\r\nChúng tôi đang cập nhật trong thời gian sớm nhất', 6, 4),
(34, 'NT009', 'Tủ Áo 4 Cửa ANGEL CP1501W', 19990000, '240x60.9x220', 12, 'tu-ao-4-cua-ang_main_136_450.png', 'Chất liệu gỗ mdf sơn bóng cao cấp', 'Chiếc', 'Phong cách hiện đại, cao sang, quý phái.\r\nBề mặt tủ được phủ lớp chống trầy xước.\r\nThiết kế tỉ mỉ, kiểu dáng tủ 4 cửa rộng rãi', 3, 3),
(35, 'NT010', 'Bàn Coffee OS0016 50CM Trắng', 2090000, '50x50x52 cm', 12, 'ban-coffee-os00_main_449_1020.jpg', 'Chất liệu cao cấp, bền đẹp', 'Cái', 'Mặt bàn MDF, khung kim loại\r\nBàn Coffee OS0016 50CM Trắng có mặt bàn được làm từ chất liệu MDF cao cấp, khung bằng kim loại chắc chắn nên người sử dụng có thể yên tâm về chất lượng cũng như độ bền của sản phẩm. Sản phẩm rất phù hợp với điều kiện khí hậu của Việt Nam.\r\n\r\n\r\n\r\nBàn sở hữu phong cách sang trọng với thiết kế chân bàn cách điệu bằng kim loại giúp cố định bàn trên mọi mặt phẳng, hạn chế tình trạng rung lắc hoặc nghiêng lệch trong quá trình sử dụng.\r\n\r\nTô điểm không gian nội thất hiện đại\r\nVới kích thước 50x50x52 cm Bàn OS0016 tiết kiệm không gian tối đa và màu sắc tinh tế, sản phẩm phù hợp với nhiều kiểu kiến trúc nhà ở, góp phần mang đến phong cách trang nhã cho không gian.', 5, 2),
(36, 'NT011', 'Bàn Ăn Cẩm Thạch HC-8145GCBR', 24490000, '180x90x75.5 cm', 12, 'ban-an-cam-thac_main_517_450.png', 'Đá cẩm thạch bền bỉ', 'Chiếc', 'Hiện tại chưa có mô tả sản phẩm\r\n\r\nChúng tôi đang cập nhật trong thời gian sớm nhất', 3, 2),
(37, 'NT012', 'Bàn Góc Box UA875-05', 1690000, '55x55x51 cm', 12, 'ban-goc-box-ua8_main_24_450.png', 'Gỗ MDF cao cấp dán veener', 'Cái', 'Kiếu dáng đơn giản\r\nBàn Góc Box UA875-05 - Sồi Đậm nằm trong bộ sản phẩm nội thất Box, được nhập khẩu nguyên kiện về Việt Nam, chất liệu gỗ cao cấp. Chân Kim loại chắc chắn được gia công nghiêm ngặt cho tổng thể được gia cố chắc chắn, bền bỉ xài thời gian lâu dài. ', 3, 2),
(38, 'NT013', 'Ghế Xếp Florida HM-SC27015F-C', 890000, '47x43x78 cm', 12, 'ghe-xep-florida_main_384_450.png', 'Kim loại bọc vải', 'Chiếc', 'Đệm ngồi bọc vải êm ái, đàn hồi tốt\r\nKiểu dáng dạng ghế gập, thiết kế đơn giản\r\nKhung kim loại bền chặt, an toàn\r\n', 3, 1),
(39, 'NT014', 'Ghế Nhựa 1692 Xanh', 1290000, '57x56x84 cm', 12, 'ghe-nhua-1692-x_multi_3_718_450.png', 'Ghế làm từ nhựa PP cao cấp, bền bỉ', 'Chiếc', 'Hiện tại chưa có mô tả sản phẩm\r\n\r\nChúng tôi đang cập nhật trong thời gian sớm nhất', 6, 1),
(40, 'NT015', 'Ghế Xếp Thư Giãn KAMI ECOC017 Đen', 1199000, '178x66x25 cm', 12, 'ghe-xep-thu-gia_main_9_1020.png', 'Vải lưới đan sợi Polyethylene', 'Chiếc', 'Hiện tại chưa có mô tả sản phẩm\r\n\r\nChúng tôi đang cập nhật trong thời gian sớm nhất', 7, 1),
(41, 'NT016', 'Giường 1.8M NOVARA L14Z-NZ', 53690000, '215x228x112 cm', 12, 'giuong-18m-nova_main_892_1020.png', 'Bọc da cao cấp toàn sản phẩm', 'bộ', 'Khung gỗ tự nhiên, chân kim loại\r\nMang phong cách sang trọng của Tây Âu\r\nNệm có cấu trúc dây đan đần hồi tốt\r\n', 8, 4),
(42, 'NT017', 'Giường Sunday 5317 1M6 Đen', 12990000, '160x178x106.5x230 cm', 12, 'giuong-sunday-5_main_401_450.png', 'Gỗ bọc PVC', 'bộ', 'Khung giường bằng gỗ cứng chắc, chống ẩm mốc\r\nChân giường chịu tải tốt, đảm bảo sự cân đối\r\nThành giường bọc PVC bền bỉ, sang trọng\r\n', 8, 4),
(43, 'NT018', 'Tủ Tivi SHADE NS7033 Trắng', 2290000, '119x39x42 cm', 12, 'tu-tivi-shade-n_main_384_450.png', 'Chất liệu gỗ rắn chắc, bền bỉ', 'Cái', 'Thiết kế kiểu dáng hiện đại, sang trọng\r\nKhả năng chịu lực tốt, chống cong vênh\r\n', 8, 3),
(44, 'NT019', 'Tủ Đầu Giường Flora A2058', 2290000, '41x39x55 cm', 6, 'tu-dau-giuong-f_main_353_450.png', 'Các chất liệu chắc chắn, bền bỉ', 'Chiếc', 'Bề mặt kính chịu lực\r\nTủ Đầu Giường Flora A2058 - Nâu Gỗ có khung kim loại tủ được hàn chắc chắn, chịu được lực tốt, không bị oxi hóa, không bị phai màu và hoen gỉ. Trên bề mặt được phủ lớp kính cường lực, không bị bể, khó nứt, dễ dàng lau chùi khi bị bẩn. Bề mặt trên là làm từ kiếng chịu lực tốt.\r\n\r\n', 6, 3),
(45, 'NT020', 'Tủ Đầu Gường Queen A2016 Trắng', 790000, '40x30x54.5 cm', 6, 'tu-dau-guong-qu_main_136_1020.png', 'Gỗ MDF phủ melamin cao cấp', 'Chiếc', 'Hiện tại chưa có mô tả sản phẩm\r\n\r\nChúng tôi đang cập nhật trong thời gian sớm nhất\r\n\r\n', 5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `idvai_tro` int(11) NOT NULL,
  `tenvt` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`idvai_tro`, `tenvt`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_EDITOR'),
(3, 'ROLE_VISITOR'),
(4, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `idtai_khoan` int(11) NOT NULL,
  `mat_khau` varchar(255) NOT NULL,
  `ten_tai_khoan` varchar(255) NOT NULL,
  `idvai_tro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`idtai_khoan`, `mat_khau`, `ten_tai_khoan`, `idvai_tro`) VALUES
(1, '$2a$10$.sOJ/bnkE0meEG3KOJPz8OnCKb4xFppmN8vDIwicrdDcHZBOtzO/m', 'jaser2712', NULL),
(2, '$2a$10$d07q2TAbt/NmtwPgbaVWRu2yYLgiiWcTA7p8A3OVz6YxfFTqq9SSm', 'thachnv1234', NULL),
(3, '$2a$10$LOT0zbPblfgcLHz16occVOawp2KLML94GGn3kG4BPGHgwd6zUylba', 'nhannt123', NULL),
(4, '$2a$10$7dNgu4C/BPHgJHQ5Jx0RUO9CkLkJYRd0QyIhbUCRWur3NlqbC2una', 'truongntu123', NULL),
(5, '$2a$10$SI0uekUTm2byMm3BaXz.z.qAG7jQM44SSKIzzdHvGC5KuQmQgQ//G', 'nguyenhung2712', NULL),
(12, '$2a$10$I2EZKrUxZcWMdZIY7gvP1.7tWP/sjq3SuPX.psX9OLT8w/f/fwx96', 'nguyenhung9321', NULL),
(13, '$2a$10$E/g3QE0Uqz/FxVu5FwlAgeU7mLQc/dFLa8HI0/5RJJy2L49jLqSdu', 'notepower', NULL),
(14, '$2a$10$wRIMfbgN0fumysUmyt0lC.ZkGOSxORu79qEidCyTolrXdmxihQm26', 'test123', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tk_vt`
--

CREATE TABLE `tk_vt` (
  `idtai_khoan` int(11) NOT NULL,
  `idvai_tro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tk_vt`
--

INSERT INTO `tk_vt` (`idtai_khoan`, `idvai_tro`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(3, 3),
(4, 2),
(4, 3),
(5, 4),
(12, 2),
(12, 3),
(12, 4),
(13, 4),
(14, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietddh`
--
ALTER TABLE `chitietddh`
  ADD PRIMARY KEY (`iddon_hang`,`idnoi_that`),
  ADD KEY `FK78ycujarii4e4veyytr8jt36d` (`idnoi_that`);

--
-- Indexes for table `dondathang`
--
ALTER TABLE `dondathang`
  ADD PRIMARY KEY (`iddon_hang`),
  ADD KEY `FKng0i1ycsfmrokmss3jyrfpa24` (`id_khach_hang`),
  ADD KEY `FK9rqbfn3qrt39d170l5fgnaf09` (`id_nhan_vien`);

--
-- Indexes for table `hinhanh`
--
ALTER TABLE `hinhanh`
  ADD PRIMARY KEY (`idhinh_anh`),
  ADD KEY `FKshe4vpm5qmswa04u98lkc4xxm` (`id_noi_that`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`idkhach_hang`),
  ADD KEY `FK6rmoqm0vkwm7da244lwgm44x4` (`id_tai_khoan`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`idkhuyen_mai`);

--
-- Indexes for table `loainoithat`
--
ALTER TABLE `loainoithat`
  ADD PRIMARY KEY (`idloai`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`idnhan_vien`),
  ADD KEY `FKq6ilct1ry9ty7dfb4bcjyev2b` (`id_tai_khoan`);

--
-- Indexes for table `noithat`
--
ALTER TABLE `noithat`
  ADD PRIMARY KEY (`idnoi_that`),
  ADD KEY `FK1ryq4eet6y9gf5qj7hqi1ct70` (`idkm`),
  ADD KEY `FK9yp5ngomspk0whpwamcgbi3hn` (`id_loai`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`idvai_tro`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`idtai_khoan`);

--
-- Indexes for table `tk_vt`
--
ALTER TABLE `tk_vt`
  ADD PRIMARY KEY (`idtai_khoan`,`idvai_tro`),
  ADD KEY `FKpesus0mvdy5lsj4f97n84e9je` (`idvai_tro`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dondathang`
--
ALTER TABLE `dondathang`
  MODIFY `iddon_hang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hinhanh`
--
ALTER TABLE `hinhanh`
  MODIFY `idhinh_anh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=306;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `idkhach_hang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `idnhan_vien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `noithat`
--
ALTER TABLE `noithat`
  MODIFY `idnoi_that` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `idtai_khoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietddh`
--
ALTER TABLE `chitietddh`
  ADD CONSTRAINT `FK78ycujarii4e4veyytr8jt36d` FOREIGN KEY (`idnoi_that`) REFERENCES `noithat` (`idnoi_that`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKa1x01g6n2fvu8ffgq742p6q6j` FOREIGN KEY (`iddon_hang`) REFERENCES `dondathang` (`iddon_hang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dondathang`
--
ALTER TABLE `dondathang`
  ADD CONSTRAINT `FK9rqbfn3qrt39d170l5fgnaf09` FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhanvien` (`idnhan_vien`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKng0i1ycsfmrokmss3jyrfpa24` FOREIGN KEY (`id_khach_hang`) REFERENCES `khachhang` (`idkhach_hang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hinhanh`
--
ALTER TABLE `hinhanh`
  ADD CONSTRAINT `FKshe4vpm5qmswa04u98lkc4xxm` FOREIGN KEY (`id_noi_that`) REFERENCES `noithat` (`idnoi_that`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `FK6rmoqm0vkwm7da244lwgm44x4` FOREIGN KEY (`id_tai_khoan`) REFERENCES `taikhoan` (`idtai_khoan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `FKq6ilct1ry9ty7dfb4bcjyev2b` FOREIGN KEY (`id_tai_khoan`) REFERENCES `taikhoan` (`idtai_khoan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `noithat`
--
ALTER TABLE `noithat`
  ADD CONSTRAINT `FK1ryq4eet6y9gf5qj7hqi1ct70` FOREIGN KEY (`idkm`) REFERENCES `khuyenmai` (`idkhuyen_mai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK9yp5ngomspk0whpwamcgbi3hn` FOREIGN KEY (`id_loai`) REFERENCES `loainoithat` (`idloai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tk_vt`
--
ALTER TABLE `tk_vt`
  ADD CONSTRAINT `FK8s70bmhfddvf1ry71cif4lqh9` FOREIGN KEY (`idtai_khoan`) REFERENCES `taikhoan` (`idtai_khoan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKpesus0mvdy5lsj4f97n84e9je` FOREIGN KEY (`idvai_tro`) REFERENCES `role` (`idvai_tro`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
