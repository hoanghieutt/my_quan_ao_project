use master
go
drop DATABASE DuAn1_QuanLyBanQuanAo
go
CREATE DATABASE DuAn1_QuanLyBanQuanAo
GO
USE DuAn1_QuanLyBanQuanAo
GO


CREATE TABLE ChucVu(
	MaCV INT IDENTITY(1, 1)NOT NULL,
	TenCV NVARCHAR(50) not null,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MaCV)
)


insert into ChucVu values
(N'Quản Lý','2002-12-12','2002-12-12',DEFAULT),
(N'Nhân Viên','2002-12-12','2002-12-12',DEFAULT)

CREATE TABLE NHANVIEN(
	MaNV  INT IDENTITY(1, 1),
	MaCV int not null,
	TenNV NVARCHAR(30) NOT NULL,
	DiaChi NVARCHAR(50) NOT NULL,
	GioiTinh BIT DEFAULT 1 NOT NULL,
	Email VARCHAR(30) NOT NULL,
	SoDienThoai VARCHAR(12) NOT NULL,
	NgaySinh DATE NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaNV),
	FOREIGN KEY(MaCV) REFERENCES dbo.ChucVu(MaCV),
)
go
insert into NHANVIEN values (2,N'NV01',N'Ha Noi',0,N'nv1@gmail.com','0123456789','2022-02-02','2003-01-01','2002-02-02',0)
insert into NHANVIEN values (1,N'NV02',N'Ha Tinh',0,N'nv2@gmail.com','0123456788','2021-02-02','2003-01-01','2002-02-02',1)
insert into NHANVIEN values (1,N'NV03',N'Ha Nam',0,N'nv3@gmail.com','0123456787','2020-02-02','2003-01-01','2002-02-02',0)
insert into NHANVIEN values (1,N'NV04',N'Soc Son',1,N'nv4@gmail.com','0123456786','2019-02-02','2003-01-01','2002-02-02',1)
insert into NHANVIEN values (1,N'Văn Đình Sơn',N'Sầm Sơn',1,N'sonvdph23054@fpt.edu.vn','0862521305','2018-02-02','2003-01-01','2002-02-02',0)


CREATE TABLE KHACHHANG(
	MaKH INT IDENTITY(1, 1),
	TenKH NVARCHAR(30) NOT NULL,
	NgaySinh DATE,
	GioiTinh BIT DEFAULT 1 NULL,
	SoDienThoai VARCHAR(12) NOT NULL,
	DiaChi NVARCHAR(50),
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL

	PRIMARY KEY(MaKH)
)

ALTER TABLE KHACHHANG
ALTER COLUMN SoDienThoai varchar(12) null 

ALTER TABLE KHACHHANG
ALTER COLUMN TenKH nvarchar(30) null 

insert into KHACHHANG values (N'Khách Hàng Lẻ','2022-02-02',1,'0862521305',N'Ha Noi','2003-01-01','2002-02-02',0)
insert into KHACHHANG values (N'Đỗ Hữu Nguyện','2021-02-02',0,'0123456788',N'Ha Nam','2003-01-01','2002-02-02',1)
insert into KHACHHANG values (N'Văn Đình Sơn','2020-02-02',0,'0123456787',N'Ha tinh','2003-01-01','2002-02-02',1)
insert into KHACHHANG values (N'Vương Văn Phước','2019-02-02',0,'0123456786',N'Soc Son','2003-01-01','2002-02-02',0)
insert into KHACHHANG values (N'Dương Tiết Sơn','2018-02-02',1,'0123456785',N'Ham Tu liem','2003-01-01','2002-02-02',0)


CREATE TABLE HINHTHUCTHANHTOAN(
	MaHTTT INT IDENTITY(1, 1)NOT NULL,
	TenHTTT NVARCHAR(30) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaHTTT)
)


INSERT INTO dbo.HINHTHUCTHANHTOAN
(
    TenHTTT,
    TrangThai,
	NgayTao,
	NgaySua
)
VALUES
(   N'Tiền mặt',DEFAULT ,'2021-01-01','2021-01-01'),
(   N'Quẹt thẻ',DEFAULT ,'2021-01-01','2021-01-01'),
(   N'Chuyển khoản',DEFAULT  ,'2021-01-01','2021-01-01')


CREATE TABLE SANPHAM(
	MaSP INT IDENTITY(1, 1) NOT NULL,
	TenSp nvarchar(50) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaSP)
)

