USE [QLTK_NGANHANG]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
	CREATE TRIGGER [dbo].[checkChuyenTien]
		ON [dbo].[ChuyenTien]
		AFTER INSERT, UPDATE
	AS
	declare @chuyen varchar(50), @dem int
	set @chuyen = (select SOTK_CHUYEN from inserted)
	set @dem = (select count(*) from inserted where SOTK_nhan = @chuyen)
	if(@dem < 1)
	BEGIN
		print('Cập nhật thành công')
	END
	else
	BEGIN
	Rollback tran
	Raiserror('Lỗi insert Chuyen tien',16,1)
END