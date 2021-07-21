DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  imgSrc VARCHAR(250) DEFAULT NULL,
  title VARCHAR(250) NOT NULL,
  price DECIMAL DEFAULT NULL,
  category VARCHAR(250) DEFAULT NULL
);

-- INSERT INTO billionaires (first_name, last_name, career) VALUES
--   ('Aliko', 'Dangote', 'Billionaire Industrialist'),
--   ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
--   ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');
