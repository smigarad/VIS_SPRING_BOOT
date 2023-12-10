CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    postal_code INT NOT NULL
);

CREATE TABLE manufacturer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    total_price FLOAT(10, 2) NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    gender INT NOT NULL,
    price FLOAT(10, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    description VARCHAR(255),
    manufacturer_id INT,
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id)
);

CREATE TABLE product_category (
    product_id INT,
    category_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE product_size (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    size VARCHAR(20),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE product_cart (
    product_id INT,
    cart_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (cart_id) REFERENCES cart(id),
    PRIMARY KEY (product_id, cart_id)
);

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role INT NOT NULL,
    address_id INT,
    cart_id INT,
    FOREIGN KEY (address_id) REFERENCES address(id),
    FOREIGN KEY (cart_id) REFERENCES cart(id)
);

CREATE TABLE order_entity(
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_of_order DATE NOT NULL,
    status INT NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE payment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount FLOAT(10, 2) NOT NULL,
    type INT NOT NULL,
    status INT NOT NULL,
    date_of_payment DATE NOT NULL,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES order_entity(id)
);

CREATE TABLE shipment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status INT NOT NULL,
    date_of_shipment DATE NOT NULL,
    order_id INT,
    address_id INT,
    FOREIGN KEY (order_id) REFERENCES order_entity(id),
    FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE order_product (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES order_entity(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE review (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    date_of_review DATE NOT NULL,
    rating INT NOT NULL,
    product_id INT,
    user_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);