insert into SANPHAM values (N'SP1','2003-01-01','2002-02-02',0)
insert into SANPHAM values (N'SP2','2003-01-01','2002-02-02',1)
insert into SANPHAM values (N'SP3','2003-01-01','2002-02-02',0)
insert into SANPHAM values (N'SP4','2003-01-01','2002-02-02',1)
insert into SANPHAM values (N'SP5','2003-01-01','2002-02-02',0)


CREATE TABLE LOAISP(
	MaLoai INT IDENTITY(1, 1)NOT NULL,
	TenLoai NVARCHAR(30) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaLoai)
   
)
insert into LOAISP values (N'LSP1','2003-01-01','2002-02-02',0)
insert into LOAISP values (N'LSP2','2003-01-01','2002-02-02',1)
insert into LOAISP values (N'LSP3','2003-01-01','2002-02-02',0)
insert into LOAISP values (N'LSP4','2003-01-01','2002-02-02',1)
insert into LOAISP values (N'LSP5','2003-01-01','2002-02-02',0)


CREATE TABLE MAUSAC(
	MaMauSac int IDENTITY(1, 1) NOT NULL,
	TenMauSac NVARCHAR(15) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaMauSac)
)

insert into MAUSAC values (N'MS1','2003-01-01','2002-02-02',0)
insert into MAUSAC values (N'MS2','2003-01-01','2002-02-02',1)
insert into MAUSAC values (N'MS3','2003-01-01','2002-02-02',1)
insert into MAUSAC values (N'MS4','2003-01-01','2002-02-02',1)
insert into MAUSAC values (N'MS4','2003-01-01','2002-02-02',0)


CREATE TABLE CHATLIEU(
	MaChatLieu INT IDENTITY(1, 1) NOT NULL,
	TenChatLieu NVARCHAR(15) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaChatLieu)
)
insert into CHATLIEU values (N'CL1','2003-03-03','2009-09-09',0)
insert into CHATLIEU values (N'CL2','2003-03-03','2009-09-09',1)
insert into CHATLIEU values (N'CL3','2003-03-03','2009-09-09',0)
insert into CHATLIEU values (N'CL4','2003-03-03','2009-09-09',1)
insert into CHATLIEU values (N'CL5','2003-03-03','2009-09-09',0)

CREATE TABLE KICHTHUOC(
	MaKichThuoc INT IDENTITY(1, 1) NOT NULL,
	KichThuoc NVARCHAR(15) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaKichThuoc)
)

insert into KICHTHUOC values (N'KT1','2003-01-01','2002-02-02',0)
insert into KICHTHUOC values (N'KT2','2003-01-01','2002-02-02',0)
insert into KICHTHUOC values (N'KT3','2003-01-01','2002-02-02',1)
insert into KICHTHUOC values (N'KT4','2003-01-01','2002-02-02',1)
insert into KICHTHUOC values (N'KT5','2003-01-01','2002-02-02',0)

CREATE TABLE KHUYENMAI(
	MaKM INT IDENTITY(1, 1) NOT NULL,
	TenKM NVARCHAR(50) NOT NULL,
	NgayBatDau DATE,
	NgayKetThuc DATE,
	GiamGia money NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaKM)
)
insert into KHUYENMAI values (N'KM1','2018-02-02','2019-01-01',0,'2003-01-01','2002-02-02',0)
insert into KHUYENMAI values (N'KM2','2018-02-02','2019-01-01',100,'2003-01-01','2002-02-02',1)
insert into KHUYENMAI values (N'KM3','2018-02-02','2019-01-01',600,'2003-01-01','2002-02-02',1)
insert into KHUYENMAI values (N'KM4','2018-02-02','2019-01-01',700,'2003-01-01','2002-02-02',0)
insert into KHUYENMAI values (N'KM5','2018-02-02','2019-01-01',1000,'2003-01-01','2002-02-02',0)

