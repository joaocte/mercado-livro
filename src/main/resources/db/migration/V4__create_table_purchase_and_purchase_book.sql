CREATE TABLE purchase(
	id bigint(20) auto_increment primary key,
    customer_id bigint(20) not null,
    nfe varchar(255),
    price DECIMAL(15,2) not null,
    created_at DATETIME not null,
    updated_at DATETIME not null,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE purchase_book(
	purchase_id bigint(20) not null,
	book_id bigint(20) not null,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    PRIMARY KEY (purchase_id, book_id)
);