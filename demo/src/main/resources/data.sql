DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Polls;

CREATE TABLE Users (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    age int(11) unsigned NOT NULL AUTO_INCREMENT,
    address varchar(300) NOT NULL DEFAULT '',
    joining_date varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE Polls (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(300) NOT NULL DEFAULT '',
    first_ans varchar(300) NOT NULL DEFAULT '',
    second_ans varchar(300) NOT NULL DEFAULT '',
    third_ans varchar(300) NOT NULL DEFAULT '',
    fourth_ans varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);