CREATE TABLE HOADON(
	MaHD INT IDENTITY(1, 1) NOT NULL,
	MaKH INT NOT NULL,
	MaNV INT NOT NULL,	
	MaHTTT INT NOT NULL,
	MaKM int ,	
	GhiChu NVARCHAR(100) NULL,
	ThanhTien MONEY ,
	NgayTao date not null,
	NgaySua date  null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaHD)
	FOREIGN KEY(MaKH) REFERENCES dbo.KHACHHANG(MaKH),
	FOREIGN KEY(MaNV) REFERENCES dbo.NHANVIEN(MaNV),
	FOREIGN KEY(MaKM) REFERENCES dbo.KHUYENMAI(MaKM),
	FOREIGN KEY(MaHTTT) REFERENCES dbo.HINHTHUCTHANHTOAN(MaHTTT)
)
ALTER TABLE HOADON
ALTER COLUMN MaKH int null 

ALTER TABLE HOADON
ALTER COLUMN MaHTTT int null 

insert into HOADON values (1,1,1,1,N'Hang Fake','1000000','2003-01-01','2002-02-02',0)
insert into HOADON values (2,2,2,2,N'Hang Fake','1000001','2003-01-01','2002-02-02',0)
insert into HOADON values (3,3,3,3,N'Hang ok','1000002','2003-01-01','2002-02-02',1)
insert into HOADON values (4,4,2,4,N'deu lam dung mua','1000003','2003-01-01','2002-02-02',1)
insert into HOADON values (5,5,1,5,N'Hang danh cho nguoi co ny','1000005','2003-01-01','2002-02-02',0)

CREATE TABLE MONTHETHAO(
	MAMTT INT IDENTITY(1, 1),
	TENMTT NVARCHAR(10) NOT NULL,
	NGAYTAO DATE NOT NULL,
	NGAYSUA DATE NOT NULL,
	TRANGTHAI BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MAMTT),
)
insert into MONTHETHAO values (N'MTT1','2003-01-01','2002-02-02',0)
insert into MONTHETHAO values (N'MTT2','2003-01-01','2002-02-02',1)
insert into MONTHETHAO values (N'MTT3','2003-01-01','2002-02-02',0)
insert into MONTHETHAO values (N'MTT4','2003-01-01','2002-02-02',1)
insert into MONTHETHAO values (N'MTT5','2003-01-01','2002-02-02',0)

CREATE TABLE CLB(
	MACLB INT IDENTITY(1, 1),
	MAMTT INT,
	TENCLB NVARCHAR(100) NULL,
	NGAYTAO DATE NOT NULL,
	NGAYSUA DATE NOT NULL,
	TRANGTHAI BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MACLB),
	FOREIGN KEY(MAMTT) REFERENCES dbo.MONTHETHAO(MAMTT),

)

insert into CLB values (1,N'CLB1','2003-01-01','2002-02-02',0)
insert into CLB values (2,N'CLB2','2003-01-01','2002-02-02',1)
insert into CLB values (3,N'CLB3','2003-01-01','2002-02-02',1)
insert into CLB values (4,N'CLB4','2003-01-01','2002-02-02',0)
insert into CLB values (5,N'CLB5','2003-01-01','2002-02-02',0)

CREATE TABLE CHITIETSANPHAM(
	MaCTSP INT IDENTITY(1,1),
	MaSP INT NOT NULL,
	MaLoai INT NOT NULL,
	MaMauSac int NOT NULL,
	MaKichThuoc INT NOT NULL,
	MaChatLieu INT NOT NULL,
	MaMTT INT NOT NULL,
	SoLuong INT NOT NULL,
	Gia Money NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaCTSP)
	FOREIGN KEY(MaSP) REFERENCES SanPham(MaSP),
	FOREIGN KEY(MaMauSac) REFERENCES dbo.MAUSAC(MaMauSac),
	FOREIGN KEY(MaChatLieu) REFERENCES dbo.CHATLIEU(MaChatLieu),
	FOREIGN KEY(MaKichThuoc) REFERENCES dbo.KICHTHUOC(MaKichThuoc),
	FOREIGN KEY(MaLoai) REFERENCES dbo.LOAISP(MaLoai),
	FOREIGN KEY(MaMTT) REFERENCES dbo.MONTHETHAO(MAMTT),

)

insert into CHITIETSANPHAM values (1,'1','1','1','1','1','10','10000','2003-01-01','2002-02-02',0)
insert into CHITIETSANPHAM values (2,'2','2','2','2','2','11','10001','2003-01-01','2002-02-02',1)
insert into CHITIETSANPHAM values (3,'3','3','3','3','3','12','10002','2003-01-01','2002-02-02',1)
insert into CHITIETSANPHAM values (4,'4','4','4','4','4','13','10003','2003-01-01','2002-02-02',0)
insert into CHITIETSANPHAM values (5,'5','5','5','5','5','14','10004','2003-01-01','2002-02-02',0)



