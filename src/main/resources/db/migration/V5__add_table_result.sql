create table driverraceresults
(
    id int primary key auto_increment,
    driver_id int,
    race_id int,
    place int,
    time datetime,
    the_best_time datetime
);