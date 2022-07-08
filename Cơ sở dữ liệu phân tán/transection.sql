----Them moi transaction may minh
use DatabaseName
go
set xact_abort on
begin distributed transaction 
	insert into DatabaseName.dbo.table_name(...name_colum...) 
	values(..name_data..)
commit transaction
go
-----in ra
select * from DatabaseName.dbo.table_name

-----Them moi transaction may tram khac
use DatabaseName
go
set xact_abort on
begin distributed transaction 
	insert into LinkSever_Name.DatabaseName.dbo.table_name(...name_colum...) 
	values(..name_data..)
commit transaction
go

---in ra
select * from LinkSever_Name.DatabaseName.dbo.table_name
