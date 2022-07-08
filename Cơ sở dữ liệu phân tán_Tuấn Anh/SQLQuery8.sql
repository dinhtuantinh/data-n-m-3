select * from LINKQUY.QLTK_NGANHANG.dbo.NhanVien
----Them moi transaction may minh
use QLTK_NGANHANG
go
set xact_abort on
begin distributed transaction 
	insert into QLTK_NGANHANG.dbo.table_name(...name_colum...) 
	values(..name_data..)
commit transaction
go
-----in ra
select * from DatabaseName.dbo.table_name

-----Them moi transaction may tram khac
use QLTK_NGANHANG
go
set xact_abort on
begin distributed transaction 
	insert into LINKQUAN.QLTK_NGANHANG.dbo.NhanVien(MANV,TEN,DIACHI,SDT,EMAIL,GT,CHUCVU,TRANGTHAI,MACN) 
	values('NV032','Dinh Anh','Thanh Hoa','123456789',NULL,'Nam','Giao dich vien',1,'CN2')
commit transaction
go

---in ra
select * from LinkSever_Name.DatabaseName.dbo.table_name
