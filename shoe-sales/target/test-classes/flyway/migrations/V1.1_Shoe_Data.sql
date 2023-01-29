-- Customers
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES('JONES_SCROOGE', 'Scrooge', 'Jones', '647.399.2610');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES('BUTTERSNAPZ_GHEE', 'Ghee', 'Buttersnapz', '219.355.6407');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES('GUSCATERO_PINKY', 'Pinky', 'Guscatero', '766.388.3663');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES('RUSH_MELLOW', 'Mellow', 'Rush', '635,968.2611');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES('HOLESTEIN_DONUT', 'Donut', 'Holestein', NULL);
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES('DEVOLA_JOE', 'Joe', 'Devola', '766.958.3995');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES('PENNYPACKER_YASMINE', 'Yasmine', 'Pennypacker', '133.846.2775');

-- NIKE
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Air Force 1', 'Men', 110.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Air Jordan 1 Retro High', 'Men', 180.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Blazer Mid 77', 'Kids', 85.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Court Borough Mid 2', 'Men', 70.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Court Legacy Lift', 'Women', 190.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Air Jordan 1 Elevate Low SE', 'Men', 79.97);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Air Vapormax 2021 FK', 'Men', 168.98);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Air Max 270', 'Women', 160.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('NIKE', 'Dunk Low SE', 'Kids', 65.00);


-- ADIDAS
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('ADIDAS', 'Ultraboost 22 COLD.RDY 2.0', 'Men', 168.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('ADIDAS', 'Adistar', 'Men', 65.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('ADIDAS', 'Vulc Raid3r Skatboarding', 'Kids', 48.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('ADIDAS', 'NMD_R1', 'Women', 112.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('ADIDAS', 'Kaptir 2.0', 'Men', 77.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('ADIDAS', 'Adizero Boston 11', 'Men', 80.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('ADIDAS', 'Solarglide 5', 'Women', 65.00);

-- CONVERSE
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('CONVERSE', 'All Star Classic', 'Men', 60.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('CONVERSE', 'Chuck 70 Vintage Canvas', 'Men', 90.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('CONVERSE', 'Cons Louie Lopez Pro Mono', 'Women', 80.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('CONVERSE', 'DRKSHDW TURBODRK Chuck 70', 'Men', 170.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('CONVERSE', 'All Star Classic', 'Kids', 55.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('CONVERSE', 'Chuck 70 AT-CX', 'Men', 110.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('CONVERSE', 'All Star Woven Twill', 'Women', 65.00);

-- VANS
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('VANS', 'Canvas Old Skool', 'Men', 70.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('VANS', 'Checkerboard Slip-On', 'Women', 65.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('VANS', 'Sk8-Hi', 'Men', 80.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('VANS', 'Classic Slip-On Stackform', 'Kids', 75.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('VANS', 'UltraRange EXO', 'Men', 100.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('VANS', 'Era', 'Men', 60.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('VANS', 'Suede Canvas Old Skool V', 'Men', 75.00);

-- TIMBERLAND
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('TIMBERLAND', 'Premium 6-Inch Waterproof', 'Men', 210.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('TIMBERLAND', 'Stussy x Waterproof World Hiker', 'Men', 320.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('TIMBERLAND', 'Redwood Falls Waterproof Moc-Toe', 'Men', 145.00);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('TIMBERLAND', 'White Ledge Mid Waterproof Hiking', 'Men', 99.99);
INSERT INTO brands (brand_id, model_type, gender, base_price) VALUES('TIMBERLAND', '3-Eye Lug Handswens', 'Men', 150.00);

-- Colors
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('EXT_ONYX_BLACK', 'Black', 80.00, 1);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('EXT_NAVY_BLUE', 'Blue', 80.00, 1);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('EXT_BILLET_SILVER', 'Billet Silver', 80.00, 1);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('EXT_VELVET_RED', 'Velvet Red', 80.00, 1);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('EXT_WALNUT_BROWN', 'Walnut Brown', 80.00, 1);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('INT_STING_GRAY', 'String Gray', 50.00, 1);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('EXT_BRIGHT_WHITE', 'Bright White', 80.00, 0);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('INT_SLATE_BLUE', 'Slate Blue', 90.00, 0);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('INT_SANGRIA', 'Sangria', 100.00, 0);
INSERT INTO colors (color_id, color, price, is_exterior) VALUES('INT_CRYSTAL_BLACK', 'Crystal Black', 90.00, 0);

-- Sizes
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('211_NIKE', '8 sizes', 0.00, 'yes');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('125_NIKE', '7 sizes', 0.00, 'yes');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('45_ADIDAS', '6 sizes', 0.00, 'no');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('29_ADIDAS', '5 sizes', 0.00, 'yes');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('95_CONVERSE', '4 sizes', 0.00, 'no');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('225_CONVERSE', '5 sizes', 0.00, 'yes');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('235_TIMBERLAND', '7 sizes', 0.00, 'no');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('78_TIMBERLAND', '11 sizes', 0.00, 'no');
INSERT INTO sizes (size_id, size_size, price, in_stock) VALUES('35_VANS', '13 sizes', 0.00, 'yes');