drop table [hshjohannesh10].[hshjohannesh10].[ru_drivers]
CREATE TABLE ru_drivers
(
  id int Identity (1, 1) primary key NOT NULL,
  userId int foreign key references ru_users(id) NOT NULL UNIQUE
)

select * from [hshjohannesh10].[hshjohannesh10].[ru_drivers]