CREATE TABLE HOADONCHITIET(
	MaHDCT INT IDENTITY(1, 1),
	MaHD INT NOT NULL,
	MaCTSP INT NOT NULL,
	SoLuong INT NOT NULL,
	Gia Money NOT NULL,
	GiamGia int NULL,
	ThanhTien Money NOT NULL,
	GhiChu NVARCHAR(100) NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL

	PRIMARY KEY(MaHDCT)
	FOREIGN KEY(GiamGia) REFERENCES dbo.KhuyenMai(MaKM),
	FOREIGN KEY(MaHD) REFERENCES dbo.HOADON(MaHD),
	FOREIGN KEY(MaCTSP) REFERENCES dbo.CHITIETSANPHAM(MaCTSP)
)

insert into HOADONCHITIET values (1,1,10000,2000,1,1,N'ô sờ kê','2003-01-01','2002-02-02',0)
insert into HOADONCHITIET values (2,2,10000,2000,1,2,N'ô sờ kê','2003-01-01','2002-02-02',0)
insert into HOADONCHITIET values (3,3,10000,2000,1,3,N'ô sờ kê','2003-01-01','2002-02-02',1)
insert into HOADONCHITIET values (4,4,10000,2000,1,4,N'ô sờ kê','2003-01-01','2002-02-02',1)
insert into HOADONCHITIET values (5,5,10000,2000,1,5,N'ô sờ kê','2003-01-01','2002-02-02',0)

CREATE TABLE LichSu(
	MaLS int IDENTITY(1, 1),
	MaHDCT INT ,
	ThanhTien Money NOT NULL,
	GhiChu NVARCHAR(100) NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL

	PRIMARY KEY(MaLS)
	FOREIGN KEY(MaHDCT) REFERENCES dbo.HOADONCHITIET(MaHDCT)
)

CREATE TABLE USERR(
	SoDienThoai varchar(10),
	MaCV int,
	MaNV int,
	Mk nvarchar(max),
	FOREIGN KEY(MaCV) REFERENCES dbo.CHUCVU(MaCV),
	FOREIGN KEY(MaNV) REFERENCES dbo.NhanVien(MaNV),
)
insert into USERR values('0123456789',1,1,'1')
insert into USERR values('0862521305',1,1,'1')

select * from NHANVIEN
select * from USERR

CREATE TABLE DoiTra(
	MaDT INT IDENTITY(1, 1),
	MaCTSP INT NOT NULL,
	MaHDCT int not null,
	LyDo nvarchar(max) not null,
	NgayDoi date not null,
	NgayBan date not null,
	TrangThai BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MaDT),
	FOREIGN KEY(MaCTSP) REFERENCES CHITIETSANPHAM(MaCTSP),
	FOREIGN KEY(MaHDCT) REFERENCES dbo.HoaDonCHiTiet(MaHDCT),
)
insert into DoiTra values (1,1,N'Không ưng nữa','2002-02-02','2002-02-02',0)
insert into DoiTra values (2,2,N'Lỗi Nhà sản xuất','2002-02-02','2002-02-02',0)
insert into DoiTra values (3,3,N'Chưa dùng đã hỏng','2002-02-02','2002-02-02',1)
insert into DoiTra values (4,4,N'Thích thì đổi','2002-02-02','2002-02-02',1)
insert into DoiTra values (5,5,N'Không ưng nữa','2002-02-02','2002-02-02',0)

CREATE TABLE THONGKE(
	MaTK INT IDENTITY(1, 1),
	MaHDCT INT NOT NULL,
	MaDT int,
	TongTien MONEY not null,
	NgayBan date not null,
	TrangThai BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MaTK),
	FOREIGN KEY(MaHDCT) REFERENCES dbo.HOADONCHITIET(MaHDCT),
	FOREIGN KEY(MaDT) REFERENCES dbo.DoiTra(MaDT),

)
insert into THONGKE values (1,1,'1000000000','2002-02-02',0)
insert into THONGKE values (2,2,'1000000009','2002-02-03',1)
insert into THONGKE values (3,3,'1000000009','2002-02-04',1)
insert into THONGKE values (4,4,'1000999999','2002-02-05',1)
insert into THONGKE values (5,5,'1999999999','2002-02-06',0)


