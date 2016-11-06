drop table if exists `reporting_data_collection_1`;
create table reporting_data_collection_1 (
    id             varchar(36) not null,
    field1         varchar(36),
    field2         varchar(36),
    field3         varchar(36),
    field4         varchar(36),
    field5         varchar(36),
    field6         varchar(36),
    field7         varchar(36),
    field8         varchar(36),
    field9         varchar(36),
    field10        varchar(36),
    reporting_time datetime    not null,
    reporting_from varchar(36) not null,
    constraint schedule_message_pk primary key (id)
)