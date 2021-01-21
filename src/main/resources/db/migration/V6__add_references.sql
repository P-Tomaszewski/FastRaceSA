alter table DRIVERRACERESULTS
    add foreign key (driver_id) references drivers(id);

alter table DRIVERRACERESULTS
    add foreign key (race_id) references races(id);

