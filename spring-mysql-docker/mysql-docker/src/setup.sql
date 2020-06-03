CREATE DATABASE mysql_test;
USE mysql_test;

CREATE TABLE product (
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(128) not null,
category varchar(24) null);

INSERT INTO mysql_test.product (name, category) VALUES ('product one', 'category A');
INSERT INTO mysql_test.product (name, category) VALUES ('product two', 'category A');
INSERT INTO mysql_test.product (name, category) VALUES ('product third', 'category B');
INSERT INTO mysql_test.product (name, category) VALUES ('product forth', 'category C');

