create table if not exists heatmap_entry
(
    id                           bigint      not null    auto_increment,
    product                      varchar(255) null,
    location_description         varchar(255) null,
    location_formatted_address   varchar(255) null,
    location_icon                varchar(255) null,
    location_google_place_id     varchar(255) null,
    geographic_coordinate        varchar(255) null,
    average_availability         varchar(255) null,
    latest_update                datetime,
    primary key (id)
);
