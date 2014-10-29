USE [hshjohannesh10]

GO

drop table [hshjohannesh10].[ru_driver_ratings]
drop table [hshjohannesh10].[ru_trips]
drop table [hshjohannesh10].[ru_drivers]
drop table [hshjohannesh10].[ru_users]
drop table [hshjohannesh10].[ru_products]

GO

CREATE TABLE ru_users
(
  id int Identity (1, 1) primary key NOT NULL,
  username nvarchar(256) unique NOT NULL,
  firstname nvarchar(128),
  lastname nvarchar(128),
  password nvarchar(128),
  email nvarchar(256),
  registered datetime,
)

CREATE TABLE ru_products
(
  id int Identity (1, 1) primary key NOT NULL,
  description nvarchar(500) NOT NULL,
  displayName nvarchar(128) NOT NULL,
  capacity int NOT NULL,
  image nvarchar(256)
 )

CREATE TABLE ru_drivers
(
  id int Identity (1, 1) primary key NOT NULL,
  userId int foreign key references ru_users(id) NOT NULL UNIQUE,
  productId int foreign key references ru_products(id) NOT NULL,
  fullName nvarchar(256) NOT NULL
)

CREATE TABLE ru_trips
(
  id int Identity (1, 1) primary key NOT NULL,
  riderId int foreign key references ru_users(id) NOT NULL,
  driverId int foreign key references ru_drivers(id) NOT NULL,
  requestTime bigint,
  productId int,
  tripStatus nvarchar(256),
  distance float,
  startTime bigint,
  endTime bigint
)

CREATE TABLE ru_driver_ratings
(
  id int Identity (1, 1) primary key NOT NULL,
  riderId int foreign key references ru_users(id) NOT NULL,
  driverId int foreign key references ru_drivers(id) NOT NULL,
  rating int NOT NULL,
  comment nvarchar(500)
 )

GO

INSERT INTO [hshjohannesh10].[ru_users]
           ([username]
           ,[firstname]
           ,[lastname]
           ,[password]
           ,[email]
           ,[registered])
     SELECT 'joezombie', 'Johannes' ,'Heidarsson' ,'joezombie' ,'johannesh10@ru.is' ,getdate()
	 UNION ALL
	 SELECT 'tbickle', 'Travis' ,'Bickle' ,'tbickle' ,'travis@taxi.com' ,getdate()
	 UNION ALL
	 SELECT 'dmorales', 'Daniel' ,' Morales' ,'dmorales' ,'dmorales@taxi.fr' ,getdate()

GO

INSERT INTO [hshjohannesh10].[ru_products]
           ([description]
		   ,[displayName]
		   ,[capacity]
		   ,[image])
     VALUES
           ('A nice ride', 'The checker cab', 4, '/assets/images/checker_cab.jpg')
GO

INSERT INTO [hshjohannesh10].[ru_products]
           ([description]
		   ,[displayName]
		   ,[capacity]
		   ,[image])
     VALUES
           ('A fast ride', 'The white Peugeot', 4, '/assets/images/peugeot_white.jpg')
GO

INSERT INTO [hshjohannesh10].[ru_drivers]
           ([userId]
		   ,[productId]
		   ,[fullName])
     VALUES
           (2, 1, 'Travis Bickle')
GO

INSERT INTO [hshjohannesh10].[ru_drivers]
           ([userId]
		   ,[productId]
		   ,[fullName])
     VALUES
           (3, 2, 'Daniel Morales')
GO

INSERT INTO [hshjohannesh10].[ru_driver_ratings]
           ([riderId]
           ,[driverId]
           ,[rating]
           ,[comment])
     VALUES (1, 1, 5, 'The car was nice but the driver seemed a bit unstable')
GO

select * from [hshjohannesh10].[hshjohannesh10].[ru_users]
select * from [hshjohannesh10].[hshjohannesh10].[ru_drivers]
select * from [hshjohannesh10].[hshjohannesh10].[ru_trips]
select * from [hshjohannesh10].[hshjohannesh10].[ru_driver_ratings]
select * from [hshjohannesh10].[hshjohannesh10].[ru_products]



