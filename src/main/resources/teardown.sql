drop database baseball;
create database baseball;
use baseball;

create table stadium (
id int primary key auto_increment,
name varchar(250) not null,
created_at timestamp
) DEFAULT CHARACTER SET utf8mb4;

create table team (
id int primary key auto_increment,
stadium_id int,
name varchar(250) not null,
created_at timestamp,
FOREIGN KEY (stadium_id) REFERENCES stadium(id)
) DEFAULT CHARACTER SET utf8mb4;

create table player (
id int primary key auto_increment,
team_id int,
name varchar(250) not null,
position varchar(250) not null,
created_at timestamp,
FOREIGN KEY (team_id) REFERENCES team(id),
UNIQUE (team_id, position)
) DEFAULT CHARACTER SET utf8mb4;

create table out_player (
id int primary key auto_increment,
player_id int,
reason varchar(250) not null,
created_at timestamp,
FOREIGN KEY (player_id) REFERENCES player(id)
) DEFAULT CHARACTER SET utf8mb4;

insert into stadium(name, created_at) values('사직야구장', now());
insert into stadium(name, created_at) values('잠실야구장', now());
insert into stadium(name, created_at) values('라이온즈파크', now());

insert into team(stadium_id, name, created_at) values(1, '롯데', now());
insert into team(stadium_id, name, created_at) values(2, '두산', now());
insert into team(stadium_id, name, created_at) values(3, '삼성', now());

INSERT INTO player (team_id, name, position, created_at) VALUES(1, '손아섭', '1루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '이대호', '2루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '임병욱', '3루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '김재현', '투수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '윌슨즈', '포수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '김문호', '유격수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '윌린오', '좌익수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '전준우', '중견수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(1, '김용의', '우익수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '이원석', '1루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '김동엽', '2루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '김상수', '3루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '구자욱', '투수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '이학주', '포수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '박해민', '유격수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '강민호', '좌익수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '박경수', '중견수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(2, '조동찬', '우익수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '김재호', '1루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '오재일', '2루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '페르난', '3루수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '정수빈', '투수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '김재환', '포수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '김인태', '유격수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '오재원', '좌익수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '박건우', '중견수', NOW());
INSERT INTO player (team_id, name, position, created_at) VALUES(3, '호잉요', '우익수', NOW());

insert into out_player(player_id, reason, created_at) values(8, '도박', now());
update player set team_id = null where id = 8;