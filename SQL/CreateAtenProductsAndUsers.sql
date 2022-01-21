USE
MASTER;
GO

DROP
DATABASE IF EXISTS ATEN;
GO

CREATE
DATABASE ATEN
GO

USE ATEN;
GO

INSERT INTO product(name, description, price, product_id)
VALUES ('Valheim', 'sandbox stuff', 22.99, 1),
('Teamfight Tactics', 'Auto chess', 1, 2),
('Rocket League', 'Best game', 2000.99, 3),
('CS-GO', 'FPS', 300.10, 4),
('Age of Empire', 'RTS stuff', 20, 5),
('Heroes of Might and Magic 3', 'Cool gem', 403.23, 6),
('Jumpy Birb', 'hamp', 1337, 7),
('RollerCoaster Tycoon', 'Coaster stuff', 322, 8)
;

INSERT INTO game(genre, age_limit, product_id)
VALUES ('ADVENTURE', 18, 1),
('STRATEGY', 8, 2),
('RACING', 6, 3),
('ACTION', 8, 4),
('STRATEGY', 18, 5),
('STRATEGY', 30, 6),
('KIDS', 30, 7),
('KIDS', 4, 8)
;

INSERT INTO product(name, description, price, product_id)
VALUES ('GameCube', 'is cube', 13.3, 10),
('Sega master system', 'boomer console', 26.49, 11),
('Playstation5', 'Zoomer console, Rare', 40050.43, 12),
('Hampsole', 'Exclusive for only Jumpy birb', 312231213312.23, 13)
;

INSERT INTO console(brand, model, product_id)
VALUES ('NINTENDO', '3', 10),
('SEGA', '6', 11),
('SONY', '3', 12),
('HAMPSOLE', '1', 13)
;