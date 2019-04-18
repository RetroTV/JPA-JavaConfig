CREATE DATABASE hibernate;

CREATE TABLE hibernate.users (
    user_no INT(11) NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    user_password VARCHAR(200) NOT NULL,
    user_email VARCHAR(200) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_create_date DATETIME DEFAULT CURRENT_TIMESTAMP(),
    user_auth_status INT(1) DEFAULT '1',
    PRIMARY KEY (user_no)
);