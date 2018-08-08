create table orders(
       id integer primary key,
       customerid references customer(id),
       foundtime timestamp not null,
       shopaddressid references shopaddress(id),
       state varchar(64) not null

)

create table cellphoneorders(
        ordersid references orders(id) on delete cascade,
        manageid references manage(id),
        amount integer not null
)


select * from orders where current_timestamp - foundtime >=interval '20' minute;
delete from orders where state='Canceled' and current_timestamp - foundtime >=interval '1' minute;


