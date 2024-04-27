CREATE DATABASE IF NOT EXISTS ssm
    CHARACTER SET utf8;

USE ssm;

CREATE TABLE `m_user` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `username` varchar(64) DEFAULT NULL,
                          `avatar` varchar(255) DEFAULT NULL,
                          `email` varchar(64) DEFAULT NULL,
                          `password` varchar(64) DEFAULT NULL,
                          `status` int(5) NOT NULL,
                          `created` datetime DEFAULT NULL,
                          `last_login` datetime DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `UK_USERNAME` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `m_blog` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `user_id` bigint(20) NOT NULL,
                          `title` varchar(255) NOT NULL,
                          `description` varchar(255) NOT NULL,
                          `content` longtext,
                          `created` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
                          `status` tinyint(4) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
INSERT INTO `m_user` (`id`, `username`, `avatar`, `email`, `password`, `status`, `created`, `last_login`) VALUES ('1', 'markerhub', 'https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg', NULL, '96e79218965eb72c92a549dd5a330112', '0', '2020-04-20 10:44:01', NULL);


select * from m_user;

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

DROP TABLE IF EXISTS ``;
CREATE TABLE `user`
(
    `id`        BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`      VARCHAR(255) NOT NULL,
    `password`  VARCHAR(255) NOT NULL,
    `email`     VARCHAR(255) NOT NULL UNIQUE,
    `privilege` boolean      NOT NULL DEFAULT FALSE,
    `phone`     VARCHAR(255) NOT NULL
);

INSERT INTO `user` (name, password, email, privilege, phone)
VALUES ('admin', '123456', 'admin@email.com', TRUE, '123456789');
INSERT INTO `user` (name, password, email, privilege, phone)
VALUES ('root', '123', 'week@email.com', TRUE, '123456789');
INSERT INTO `user` (name, password, email, privilege, phone)
VALUES ('week', '123', 'weak@email.com', FALSE, '12345679');
select * from user;

INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理', '赵本山', '六小龄童', '人文社科', '123456', 1);
INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理1', '赵本山', '六小龄童', '人文社科', '123457', 1);
INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理2', '赵本山', '六小龄童', '人文社科', '123458', 1);
INSERT INTO book(title, author, publisher, category, isbn, quantity)
VALUES ('母猪的产后护理3', '赵本山', '六小龄童', '人文社科', '123459', 1);
select * from book;
