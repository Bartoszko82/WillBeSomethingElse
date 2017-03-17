# README #

### SDA JAVA course - final project ###
* authors: Bartosz and Piotr Zawodniak.
* 0.0.2.
* please be advised that this is early stage of developement, with only basic functions implemented.


### How do I get set up? ###

* Database configuration

jdbc.driverClassName = com.mysql.jdbc.Driver
jdbc.url = jdbc:mysql://localhost:3306/final
jdbc.username = final
jdbc.password = final01
hibernate.dialect = org.hibernate.dialect.MySQLDialect
hibernate.show_sql = true
hibernate.format_sql = true


* Database Creation

drop schema if exists `final`;

create schema `final`;

use `final`;

DROP TABLE IF EXISTS `user`;

DROP TABLE IF EXISTS `item`;

DROP TABLE IF EXISTS `tag`;



CREATE TABLE `user` (

  `USER_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,

  `LOGIN` VARCHAR(48) NOT NULL,
  
  `PASSWORD` VARCHAR(48) NOT NULL,
  
  `EMAIL` VARCHAR(48) NOT NULL,

  PRIMARY KEY (`USER_ID`) USING BTREE

) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `item` (

  `ITEM_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  
  `ITEM_STATE` VARCHAR(48) NOT NULL,

  `TITLE` VARCHAR(48) NOT NULL,

  `BODY` VARCHAR(48) NOT NULL,
  
  `ITEM_TYPE` VARCHAR(48) NOT NULL,

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