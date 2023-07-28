create table myapp_menu(
  menu_name varchar(255) not null,
  price int not null,
  menu_category varchar(255) not null,
  menu_num int not null
);

alter table myapp_menu
  add constraint primary key(menu_name);