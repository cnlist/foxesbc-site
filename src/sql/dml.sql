CREATE SEQUENCE seq_news;

CREATE TABLE news_item (
  Id          INTEGER UNIQUE DEFAULT nextval('seq_news') PRIMARY KEY,
  news_header TEXT,
  content     TEXT,
  enabled     BOOLEAN        DEFAULT TRUE
);


CREATE SEQUENCE seq_user;

CREATE TABLE site_user (
  Id          INT
  user_login  TEXT,
  user_passwd BYTEA,
  enabled     BOOLEAN    DEFAULT TRUE

);
