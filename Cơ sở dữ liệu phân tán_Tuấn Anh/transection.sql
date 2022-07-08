-----Them moi transaction may tram khac
use QLTK_NGANHANG
go
set xact_abort on
begin distributed transaction 
	insert into dbo.TaiKhoan(SOTK,SODU,NGAYTAO,TRANGTHAI,MACN,MAKH)
	values('77777',100000000,'2021-01-10 00:00:00.000',1,'CN5','KH05')
	insert into dbo.TaiKhoan(SOTK,SODU,NGAYTAO,TRANGTHAI,MACN,MAKH)
	values('88888',100000000,'2021-02-10 00:00:00.000',1,'CN8','KH08')
	insert into dbo.chuyentien(THOIGIANDG,SOTIENGD,SOTK_CHUYEN,SOTK_NHAN,MANV)
	values('2021-07-10 00:00:00.000',1000000,'77777','88888','NV005')
commit transaction
go

---in ra
select * from LINKBAOANH.QLTK_NGANHANG.dbo.chuyentien
-----max

---Viet 1 transaction de chuyen tien tu tai khoan cua khach hang a sang tai khoan cua khac hang b 
--gia su thong tin can thiet: khach hang, nhan vien deu da co. Cac hoat dong cua chuyen tien dat
--trong 1 transactiontransac 