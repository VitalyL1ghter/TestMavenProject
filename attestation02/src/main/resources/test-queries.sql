\connect shop
--чтение из таблиц
SELECT *
FROM person;

SELECT *
FROM product;

SELECT *
FROM orders;

-- Сортировка по цене
SELECT description, price
FROM product
ORDER BY price;

-- сортировка по купленому количеству товаров
SELECT orders_id_person, orders_id_product, quantity
FROM orders
ORDER BY quantity;

-- сумма покупок
SELECT p.first_name, p.last_name, pr.price * o.quantity AS сумма
FROM person p
         INNER JOIN orders o on p.id = o.orders_id_person
         INNER JOIN product pr on o.orders_id_product = pr.id;

--изменение полей таблицы

update person
set first_name ='Лена',
    last_name='Пулкова'
where id = 6;

update product
set price = 300
where id = 2;
--удаление из таблицы
DELETE
from orders
where orders_id_person = 3;

DELETE
from person
where person.id = 3;

