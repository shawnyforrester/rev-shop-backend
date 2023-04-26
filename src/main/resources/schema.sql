create table if not exists products (
id integer AUTO_INCREMENT,
category VARCHAR(255),
type VARCHAR(255),
brand VARCHAR(255),
size VARCHAR(255),
quantity integer,
review VARCHAR(255),
PRIMARY KEY(id)
);
