DROP TABLE IF EXISTS public.category CASCADE;
DROP TABLE IF EXISTS public.supplier CASCADE;
DROP TABLE IF EXISTS public.product CASCADE;
DROP TABLE IF EXISTS public.cart CASCADE;
DROP TABLE IF EXISTS public.product_in_cart CASCADE;
DROP TABLE IF EXISTS public.customer CASCADE;
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
    id          serial  NOT NULL PRIMARY KEY,
    name        varchar NOT NULL,
    description varchar,
    price       decimal,
    currency    varchar NOT NULL,
    category_id integer NOT NULL,
    supplier_id integer NOT NULL
);

CREATE TABLE public.cart
(
    id      serial NOT NULL PRIMARY KEY,
    user_id integer,
    payed   bool   NOT NULL
);

CREATE TABLE public.product_in_cart
(
    id         serial  NOT NULL PRIMARY KEY,
    cart_id    integer NOT NULL,
    product_id integer NOT NULL
);

CREATE TABLE public.customer
(
    id       serial  NOT NULL PRIMARY KEY,
    name     varchar NOT NULL,
    email    varchar NOT NULL,
    password varchar NOT NULL,
    address  varchar,
    city     varchar,
    state    varchar,
    zip_code varchar
);

CREATE TABLE public.order_history
(
    id            serial    NOT NULL PRIMARY KEY,
    user_id       integer,
    order_history varchar   NOT NULL,
    order_date    timestamp NOT NULL,
    order_status  varchar   NOT NULL
);

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES public.category (id),
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES public.supplier (id);

ALTER TABLE ONLY public.product_in_cart
    ADD CONSTRAINT fk_cart_id FOREIGN KEY (cart_id) REFERENCES public.cart (id),
    ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES public.product (id);

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.customer (id);

ALTER TABLE ONLY order_history
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.customer (id);

INSERT INTO supplier (name)
VALUES ('Leioa'),
       ('1Phone'),
       ('Samsong'),
       ('Game Station'),
       ('Bintendo'),
       ('ChuWi'),
       ('Fujigama');

INSERT INTO category (name)
VALUES ('Tablet'),
       ('Console'),
       ('Cell Phone'),
       ('Smart Watch'),
       ('Computer'),
       ('Camera'),
       ('Television');

