# Portal

pre requisite

Cassandra has to be running on 9042



Db Scripts
CREATE KEYSPACE  search_int WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

create table search_int.product (
skuId text,
brand text,
price text,
color text,
size text,
primary key (skuId));

select * from search_int.product ;

insert into search_int.product (skuId,brand,price,size,color) values ('skuONE','brand1','10','small','black');
insert into search_int.product (skuId,brand,price,size,color) values ('sku2','brand2','10','medium','black');
insert into search_int.product (skuId,brand,price,size,color) values ('sku3','brand3','10','large','black');
insert into search_int.product (skuId,brand,price,size,color) values ('sku4','brand1','100','mediun','blue');

To Build
./gradlew clean build




Below link has post man Collection

https://www.getpostman.com/collections/cf66dcb09df64779fc0f
