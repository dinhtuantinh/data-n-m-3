create database qlvt1;
create table tblGood(
ID integer not null auto_increment,
name varchar(255) not null,
des varchar(255) not null,
amount integer not null,
primary key (ID)
);
create table qlvt1.tblUser(
ID integer not null auto_increment,
username varchar(255) not null,
password varchar(255) not null,
position varchar(255) not null,
name varchar(255) not null,
address varchar(255) not null,
phonenumber varchar(255) not null,
primary key (ID)
);
create table qlvt1.tblSupplier(
ID integer not null auto_increment,
name varchar(255) not null,
address varchar(255) not null,
phonenumber varchar(255) not null,
primary key (ID)
);
create table qlvt1.tblReceipt(
ID integer not null auto_increment,
date varchar(255) not null,
IDUser integer not null,
IDSupplier integer not null,
primary key (ID),
foreign key (IDSupplier) references qlvt1.tblSupplier(ID) on delete cascade,
foreign key (IDUser) references qlvt1.tblUser(ID) on delete cascade
);
create table qlvt1.tblImportedGood(
amount integer not null,
price double not null,
IDGood integer not null,
IDReceipt integer not null,
foreign key (IDReceipt) references qlvt1.tblReceipt(ID) on delete cascade,
foreign key (IDGood) references qlvt1.tblGood(ID) on delete cascade
);
create table qlvt1.tblAgency(
ID integer not null auto_increment,
name varchar(255) not null,
address varchar(255) not null,
phonenumber varchar(255) not null,
primary key (ID)
);
create table qlvt1.tblBill(
ID integer not null auto_increment,
date varchar(255) not null,
IDUser integer not null,
IDAgency integer not null,
primary key (ID),
foreign key (IDAgency) references qlvt1.tblAgency(ID) on delete cascade,
foreign key (IDUser) references qlvt1.tblUser(ID) on delete cascade
);
create table qlvt1.tblExportedGood(
amount integer not null,
price double not null,
IDGood integer not null,
IDBill integer not null,
foreign key (IDBill) references qlvt1.tblBill(ID) on delete cascade,
foreign key (IDGood) references qlvt1.tblGood(ID) on delete cascade
);



