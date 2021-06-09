CREATE TABLE screenings (
    id int not null PRIMARY key,
    film_id int not null,
    location_id int not null,
    name VARCHAR not null,
    CONSTRAINT fk_films FOREIGN KEY(film_id) REFERENCES films(id),
    CONSTRAINT fk_locations FOREIGN KEY(location_id) REFERENCES [locations](id)
);