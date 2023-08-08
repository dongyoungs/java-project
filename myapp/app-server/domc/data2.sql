-- practice_member 테이블 예제 데이터
insert into practice_member(member_no, name, email, password, gender) 
  values(1, '철수', 'cjftn@test.com', sha1('1111'), 'M');
insert into practice_member(member_no, name, email, password, gender) 
  values(2, '영희', 'dudgml@test.com', sha1('1111'), 'W');
insert into practice_member(member_no, name, email, password, gender) 
  values(3, '길동', 'rlfehd@test.com', sha1('1111'), 'M');
insert into practice_member(member_no, name, email, password, gender) 
  values(4, '다리우스', 'ekfldntm@test.com', sha1('1111'), 'M');
insert into practice_member(member_no, name, email, password, gender) 
  values(5, '퀸', 'znls@test.com', sha1('1111'), 'W');
insert into practice_member(member_no, name, email, password, gender) 
  values(6, '럼블', 'fjaqmf@test.com', sha1('1111'), 'M');

-- practice_board 테이블 예제 데이터
insert into practice_board(board_no, title, content, writer, password, category)
  values(11, '제목1', '철수를 구하시오', 1, sha1('1111'), 1);
insert into practice_board(board_no, title, content, writer, password, category)
  values(12, '제목2', '내용', 1, sha1('1111'), 1);
insert into practice_board(board_no, title, content, writer, password, category)
  values(13, '제목3', '둘리', 3, sha1('1111'), 1);
insert into practice_board(board_no, title, content, writer, password, category)
  values(14, '제목4', '내용', 4, sha1('1111'), 1);
insert into practice_board(board_no, title, content, writer, password, category)
  values(15, '제목5', '내용', 5, sha1('1111'), 2);
insert into practice_board(board_no, title, content, writer, password, category)
  values(16, '제목6', '내용', 5,sha1('1111'), 2);
insert into practice_board(board_no, title, content, writer, password, category)
  values(17, '제목7', '내용', 6, sha1('1111'), 2);