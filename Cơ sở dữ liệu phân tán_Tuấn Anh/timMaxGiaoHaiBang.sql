go
set xact_abort on;
begin distributed transaction;
	declare @ve varchar(50), @luong varchar(50)
	set @ve = (select Max(Giave) from dbo.Ve_tau)
	---UNION 
	set @luong = (select Max(Bacluong) from dbo.Nhan_vien)
	if (@ve>=@luong) print(@ve)
	else print(@luong)
commit transaction;

