USE [master]
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'Project_PRJ301b')
	DROP DATABASE Project_PRJ301b
GO

Create database Project_PRJ301b

go
use Project_PRJ301b
go

Create table Customer(
	cusID int primary key identity(0,1),
	cusName varchar(50) not null,
	cusPhone varchar(16),
	cusAddress varchar(100),
	status int default 0
)
go

Create table Account(
	accountID int primary key identity(1,1),
	username varchar(30) unique,
	password varchar(32) not null check(len(password)>=8),
	role int,
	cusID int foreign key references Customer(cusID)
)
go

Create table  Category(
	cateID varchar(2) primary key, 
	cateName nvarchar(50)
)
go
Create table Product(
	proID varchar(30) primary key,
	proName nvarchar(100) not null,
	quantity int check(quantity>=0), 
	price money check(price>=0),
	image varchar(100),
	cateID varchar(2) foreign key references Category(cateID)
)
go

Create table Voucher(
	vouID varchar(10) primary key,
	discount int,
	total int,
	status int default 0
) 
go

Create table Bill(
	orderID int primary key identity(1,1),
	dateCreate dateTime default getdate(),
	cusName nvarchar(50) not null,
	cusPhone varchar(16), 
	cusAddress nvarchar(100), 
	total money,
	cusID int foreign key references Customer(cusID),
	vouID varchar(10) foreign key references Voucher(vouID) default null
)
go
Create table BillDetail(
	proID varchar(30) foreign key references Product(proID),
	orderID int foreign key references Bill(orderID), 
	quantity int, 
	price money, 
	amount money,
	primary key(proID,orderID)
)

-----------------------------------------------------------------
-----------------------------------------------------------------
go 
insert into Customer(cusName, cusPhone, cusAddress, status) values
	('Dinh nam', '0987654321', 'hoa lac', 1), 
	('Vuong Giai Tue', '0964234234', 'Yuanlin, Changhua, Taiwan', 1),
	('Vuong Loi Nha', '0123789567', 'Taichung, Taiwan', 1),
	('Le Phuong Trieu Ha', '016327884', 'Hanoi, Vietnam', 1)
go
insert into Account(username, password, role, cusID) values
	('giaitue106', '12345678', 1, 0),
	('dinhnam277', '87654321', 1, 0),
	('admin', '00000000', 1, 0),
	('meobeongungoc', '12345678', 2, 1),
	('stupidfatcat', '12345678', 2, 2),
	('anata', '12345678', 2, 3)
go 
insert into Category(cateID, cateName) values
	('WD', 'Wedding'),
	('CO', 'Congratulations'),
	('AN', 'Anniversary'),
	('RO', 'Romance'),
	('DE', 'Decoration')
go
insert into Voucher values
	('', 0, 0, 0),
	('SPRING30', 30, 30, 1),
	('WOMANDAY20', 20, 0, 0),
	('WEDDING15', 15, 15, 1)
go
insert into Product values
	('P01', 'Love Letter', '15', 250.0, 'images/WD-LoveLetter.jpg', 'WD'),
	('P02', 'Magic Moments', '15', 150.0, 'images/WD-MagicMoments.jpg', 'WD'),
	('P03', 'Spring Poetry', '15', 250.0, 'images/WD-SpringPoetry.jpg', 'WD'),
	('P04', 'Beautiful Day', '15', 190.0, 'images/CO-BeautifulDay.jpg', 'CO'),
	('P05', 'New Day', '15', 130.0, 'images/CO-NewDay.jpg', 'CO'),
	('P06', 'Silent', '15', 200.0, 'images/CO-Silent.jpg', 'CO'),
	('P07', 'Forever', '15', 500.0, 'images/AN-Forever.jpg', 'AN'),
	('P08', 'Pink Dream', '15', 150.0, 'images/AN-PinkDream.jpg', 'AN'),
	('P09', 'Sweet Thoughts', '15', 230.0, 'images/AN-SweetThoughts.jpg', 'AN'),
	('P10', 'Color Of Love', '15', 260.0, 'images/RO-ColorOfLove.jpg', 'RO'),
	('P11', 'Told me', '15', 280.0, 'images/RO-ToldMe.jpg', 'RO'),
	('P12', 'Falling In Love', '15', 190.0, 'images/RO-FallingInLove.jpg', 'RO'),
	('P13', 'Reaching Hearts', '15', 320.0, 'images/DE-ReachingHearts.jpg', 'DE'),
	('P14', 'Warm Sunny', '15', 420.0, 'images/DE-WarmSunny.jpg', 'DE'),
	('P15', 'Wonder', '15', 360.0, 'images/DE-Wonder.jpg', 'DE')
go
insert into Bill (dateCreate, cusName, cusPhone, cusAddress, total, cusID, vouID) values
	('2022-01-20 12:12:12.000', 'Vuong Giai Tue', '0964234234', 'Yuanlin, Changhua, Taiwan', 500.0, 1, ''),
	('2022-01-22 15:06:23.100', 'Vuong Loi Nha', '0123789567', 'Taichung, Taiwan', 640.0, 2, ''),
	('2022-02-01 10:06:00.000', 'Le Phuong Trieu Ha', '016327884', 'Hanoi, Vietnam', 690.0, 3, '')
go
insert into BillDetail values
	('P03', 1, 2, 250, 500),
	('P11', 2, 1, 280, 280),
	('P15', 2, 1, 360, 360),
	('P09', 3, 3, 230, 690)
go
-------------------------------------------------
-------------------------------------------------
create Trigger update_Voucher
on Voucher
for update, insert
as
begin
	if update(status)
	begin
		update Voucher
		set total = discount * status
	end
end
go

create Trigger update_Quantity_Bill
on BillDetail
for delete,update,insert
as
begin
    if update(quantity)
    begin
	  Update BillDetail
	  set amount = price * quantity
    end
    begin
	  Update Bill
	  set total = ((select sum(price * quantity) from BillDetail where BillDetail.orderID = Bill.orderID
	  ) * (1 - ((select total from Voucher where Bill.vouID = Voucher.vouID) / 100)))
    end
end
go