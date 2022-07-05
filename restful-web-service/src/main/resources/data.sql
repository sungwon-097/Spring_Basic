insert into user values(90001, sysdate(), 'User1', 'test1', '772139-1239231');
insert into user values(90002, sysdate(), 'User2', 'test2', '982139-1239231');
insert into user values(90003, sysdate(), 'User3', 'test3', '002129-1239231');

-- id 값이 자동생성(@GeneratedValue) 되기 때문에 처음 id 값을 {1,2,3} 으로 생성 하면 정합성 오류가 생길 수 있음