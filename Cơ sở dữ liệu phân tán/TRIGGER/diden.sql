USE [BAN_VE]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
	CREATE TRIGGER [dbo].[diden]
		ON [dbo].[Chuyen_tau]
		AFTER INSERT, UPDATE
	AS
	declare @di varchar(50), @dem int
	set @di = (select Diemxuatphat from inserted)
	set @dem = (select count(*) from inserted where Diemketthuc = @di)
	if(@dem < 1)
	BEGIN
		print('Cập nhật thành công')
	END
	else
	BEGIN
	Rollback tran
	Raiserror('Lỗi insert chuyến tàu',16,1)
END