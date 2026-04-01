
DROP TABLE IF EXISTS warehouse;
CREATE TABLE `warehouse` (
    `id` bigint NOT NULL,
    `place_name` varchar(255) DEFAULT ''
);
ALTER TABLE `warehouse` CHANGE `id` `id` BIGINT NOT NULL AUTO_INCREMENT, add PRIMARY KEY (`id`);
insert into warehouse( place_name) values( 'Łódź');
insert into warehouse( place_name) values( 'Grudziąc');


ALTER TABLE users add own_pin varchar(6) DEFAULT '';
ALTER TABLE users add own_warehouse varchar(32) DEFAULT '';

insert into users( email, first_name, last_name, password, is_enabled, is_locked, role_name, own_warehouse) values('lodz@megapack.pl', 'operator', 'lodz', '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 1, 0, 'ROLE_USER', 'Łódź');
insert into users( email, first_name, last_name, password, is_enabled, is_locked, role_name, own_warehouse) values('grudziac@megapack.pl', 'operator', 'grudziąc', '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 1, 0, 'ROLE_USER', 'Grudziąc');


ALTER TABLE product_version add warehouse_place varchar(32) DEFAULT 'Łódź';
ALTER TABLE release_article add warehouse_place varchar(32) DEFAULT 'Łódź';
ALTER TABLE shipment add warehouse_place varchar(32) DEFAULT 'Łódź';
ALTER TABLE print_file add warehouse_place varchar(32) DEFAULT 'Łódź';


update product_version set warehouse_place = 'Lodz';
update release_article set warehouse_place = 'Lodz';
update shipment set warehouse_place = 'Lodz';
update print_file set warehouse_place = 'Lodz';
