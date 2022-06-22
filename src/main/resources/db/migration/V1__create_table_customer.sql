CREATE TABLE customer (
  id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email varchar(255) NOT NULL UNIQUE,
  name varchar(255) NOT NULL
)