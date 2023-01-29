DROP TABLE IF EXISTS edition;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS sizes;
DROP TABLE IF EXISTS colors;
DROP TABLE IF EXISTS brands;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  customer_pk int unsigned NOT NULL AUTO_INCREMENT,
  customer_id varchar(40) NOT NULL,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  phone varchar(20),
  PRIMARY KEY (customer_pk)
);

CREATE TABLE brands (
  brand_pk int unsigned NOT NULL AUTO_INCREMENT,
  brand_id enum('NIKE', 'ADIDAS', 'CONVERSE', 'VANS', 'TIMBERLAND') NOT NULL,
  model_type varchar(60) NOT NULL,
  gender varchar(10) NOT NULL,
  base_price decimal(9, 2) NOT NULL,
  PRIMARY KEY (brand_pk),
  UNIQUE KEY (brand_id, model_type, gender)
);

CREATE TABLE colors (
  color_pk int unsigned NOT NULL AUTO_INCREMENT,
  color_id varchar(30) NOT NULL,
  color varchar(60) NOT NULL,
  price decimal(9, 2) NOT NULL,
  is_exterior boolean NOT NULL,
  PRIMARY KEY (color_pk),
  UNIQUE KEY (color_id)
);

CREATE TABLE sizes (
  size_pk int unsigned NOT NULL AUTO_INCREMENT,
  size_id varchar(30) NOT NULL, 
  size_size varchar(128) NOT NULL,
  price decimal(7, 2) NOT NULL,
  in_stock varchar(4) NOT NULL,
  PRIMARY KEY (size_pk),
  UNIQUE KEY (size_id)
);

CREATE TABLE orders (
  order_pk int unsigned NOT NULL AUTO_INCREMENT,
  customer_fk int unsigned NOT NULL,
  color_fk int unsigned NOT NULL,
  size_fk int unsigned NOT NULL,
  brand_fk int unsigned NOT NULL,
  price decimal(9, 2) NOT NULL,
  PRIMARY KEY (order_pk),
  FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE,
  FOREIGN KEY (color_fk) REFERENCES colors (color_pk) ON DELETE CASCADE,
  FOREIGN KEY (size_fk) REFERENCES sizes (size_pk) ON DELETE CASCADE,
  FOREIGN KEY (brand_fk) REFERENCES brands (brand_pk) ON DELETE CASCADE
);

CREATE TABLE edition (
  brand_fk int unsigned NOT NULL,
  order_fk int unsigned NOT NULL,
  FOREIGN KEY (brand_fk) REFERENCES brands (brand_pk) ON DELETE CASCADE,
  FOREIGN KEY (order_fk) REFERENCES orders (order_pk) ON DELETE CASCADE
);
