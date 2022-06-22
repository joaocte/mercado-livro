CREATE TABLE book (
  id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) NOT NULL,
  price decimal(10,2) NOT NULL,
  status varchar(255) NOT NULL,
  customer_id bigint not null,
  FOREIGN KEY (customer_id) references customer(id)
)