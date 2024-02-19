create database shop
    with owner postgres;

comment on database shop is 'База данных магазина';

--создание таблицы
create table if not exists product
(
    id          serial primary key,
    description text,
    price       float check ( price > 0 ),
    quantity    integer check ( quantity > 0 )


);
comment on table product is 'Артикул, наименование и цена товара';

create table if not exists person
(
    id         serial primary key,
    first_name varchar(20),
    last_name  varchar(20)
);
comment on table person is 'Данные покупателя';


create table if not exists orders
(

    orders_id_product integer references product (id),
    orders_id_person  integer references person (id),
    date              date,
    quantity          int2

);
comment on table orders is 'Совершенные покупки';

--заполнение таблицы product
insert into product (description, price, quantity)
VALUES ('Макароны', 123.00, 60),
       ('Сахар', 150.00, 100),
       ('Мука', 190.00, 15),
       ('Шоколад', 68.00, 40),
       ('Колбаса варенная', 220.00, 14),
       ('Печение', 96.00, 13),
       ('Семечки 250 гр.', 165.00, 20),
       ('Кефир 0.5 л.', 96.00, 25),
       ('Молоко 0.5 л.', 62.00, 18),
       ('Сметана 250 гр.', 46.00, 21);


-- заполнение таблицы person
insert into person (first_name, last_name)
VALUES ('Иван', 'Смирнов'),
       ('Владимир', 'Сидоров'),
       ('Роман', 'Половинкин'),
       ('Илья', 'Семенов'),
       ('Николай', 'Цибук'),
       ('Нина', 'Полещук'),
       ('Мария', 'Датцик'),
       ('Айзат', 'Галиев'),
       ('Сергей', 'Верещак'),
       ('Рустам', 'Халитов');

--заполниние order связанной внешним ключом с person и product
insert into orders (orders_id_product, orders_id_person, date, quantity)
VALUES (1, 3, CURRENT_DATE, 2),
       (2, 9, CURRENT_DATE, 3),
       (3, 7, CURRENT_DATE, 1),
       (4, 1, CURRENT_DATE, 3),
       (5, 2, CURRENT_DATE, 8),
       (6, 4, CURRENT_DATE, 4),
       (7, 5, CURRENT_DATE, 7),
       (8, 6, CURRENT_DATE, 2),
       (9, 10, CURRENT_DATE, 3),
       (10, 8, CURRENT_DATE, 6);

