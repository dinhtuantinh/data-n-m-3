CREATE TRIGGER add_Nhan_vien
	on Nhan_vien
	for insert, update
as 
	declare @maKH varchar(50),@maG varchar(50)
	set @maKH= (select Ma from inserted)
	set @maG= (select MaGa from inserted)
	if (SELECT SUBSTRING(@maKH, 3, 1)) = (SELECT SUBSTRING(@maG, 4, 1))
	begin
		print ('OK')
	END
	else
	BEGIN 
	Rollback tran
	print('Error: MANV format NV+ma ga+stt add, VD: Ga 01 thi ma nhan vien la: NH01,NV02,...')
	end
	