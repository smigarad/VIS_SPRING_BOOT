INSERT INTO manufacturer (name)
VALUES
    ('Reebok'),
    ('New Balance'),
    ('Under Armour'),
    ('Asics'),
    ('Fila'),
    ('Converse'),
    ('Vans'),
    ('Salomon'),
    ('Merrell'),
    ('Columbia');

INSERT INTO category (name)
VALUES
    ('Running'),
    ('Yoga'),
    ('Weightlifting'),
    ('Cycling'),
    ('Swimming'),
    ('Hiking'),
    ('Team Sports'),
    ('Outdoor'),
    ('Fitness Accessories');


INSERT INTO product (name, gender, price, stock_quantity, description, manufacturer_id)
VALUES
    ('Running Shoes', 0, 89.99, 50, 'High-performance running shoes', 1),
    ('Yoga Mat', 0, 29.99, 100, 'Premium yoga mat for comfort', 2),
    ('Weightlifting Gloves', 0, 19.99, 80, 'Durable gloves for weightlifting', 3),
    ('Cycling Helmet', 0, 49.99, 60, 'Safety-focused helmet for cyclists', 4),
    ('Swimming Goggles', 0, 14.99, 120, 'Anti-fog goggles for swimming', 5),
    ('Hiking Boots', 0, 109.99, 40, 'Waterproof boots for hiking', 6),
    ('Basketball', 0, 24.99, 70, 'Official size basketball', 7),
    ('Tent', 0, 199.99, 30, 'Spacious tent for outdoor adventures', 8),
    ('Fitness Tracker', 0, 79.99, 90, 'Activity tracker for fitness enthusiasts', 9),
    ('Resistance Bands', 0, 34.99, 110, 'Set of resistance bands for workouts', 10);

INSERT INTO product (name, gender, price, stock_quantity, description, manufacturer_id)
VALUES
    ('Men\'s Running Shoes', 1, 99.99, 50, 'Men\'s high-performance running shoes', 1),
    ('Women\'s Yoga Mat', 2, 34.99, 80, 'Premium yoga mat for women', 2),
    ('Men\'s Weightlifting Gloves', 1, 22.99, 70, 'Durable gloves for men', 3),
    ('Women\'s Cycling Helmet', 2, 54.99, 40, 'Safety-focused helmet for women cyclists', 4),
    ('Men\'s Swimming Shorts', 1, 19.99, 100, 'Comfortable swimming shorts for men', 5),
    ('Women\'s Hiking Boots', 2, 119.99, 35, 'Waterproof boots for women hikers', 6),
    ('Men\'s Basketball', 1, 29.99, 60, 'Official size basketball for men', 7),
    ('Women\'s Tent', 2, 219.99, 25, 'Spacious tent for women adventurers', 8),
    ('Men\'s Fitness Tracker', 1, 89.99, 80, 'Activity tracker for men', 9),
    ('Women\'s Resistance Bands', 2, 39.99, 90, 'Set of resistance bands for women', 10);

INSERT INTO product_size (product_id, size)
VALUES
    (1, 'US 7'),
    (1, 'US 8'),
    (1, 'US 9'),
    (1, 'US 10'),
    (1, 'US 11'),
    (2, 'One Size'),
    (3, 'Small'),
    (3, 'Medium'),
    (3, 'Large'),
    (4, 'Medium'),
    (4, 'Large');

INSERT INTO product_size (product_id, size)
VALUES
    (5, 'Small'),
    (5, 'Medium'),
    (5, 'Large'),
    (6, 'US 6'),
    (6, 'US 7'),
    (6, 'US 8'),
    (7, 'Official Size'),
    (8, '2-Person'),
    (9, 'One Size'),
    (10, 'Set of 3');
    
INSERT INTO product_category (product_id, category_id)
VALUES 
    (1, 1), -- Běžecké boty patří do kategorie Running
    (2, 2), -- Jóga matka patří do kategorie Yoga
    (3, 3), -- Závaží patří do kategorie Weightlifting
    (4, 4), -- Cyklistická helma patří do kategorie Cycling
    (5, 5), -- Plavecké brýle patří do kategorie Swimming
    (6, 6), -- Turistické boty patří do kategorie Hiking
    (7, 7), -- Basketbal patří do kategorie Team Sports
    (8, 8), -- Stan patří do kategorie Outdoor
    (9, 9), -- Fitness tracker patří do kategorie Fitness Accessories
    (10, 9); -- Sada odporových pásků patří do kategorie Fitness Accessories

INSERT INTO product_category (product_id, category_id)
VALUES 
    (11, 1), -- Pánské běžecké boty patří do kategorie Running
    (12, 2), -- Dámská jóga matka patří do kategorie Yoga
    (13, 3), -- Pánské závaží patří do kategorie Weightlifting
    (14, 4), -- Dámská cyklistická helma patří do kategorie Cycling
    (15, 5), -- Pánské plavecké kalhoty patří do kategorie Swimming
    (16, 6), -- Dámské turistické boty patří do kategorie Hiking
    (17, 7), -- Pánský basketbal patří do kategorie Team Sports
    (18, 8), -- Stan pro 3 osoby patří do kategorie Outdoor
    (19, 9), -- Dámský fitness tracker patří do kategorie Fitness Accessories
    (20, 9); -- Set odporových pásků pro začátečníky patří do kategorie Fitness Accessories

