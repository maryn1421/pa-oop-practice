
ALTER TABLE IF EXISTS ONLY public.users DROP CONSTRAINT IF EXISTS pk_users_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.orders DROP CONSTRAINT IF EXISTS orders_id CASCADE;




DROP TABLE IF EXISTS public.users;
CREATE TABLE users (
                       id serial NOT NULL,
                       email text,
                       username text,
                       name text,
                       zip_code text,
                       city text,
                       address text,
                       password text,
                       registration_date timestamp default current_timestamp
);


DROP TABLE IF EXISTS public.orders;
CREATE TABLE orders (
                     id serial NOT NULL,
                     user_id integer,
                     items text,
                     date timestamp default  current_timestamp
);

ALTER TABLE ONLY users
    ADD CONSTRAINT pk_users_id PRIMARY KEY (id);

ALTER TABLE ONLY orders
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
