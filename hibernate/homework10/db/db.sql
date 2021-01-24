CREATE TABLE IF NOT EXISTS products (
                                        id   int PRIMARY KEY,
                                        name VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS customers (
                                         id   int  PRIMARY KEY,
                                         name VARCHAR(50),
                                         address VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS orders (
                                      id   int  PRIMARY KEY,
                                      customer_id INTEGER not null,
                                      totalAmount  FLOAT  not null,
                                      totalQuantity FLOAT  not null,
                                      date TIMESTAMP not null,
                                      CONSTRAINT customer_id FOREIGN KEY (customer_id) REFERENCES customers (id)
);

CREATE TABLE IF NOT EXISTS order_rows (
                                          id   int  PRIMARY KEY,
                                          product_id INTEGER not null,
                                          order_id integer not null,
                                          quantity  FLOAT  not null,
                                          price FLOAT  not null,
                                          amount  FLOAT  not null,
                                          CONSTRAINT product_id FOREIGN KEY (product_id) REFERENCES products (id),
                                          CONSTRAINT order_id FOREIGN KEY (order_id) REFERENCES orders (id)
);
