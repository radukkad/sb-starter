CREATE TABLE user(
    id int NOT NULL AUTO_INCREMENT,
    logon varchar(100) NOT NULL,
    name varchar(5000) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE blog(
    id int NOT NULL AUTO_INCREMENT,
    title varchar(500) NOT NULL,
    content varchar(5000) NOT NULL,
    writer int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES user(id)
)

CREATE TABLE review(
    id int NOT NULL AUTO_INCREMENT,
    comment varchar(1000) DEFAULT NULL,
    user_id int NOT NULL,
    blog_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (blog_id) REFERENCES blog(id)
)

