CREATE DATABASE QLTK_NGANHANG
GO

USE QLTK_NGANHANG
GO

--ChiNhanh - Phan manh ngang nguyen thuy
--KhachHang -> ChiNhanh - Phan manh ngang dan xuat
--NhanVien -> ChiNhanh - Phan manh ngang dan xuat
--TaiKhoan - Nhan ban
--ChuyenTien -> NhanVien - Phan manh ngang dan xuat
--GuiRut -> NhanVien - Phan manh ngang dan xuat

/****** Bang ChiNhanh ******/
CREATE TABLE ChiNhanh (
	MACN VARCHAR(10) NOT NULL PRIMARY KEY,
	TENCN NVARCHAR(100) NOT NULL UNIQUE,
	DIACHI NVARCHAR(100) NOT NULL,
	SDT VARCHAR(11) NOT NULL
)
GO

/****** Bang KhachHang ******/
CREATE TABLE KhachHang (
	MAKH VARCHAR(10) NOT NULL PRIMARY KEY,
	CMND VARCHAR(12) NOT NULL,
	QUOCTICH NVARCHAR(255) NOT NULL,
	DIACHI NVARCHAR(100) NOT NULL,
	SDT VARCHAR(15) NOT NULL,
	GT NVARCHAR(4) NOT NULL, -- Nam, Nu, Khac
	NGAYSINH DATE NOT NULL,
	EMAIL VARCHAR(255)
)
GO

/****** Bang NhanVien ******/
CREATE TABLE NhanVien (
	MANV VARCHAR(10) NOT NULL PRIMARY KEY,
	TEN NVARCHAR(255) NOT NULL,
	DIACHI NVARCHAR(255) NOT NULL,
	SDT VARCHAR(15) NOT NULL,
	EMAIL VARCHAR(255),
	GT NVARCHAR(4) NOT NULL, -- Nam, Nu, Khac
	LUONG FLOAT NOT NULL,
	TENTK VARCHAR(15) NOT NULL,
	MATKHAU VARCHAR(15) NOT NULL,
	CHUCVU VARCHAR(100) NOT NULL,
	TRANGTHAI BIT NOT NULL, -- 0: Nghi, 1: Lam
)
GO

/****** Bang TaiKhoan ******/
CREATE TABLE TaiKhoan (
	SOTK VARCHAR(10) NOT NULL PRIMARY KEY,
	SODU FLOAT NOT NULL CHECK (SODU >= 0),
	NGAYTAO DATETIME NOT NULL,
	TRANGTHAI BIT NOT NULL, -- 0: Khoa, 1: Hoat dong
)
GO

/****** Bang GuiRut ******/
CREATE TABLE GuiRut (
	MAGD INT PRIMARY KEY IDENTITY(1, 1),
	LOAIGD VARCHAR(2) NOT NULL, -- GT: Gui tien, RT: Rut tien
	THOIGIANDG DATETIME NOT NULL DEFAULT GETDATE(),
	SOTIENGD FLOAT NOT NULL CHECK (SOTIENGD >= 100000)
)
GO

/****** Bang ChuyenTien ******/
CREATE TABLE ChuyenTien (
	MAGD INT PRIMARY KEY IDENTITY(1, 1),
	THOIGIANDG DATETIME NOT NULL DEFAULT GETDATE(),
	SOTIENGD FLOAT NOT NULL CHECK(SOTIENGD >= 100000)
)
GO
/****** Them khoa ngoai MACN vao KhachHang ******/
ALTER TABLE KhachHang
ADD MACN VARCHAR(10) NOT NULL
CONSTRAINT FK_ChiNhanhKhangHang
FOREIGN KEY (MACN) REFERENCES ChiNhanh(MACN)
GO

/****** Them khoa ngoai MACN vao NhanVien ******/
ALTER TABLE NhanVien
ADD MACN VARCHAR(10) NOT NULL
CONSTRAINT FK_ChiNhanhNhanVien
FOREIGN KEY (MACN) REFERENCES ChiNhanh(MACN)
GO

/****** Them khoa ngoai MACN vao TaiKhoan ******/
ALTER TABLE TaiKhoan
ADD MACN VARCHAR(10) NOT NULL
CONSTRAINT FK_ChiNhanhTaiKhoan
FOREIGN KEY (MACN) REFERENCES ChiNhanh(MACN)

/****** Them khoa ngoai CMND vao TaiKhoan ******/
ALTER TABLE TaiKhoan
ADD MAKH VARCHAR(10) NOT NULL
CONSTRAINT FK_KhachHangTaiKhoan
FOREIGN KEY (MAKH) REFERENCES KhachHang(MAKH)
GO

/****** Them khoa ngoai SOTK vao GuiRut ******/
ALTER TABLE GuiRut
ADD SOTK VARCHAR(10) NOT NULL
CONSTRAINT FK_GuiRutTaiKhoan
FOREIGN KEY (SOTK) REFERENCES TaiKhoan(SOTK)
GO

/****** Them khoa ngoai MANV vao GuiRut ******/
ALTER TABLE GuiRut
ADD MANV VARCHAR(10) NOT NULL
CONSTRAINT FK_GuiRutNhanVien
FOREIGN KEY (MANV) REFERENCES NhanVien(MANV)
GO

/****** Them khoa ngoai SOTK_CHUYEN vao ChuyenTien ******/
ALTER TABLE ChuyenTien
ADD SOTK_CHUYEN VARCHAR(10) NOT NULL
CONSTRAINT FK_ChuyenTienTaiKhoan
FOREIGN KEY (SOTK_CHUYEN) REFERENCES TaiKhoan(SOTK)
GO

/****** Them khoa ngoai SOTK_NHAN vao ChuyenTien ******/
ALTER TABLE ChuyenTien
ADD SOTK_NHAN VARCHAR(10) NOT NULL
CONSTRAINT FK_NhanTienTaiKhoan
FOREIGN KEY (SOTK_NHAN) REFERENCES TaiKhoan(SOTK)
GO

/****** Them khoa ngoai MANV vao ChuyenTien ******/
ALTER TABLE ChuyenTien
ADD MANV VARCHAR(10) NOT NULL
CONSTRAINT FK_ChuyenTienNhanVien
FOREIGN KEY (MANV) REFERENCES NhanVien(MANV)
GO