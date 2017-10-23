CREATE DATABASE adlister_db;

CREATE USER adlister_user@localhost
  IDENTIFIED BY 'adlister_pwd';

GRANT ALL ON adlister_db.* TO adlister_user@localhost;