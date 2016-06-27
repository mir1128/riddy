drop table if exists `reporting_data_collection_1`;
create table reporting_data_collection_1 (
    id             varchar(36) not null,
    filed1         varchar(36),
    filed2         varchar(36),
    filed3         varchar(36),
    filed4         varchar(36),
    filed5         varchar(36),
    filed6         varchar(36),
    filed7         varchar(36),
    filed8         varchar(36),
    filed9         varchar(36),
    filed10        varchar(36),
    reporting_time datetime    not null,
    reporting_from varchar(36) not null,
    constraint schedule_message_pk primary key (id)
)