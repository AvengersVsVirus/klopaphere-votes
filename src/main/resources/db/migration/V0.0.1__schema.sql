create table if not exists vote
(
    id              bigint      not null    auto_increment,
    product         varchar(255) null,
    location        varchar(255) null,
    availability    varchar(255) null,
    primary key (id)
);
