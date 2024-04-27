CREATE DATABASE IF NOT EXISTS ssm
    CHARACTER SET utf8;

USE ssm;

DROP DATABASE IF EXISTS `library`;

CREATE DATABASE `library` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `library`;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`        BIGINT                                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`     VARCHAR(255)                           NOT NULL,
    `author`    VARCHAR(255)                           NOT NULL,
    `publisher` VARCHAR(255)                           NOT NULL,
    `category`  VARCHAR(255)                           NOT NULL,
    `isbn`      VARCHAR(255)                           NOT NULL UNIQUE,
    `quantity`  INT                                    NOT NULL
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`        BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`      VARCHAR(255) NOT NULL,
    `password`  VARCHAR(255) NOT NULL,
    `email`     VARCHAR(255) NOT NULL UNIQUE,
    `privilege` boolean      NOT NULL DEFAULT FALSE,
    `phone`     VARCHAR(255) NOT NULL
);


DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`
(
    `id`      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `bookId`  BIGINT NOT NULL,
    `userId`  BIGINT NOT NULL,
    `bookTitle` VARCHAR(255) NOT NULL ,
    `userName` VARCHAR(255) NOT NULL,
    `borrowDate` datetime NOT NULL
);

INSERT INTO `user` (name, password, email, privilege, phone)
VALUES ('admin', '123456', 'admin@email.com', TRUE, '123456789');
INSERT INTO `user` (name, password, email, privilege, phone)
VALUES ('root', '123', 'week@email.com', TRUE, '123456789');
INSERT INTO `user` (name, password, email, privilege, phone)
VALUES ('week', '123', 'weak@email.com', FALSE, '12345679');
select * from user;

select * from user where email = 'weak@email.com' and password='123';

INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理', '赵本山', '六小龄童', '人文社科', '123456', 1);
INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理1', '赵本山', '六小龄童', '人文社科', '123457', 1);
INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理2', '赵本山', '六小龄童', '人文社科', '123458', 1);
INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理3', '赵本山', '六小龄童', '人文社科', '123459', 1);
select * from book;


select * from borrow;
