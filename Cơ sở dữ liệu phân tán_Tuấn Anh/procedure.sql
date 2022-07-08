create proc usp_QLTK_NGANHANG
	@key nvarchar(255)
as
begin
	select * from dbo.TaiKhoan where MACN like '%' + @key + '%'
end
exec usp_QLTK_NGANHANG 'CN5'

create procedure usp_ThemNhanVien
	@manv varchar(50),
	@ten nvarchar(50),
	@diachi nvarchar(50),
	@sdt varchar(50),
	@email varchar(50),
	@gt nvarchar(50),
	@chucvu varchar(50),
	@trangthai int,
	@macn varchar(50)
as
begin
	insert into QLTK_NGANHANG.dbo.Nhanvien (MANV, TEN, Diachi, SDT,EMAIL,GT, CHUCVU, TRANGTHAI, MACN) 
	values (@manv, @ten, @diachi, @sdt, @email, @gt, @chucvu,@trangthai,@macn)
end
exec usp_ThemNhanVien 'NV009', N'Hồ Chí Minh', N'Nghệ An', '0917584192',null, N'Nam', 'Nhan vien',1,N'CN5'


-------phep hop
go
set xact_abort on;
begin distributed transaction;
	select * from dbo.Nhan_vien  
	UNION 
	select * from LINK35.BAN_VE.DBO.Nhan_vien 
commit transaction;