# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration

file: application.properties

jdbc.driverClassName = com.mysql.jdbc.Driver
jdbc.url = jdbc:mysql://localhost:3306/final
jdbc.username = final
jdbc.password = final01
hibernate.dialect = org.hibernate.dialect.MySQLDialect
hibernate.show_sql = true
hibernate.format_sql = true

* Database Creation

use `final`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `tag`;

CREATE TABLE `user` (
  `USER_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `LOGIN` VARCHAR(48) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `item` (
  `ITEM_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `TITLE` VARCHAR(48) NOT NULL,
  `BODY` VARCHAR(48) NOT NULL,
  `PRIORITY` INT(10),
  `SEVERITY` INT(10),
  `ESTIMATE` INT(10),
  `REMAINING` INT(10),
  `COMPLETITION` INT(10),
  PRIMARY KEY (`ITEM_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tag` (
  `TAG_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(48) NOT NULL,
  PRIMARY KEY (`TAG_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact