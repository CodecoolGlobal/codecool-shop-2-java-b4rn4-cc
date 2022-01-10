DROP TABLE IF EXISTS public.category CASCADE;
DROP TABLE IF EXISTS public.supplier CASCADE;
DROP TABLE IF EXISTS public.product CASCADE;
DROP TABLE IF EXISTS public.cart CASCADE;
DROP TABLE IF EXISTS public.product_in_cart CASCADE;
DROP TABLE IF EXISTS public.user CASCADE;
DROP TABLE IF EXISTS public.order_history CASCADE;

CREATE TABLE public.category
(
    id   serial  NOT NULL PRIMARY KEY,
    name varchar NOT NULL
);

CREATE TABLE public.supplier
(
    id   serial  NOT NULL PRIMARY KEY,
    name varchar NOT NULL
);

CREATE TABLE public.product
(
    id   serial  NOT NULL PRIMARY KEY,
    name varchar NOT NULL,
    description varchar,
    price decimal,
    currency varchar NOT NULL,
    category_id integer NOT NULL,
    supplier_id integer NOT NULL
);

CREATE TABLE public.cart
(
    id   serial  NOT NULL PRIMARY KEY,
    user_id integer,
    payed bool NOT NULL
);

CREATE TABLE public.product_in_cart
(
    id serial NOT NULL PRIMARY KEY,
    cart_id integer NOT NULL,
    product_id integer NOT NULL
);

CREATE TABLE public.user
(
    id   serial  NOT NULL PRIMARY KEY,
    name varchar NOT NULL,
    email varchar NOT NULL,
    password varchar NOT NULL,
    address varchar,
    city varchar,
    state varchar,
    zip_code integer
);

CREATE TABLE public.order_history
(
    id   serial  NOT NULL PRIMARY KEY,
    user_id integer,
    order_history varchar NOT NULL,
    order_date timestamp NOT NULL,
    order_status varchar NOT NULL
);

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES public.category(id),
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES public.supplier(id);

ALTER TABLE ONLY public.product_in_cart
    ADD CONSTRAINT fk_cart_id FOREIGN KEY (cart_id) REFERENCES public.cart(id),
    ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES public.product(id);

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.user(id);

ALTER TABLE ONLY order_history
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.user(id);

INSERT INTO supplier (name) VALUES ('Leioa'),
                                   ('1Phone'),
                                   ('Samsong'),
                                   ('Game Station'),
                                   ('Bintendo'),
                                   ('ChuWi'),
                                   ('Fujigama');

