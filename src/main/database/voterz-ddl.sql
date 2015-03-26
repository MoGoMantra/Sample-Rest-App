create table party (
party_id INTEGER AUTO_INCREMENT PRIMARY KEY,
party_name varchar (200) not null,
party_symbol blob null,
party_short_name varchar (10) not null,
constraint PARTY_UK unique (party_short_name)
);
go;
create index PARTY_S_NAME on party (party_short_name);
go;

