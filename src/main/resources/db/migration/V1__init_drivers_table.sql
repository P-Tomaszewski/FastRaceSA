drop table if exists drivers;
create table drivers(
    id int primary key auto_increment,
    car varchar (100) not null,
    first_name varchar (100) not null,
    last_name varchar (100) not null,
    team varchar (100) not null
)