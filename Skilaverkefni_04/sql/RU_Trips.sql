drop table [hshjohannesh10].[hshjohannesh10].[ru_trips]
CREATE TABLE ru_trips
(
  id int Identity (1, 1) primary key NOT NULL,
  riderId int foreign key references ru_users(id) NOT NULL,
  driverId int foreign key references ru_drivers(id) NOT NULL,
  requestTime bigint,
  productId int,
  tripStatus int,
  distance float,
  startTime bigint,
  endTime bigint
)
