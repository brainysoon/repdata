-- ------------------
-- 用户表脚本
-- ------------------
DROP TABLE IF EXISTS repdata.user;
CREATE TABLE repdata.user
(
  id         VARCHAR(22) PRIMARY KEY,
  name       VARCHAR(20) UNIQUE NOT NULL,
  password   VARCHAR(255)       NOT NULL,
  email      VARCHAR(50) UNIQUE,
  phone      VARCHAR(15) UNIQUE,
  avator     VARCHAR(255),
  resume     VARCHAR(255),
  github     VARCHAR(255),
  address    VARCHAR(255),
  birthday   DATE,
  domain     VARCHAR(255),
  updateTime DATETIME           NOT NULL,
  mark       INTEGER            NOT NULL,
  slead      INTEGER            NOT NULL,
  slat       VARCHAR(255)       NOT NULL
) ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- ----------------------
-- rep 表脚本
-- ----------------------
DROP TABLE IF EXISTS repdata.rep;
CREATE TABLE repdata.rep
(
  id         VARCHAR(22) PRIMARY KEY,
  userId     VARCHAR(22) UNIQUE NOT NULL,
  name       VARCHAR(255)       NOT NULL,
  label      VARCHAR(255)       NOT NULL,
  info       VARCHAR(255),
  size       INTEGER            NOT NULL,
  link       VARCHAR(255)       NOT NULL,
  extension  VARCHAR(10)        NOT NULL,
  open       INTEGER            NOT NULL,
  updateTime DATETIME           NOT NULL,
  mark       INTEGER            NOT NULL,
  slead      INTEGER            NOT NULL,
  CONSTRAINT `user_rep_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
) ENGINE = InnoDB
DEFAULT CHARSET = utf8;