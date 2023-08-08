create table practice_board(
  board_no int not null,
  title varchar(255) not null,
  content text null,
  writer int not null,
  password varchar(100) null,
  view_count int default 0,
  created_date datetime default now(),
  category int not null
);

alter table practice_board
  add constraint primary key (board_no),
  modify column board_no int not null auto_increment;
  
create table practice_member(
  member_no int not null,
  name varchar(20) not null,
  email varchar(50) not null,
  password varchar(100) not null,
  gender char(1) not null,
  created_date date default (current_date())
);

alter table practice_member
  add constraint primary key(member_no),
  modify column member_no int not null auto_increment;
  
alter table practice_member
  add constraint practice_member_uk unique (email);

  
  -- 게시판 작성자에 대한 외부키 설정
 alter table practice_board
  add constraint practice_board_fk foreign key (writer) references practice_member (member_no);
  