/*Thong ke mat hang ban chay co liet ke cac mat hang chua he duoc xuat kho*/
SELECT
	a.id,
    a.name,
    a.des,
	(
		SELECT SUM(b.amount)
		FROM qlvt.tblExportedGood as b, qlvt.tblBill as c
		WHERE b.idgood = a.id AND b.idbill = c.id AND c.date > ? AND c.date < ? GROUP BY b.idgood
	) as amount, 
	(
		SELECT SUM(b.amount * b.price)
		FROM qlvt.tblExportedGood as b, qlvt.tblBill as c
		WHERE b.idgood = a.id AND b.idbill = c.id AND c.date > ? AND c.date < ? GROUP BY b.idgood
	) as income
FROM
	qlvt.tblGood as a ORDER BY income DESC, amount DESC;
    
    
/*Thong ke mat hang ban chay khong liet ke cac mat hang chua he duoc xuat kho*/
SELECT 
	a.id, 
    a.name, 
    a.des, 
    SUM(b.amount) as amount, 
    SUM(b.amount * b.price) as income
FROM 
	qlvt.tblGood as a, qlvt.tblExportedGood as b, qlvt.tblBill as c
WHERE
	b.idgood = a.id AND b.idbill = c.id AND c.date > ? AND c.date < ? GROUP BY b.idgood ORDER BY income DESC, amount DESC;
        
        
/*Thong ke cac hoa don chua mat hang da chon*/
SELECT 
    a.amount as amount,
    a.price as price,
    (a.amount * a.price) as intoMoney, 
    b.id as idbill, 
    b.date as date,
    c.id as idagency, 
    c.name as agencyName, 
    c.address as agencyAddress, 
    c.phonenumber as agencyPhoneNumber
FROM 
	qlvt.tblexportedgood as a,     
    qlvt.tblBill as b, 
    qlvt.tblagency as c 
WHERE 
	a.idgood = ? AND b.date > ? AND b.date < ? AND b.id = a.idbill AND c.id = b.idagency