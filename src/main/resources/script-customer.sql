CREATE SEQUENCE customer_seq START 1 INCREMENT 1;
CREATE TABLE customer (
    id BIGINT NOT NULL DEFAULT nextval('customer_seq'),
    name VARCHAR(100) NOT NULL,
    movil VARCHAR(10) NOT NULL,
    direction VARCHAR(150) NOT NULL,
    payment_type VARCHAR(50) NOT NULL,
    create_at TIMESTAMP NOT NULL,
    update_at TIMESTAMP NOT null,
CONSTRAINT pk_customer PRIMARY KEY (id)
);
ALTER SEQUENCE customer_seq OWNED BY customer.id;


insert into customer(id,name,movil,direction,payment_type,create_at,update_at) values (nextval('customer_seq'),'Aguascalientes','8127492716','San Nicolas','CASH',now(),now());