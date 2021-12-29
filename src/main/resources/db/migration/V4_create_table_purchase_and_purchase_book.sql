CREATE TABLE purchase (
                          id int auto_increment primary key,
                          customer_id int not null,
                          nfe varchar(255),
                          price DECIMAL(15, 2) not null,
                          created_at DATETIME not null,
                          FOREIGN KEY (customer_id) REFERENCES customer(id)
);
CREATE TABLE purchase_poke (

        purchase_id int not null,
        book_id int not null,
        FOREIGN KEY(purchase_id) REFERENCES purchase(id),
        FOREIGN KEY(poke_id) REFERENCES poke(id),
        PRIMARY KEY (purchase_id, poke_id)
);
