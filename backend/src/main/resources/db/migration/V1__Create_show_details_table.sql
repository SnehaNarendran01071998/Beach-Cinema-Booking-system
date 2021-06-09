CREATE TABLE show_details (
    id int not null PRIMARY key,
    room_id int not null,
    start_time TIMESTAMP not null,
    CONSTRAINT fk_rooms FOREIGN KEY(room_id) REFERENCES rooms(id),
);