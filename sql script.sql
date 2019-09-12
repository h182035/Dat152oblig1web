SET search_path = store, public;
drop table if exists product cascade;
create table product(
	pno serial primary key,
	pname varchar,
	priceInEuro decimal,
	imagefile varchar);

drop table if exists description;
create table description(
	pno int references product(pno),
	langCode varchar,
	text varchar,
	primary key (pno, langCode));
	
insert into product(pname, priceInEuro, imagefile)
values('pepsi', 1.5, 'pepsi.png'), ('cola', 1, 'cola.png'), ('Urge', 2, 'urge.png');
				 
insert into description(pno, langCode, text)
values(1, 'no', 'dette er pepsi'), (1, 'en', 'this is pepsi'), (1, 'fr', 'dette er pepsi fransk'),
	(2, 'no', 'dette er cola'), (2, 'en', 'this is cola'), (2, 'fr', 'dette er cola fransk'),
	(3, 'no', 'dette er urge '), (3, 'en', 'this is urge'), (3, 'fr', 'dette er urge fransk')