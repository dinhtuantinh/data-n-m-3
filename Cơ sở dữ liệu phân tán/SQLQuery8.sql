use BAN_VE
go
set xact_abort on
begin distributed transaction 
	insert into BAN_VE.dbo.Tau_hoa(Ma,Hang,Gheloai1,Gheloai2) 
	values('TH999','9999','200','200')
commit transaction
go
select * from BAN_VE.dbo.Tau_hoa
go
---------------------
use BAN_VE
go
set xact_abort on
begin distributed transaction 
	insert into LINK17.BAN_VE.dbo.Chuyen_tau(Ma,MaTau,Diemxuatphat,Diemketthuc,Thoigianbatdau) 
	values('CT999','TH01','GA01','GA02','2022-06-05 08:00:00')
commit transaction
go
select * from LINK17.BAN_VE.dbo.Chuyen_Tau
go
-------------------

set xact_abort on;
begin distributed transaction;
	select * from BAN_VE.dbo.Ve_tau  
	UNION 
	select * from LINK17.BAN_VE.DBO.Ve_tau 
	
commit transaction;