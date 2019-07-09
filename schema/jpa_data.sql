# 表jpa自动创建
USE spring_boot;
create table if not exists spring_boot.team
(
    id          bigint auto_increment
        primary key,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null,
    name        varchar(255)                       null
)
    engine = MyISAM;

create table if not exists spring_boot.player
(
    id          bigint auto_increment
        primary key,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null,
    name        varchar(255)                       null,
    num         int                                null,
    position    varchar(255)                       null,
    team_id     bigint                             not null
)
    engine = MyISAM;

create index FKdvd6ljes11r44igawmpm1mc5s
    on spring_boot.player (team_id);


insert into team (id, name)
values (1, 'Barcelona');
insert into player (id, team_id, name, num, position)
values (1, 1, 'Lionel Messi', 10, 'Forward');
insert into player (id, team_id, name, num, position)
values (3, 1, 'Pique', 3, 'Defender');
insert into player (id, team_id, name, num, position)
values (2, 1, 'Andreas Inniesta', 8, 'Midfielder');
