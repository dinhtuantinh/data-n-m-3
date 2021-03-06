CREATE TRIGGER TG_CHECK_ORDER_KHACH_HANG
ON	dbo.Khach_hang
FOR INSERT
AS
BEGIN
	DECLARE @SUGGEST_MA VARCHAR(11);
	SET @SUGGEST_MA =  (SELECT TOP 1 * FROM 
						(SELECT TOP 2 Ma FROM dbo.Khach_hang ORDER BY Ma DESC) AS Khach_hang
						ORDER BY Khach_hang.Ma);
	SET @SUGGEST_MA = (SELECT CAST(SUBSTRING(@SUGGEST_MA, 3, 6) AS INT));
	SET @SUGGEST_MA = @SUGGEST_MA + 1;

	DECLARE @LAST_MA VARCHAR(11);
	SET @LAST_MA =  (SELECT Ma FROM inserted);
	SET @LAST_MA = (SELECT CAST(SUBSTRING(@LAST_MA, 3, 6) AS INT));
	SET @LAST_MA = @LAST_MA;

	DECLARE @STR_ERR VARCHAR(100);
	SET @STR_ERR = 'WE RECOMMEND YOU TO USE KH' + @SUGGEST_MA +  ' FOR MAKH'
	IF (@LAST_MA != @SUGGEST_MA)
	BEGIN
		RAISERROR(@STR_ERR , 10, 1)
		ROLLBACK
	END
END













SELECT * FROM dbo.Khach_hang  

SELECT TOP 1 * FROM 
	(SELECT TOP 2 Ma FROM dbo.Khach_hang ORDER BY Ma DESC) AS Khach_hang
	ORDER BY Khach_hang.Ma;

--Lấy thêm nhân viên từ máy chủ
select m from LINK16.BAN_VE.dbo.Nhan_vien