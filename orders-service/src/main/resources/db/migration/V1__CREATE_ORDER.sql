CREATE TABLE orders(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    product_id bigint(20) NOT NULL,
    quantity int(11) NOT NULL,
    status ENUM('PENDING','CONFIRMED','CANCELED','COMPLETED') NOT NULL DEFAULT 'PENDING',
    PRIMARY KEY (id)
);