INSERT INTO product (name, price, currency, description, category_id, supplier_id)
VALUES ('ChuWi HeroBook Por+', 81232, 'HUF',
        'CHUWI leg??jabb 13,3 h??velykes laptop HeroBook Pro + 3200 * 1800 k??perny?? Intel J3455 processzor Win10 OS 8 GB RAM + 128 GB ROM Super PC',
        5, 6),
       ('1Phone Smart Watch', 580, 'HUF',
        'Az ??j f??rfiak ??s n??k okos??ra Android IOS okos??ra Elektronikus intelligens ??ra Fitness Tracker Szilikonsz??j Okos??ra ??ra',
        4, 1),
       ('Samsong Smart Watch', 3769, 'HUF',
        'Forr?? elad??s?? ??j term??k Q18S intelligens kar??ra, kompatibilis a Samsung, a Xiaomi Huaiwei, az IPHONE k??sz??l??kkel. Android, iOS okostelefonok iPhone',
        4, 3),
       ('1Phone Fit Smart Watch', 1719, 'HUF',
        'Sz??nes k??perny?? intelligens kark??t????ra 115 Plusz v??rnyom??sm??r?? pulzusm??r?? intelligens karszalag', 4, 2),
       ('Samsong Tablet', 41221, 'HUF',
        '2022 Netbook PC Tablets Support NETFLIX!!! Newest Upgrade RAM 12G+ROM 1024GB+ 10Core WiFi Tablet PC Android 12.0 Arge 2560*1600 IPS Screen Dual SIM Dual Camera Rear 13.0 MP IPS Tablet Call Phone Tablet Gift with Earphone+256GB memory card 11.6inch Tablet with Keyboard',
        1, 3),
       ('Leioa Tablet', 135385, 'HUF',
        'Android Tablet 10 inch,Tablet with Keyboard Mouse 3GB RAM 32GB ROM/128GB, Android 9.0 Pie, Dual SIM 4G, 8MP Camera, 8000mAh, Quad Core, OTG, GPS (Gray)',
        1, 1),
       ('1Phone Tablet', 17916, 'HUF',
        '2021 Tablets Support NETFLIX!!! Tablet Newest Upgrade RAM 12G+ROM 640GB+ 12 Core WiFi Tablet PC Android 12.0 Arge 2560*1600 IPS Screen Dual SIM Dual Camera Rear 13.0 MP IPS Tablet Call Phone Tablet Tablet-PC Tablette 9.6-inch tablet computer',
        1, 2),
       ('Game Station PXP', 5270, 'HUF',
        'Legjobb min??s??g?? PXP 3 k??zi j??t??kkonzol 150 + j??t??kok aj??nd??k j??t??kok gyerekeknek', 2, 4),
       ('Bintendo Retro Console', 5631, 'HUF',
        '2020 Super Classic Retro SUPER MINISNES Mini Be??p??tett 620 Mini Nostalgic Video Game Console', 2, 5),
       ('Game Station PS1 Retro Console', 4935, 'HUF',
        'Klasszikus 8 bites j??t??kkonzol PS1 Mini Home 620 akci??j??t??k-rajong?? sz??rakoztat?? rendszerhez Retro kett??s csatakonzol',
        2, 4),
       ('Bintendo Retro Hand Console', 2556, 'HUF',
        '??j st??lus?? retro j??t??kkonzol Be??p??tett 268/400/800 j??t??kok Retro j??t??kkonzol Pocket k??zi videoj??t??k-konzol 2.0 / 3.0 LCD 8 bites mini hordozhat?? j??t??klej??tsz??',
        2, 5),
       ('Bintendo Switch', 8709, 'HUF',
        '2020 ??j friss??t??s?? 4.3 / 5.1 h??velykes k??zi j??t??klej??tsz?? 8 GB-os ROM PSP konzolos k??zi j??t??kg??p Be??p??tett 20000+ j??t??kkal PK Bintendo Switch X7 / X7Plus Opci??k',
        2, 5),
       ('1Phone i13 Pro Max', 25000, 'HUF',
        'Unlocked Cell Phones I13pro Max Cell Phones 4G 5G Dual SIM Cards Support T Card (12GB RAM+512GB ROM) Android 10.0 Smartphone',
        3, 2),
       ('Samsong S30', 31854, 'HUF',
        'In 2021, a newly launched 6.7-inch 3K HD screen 16+512GB fingerprint smartphone (champagne gold, psychedelic blue, dark night green)',
        3, 3),
       ('Leioa P60 Pro', 36198, 'HUF',
        '2021 Fashion New Handy Smartphone P60 Pro 5G with 16+768GB Large Memory 48+64MP HD camara Dual Sim Cards Bluetooth Wifi 6000mA/h battery Mobile Phone Android 10.0 Ten Core',
        3, 1),
       ('Samsong S21 U+', 33823, 'HUF',
        '2021 Brand New S21+ Ultra 5G 6.1Inch HD Screen 16+512GB Unlocked Global Version Smartphone (Black/Blue/Green)',
        3, 3),
       ('Samsong Note30 Plus', 15600, 'HUF',
        'New Note30 Plus Smartphone the thinest 6.1 Inches Large Memory 12GB+512GB Android 10.0 Face Unlock Dual Card Phone Supports T-card Smartphone',
        3, 3),
       ('Game Station 4 pro', 45354, 'HUF',
        'Tedd pr??b??ra magad a v??ltozatos j??t??kokban! A Game Station 4 Pro TV-re k??thet?? j??t??kg??ppel egyszerre ketten is j??tszhattok bar??toddal, ??gy a kiv??lasztott j??t??kban megk??zdhettek egym??ssal.',
        2, 4),
       ('Fujigama TPT 16X Pro', 8628, 'HUF',
        'Digital Camera 16X Focus Zoom Design Camera1280x720 Supported 32GB Card Portable Digital Camera for Travel Photo Taking',
        6, 7),
       ('Fujigama ZMP 24X', 10878, 'HUF',
        'Full HD Digital Camera, 33MP Digital DSLR Camera 0.5X Auto Focus Wide Angle Lens Kit, Rechargeable 24X Optical Zoom Multifunctional Portable Camera, Best Gift For Photography Lovers',
        6, 7),
       ('Samsong UHD Televison 65`', 72854, 'HUF',
        'Mer??lj el a k??pben a sz??lesebb sz??nsk??l??val! A Crystal Display biztos??tja az optimaliz??lt sz??nkifejez??st, ??gy minden r??szletet l??thatsz.',
        7, 3),
       ('Samsong FULL HD Televison 45`', 35624, 'HUF',
        'Keskeny ??s eleg??ns kialak??t??s, amely a legtiszt??bb k??pet t??rja el??d. Minden elem??ben, sz??g??ben minimalista kialak??t??s??, keret n??lk??li, amely ??j m??rc??t ??ll??t fel. Mag??val ragad?? l??tv??ny t??rul el??d.',
        7, 3);

INSERT INTO public.customer (name, email, password)
VALUES ('admin', 'admin@test.com', '11111')