insert into locations
    (id, name)
values
    (1, 'Hyderabad'),
    (2, 'Coimbatore') ,
    (3, 'Mumbai') ,
    (4, 'Chennai') ,
    (5, 'Pune') ,
    (6, 'Bangalore'),
    (7, 'Delhi')  ,
    (8, 'Kochin');

insert into films
    (id, duration, name, description)
values
    (1, 130, 'Zindagi Na mileage Dobara', 'Friends Kabir, Imran and Arjun take a vacation in Spain before Kabir''s marriage. The trip turns into an opportunity to mend fences, heal wounds, fall in love with life and combat their worst fears.'),
    (2, 140, 'Three Idiots', 'In college, Farhan and Raju form a great bond with Rancho due to his refreshing outlook. Years later, a bet gives them a chance to look for their long-lost friend whose existence seems rather elusive.'),
    (3, 100, 'Dear Zindagi', 'After a series of career and relationship downturns, Kaira begins suffering from insomnia. She contacts Dr Jehangir Khan, a psychologist, who uses unconventional methods to treat her.'),
    (4, 90, 'The Meg', 'When the members of an underwater research facility are under threat owing to a 75-foot prehistoric shark, Jonas Taylor, a deep-sea diver, is hired to save them.'),
    (5, 100, 'Shutter Island', 'Teddy Daniels and Chuck Aule, two US marshals, are sent to an asylum on a remote island in order to investigate the disappearance of a patient, where Teddy uncovers a shocking truth about the place.'),
    (6, 180, 'The Ghost Rider', 'Stunt motorcyclist Johnny Blaze decides to give up his soul to become the Ghost Rider and fight against Blackheart, the son of Mephistopheles, the devil himself.'),
    (7, 90, 'Gabbar is back', 'The city''s administration wrongs Aditya, a commoner. To avenge his tragedy, he disguises himself as a vigilante, Gabbar, and teams up with honest government officers to expose the corrupt.'),
    (8, 80, 'Two states', 'Coming from two very different cultural backgrounds, Krish and Ananya try to convince their parents to bless their relationship before they get married.'),
    (9, 180, 'The Big Bull', 'The Big Bull is a 2021 Indian Hindi-language crime drama film directed and co-written by Kookie Gulati and produced by Ajay Devgn, Anand Pandit, Vikrant Sharma and Kumar Mangat Pathak'),
    (10, 120, 'Chak De! India', 'Kabir Khan, a former hockey star, is tainted as someone who betrayed his country. However, he begins coaching the Indian women''s national hockey team to prove his loyalty to the nation.');



insert into screenings
    (id, name, location_id)
values
    (1, 'KG Cinemas', 2),
    (2, 'Karpagam Cinemas', 2),
    (3, 'Prozone Films', 2),
    (4, 'PVR Market City', 5),
    (5, 'City Pride Royal', 5),
    (6, 'Prasads Imax', 1),
    (7, 'Sterling', 3),
    (8, 'NCR Mall', 7);

insert into rooms
    (id, name, no_of_seats, screening_id)
values
    (1, 'KG Screen 1', 240, 1),
    (2, 'Karpagam Screen 2', 250, 2),
    (3, 'Prozone Screen 3', 250, 3),
    (4, 'Prozone Screen 4', 300, 3),
    (5, 'PVR Market City Screen 5', 250, 4),
    (6, 'PVR Market City Screen 6', 250, 4),
    (7, 'City Pride Screen 6', 300, 5),
    (8, 'Prasads Imax Screen 1', 390, 6),
    (9, 'Sterling Cineplex Screen 2', 200, 7),
    (10, 'Sterling Cineplex Screen 1', 100, 7);

insert into show_details
    (id, start_time, room_id, film_id)
values
    (1, '2021-01-02 09:00:00', 1, 1),
    (2, '2021-02-01 10:00:00', 2, 2),
    (3, '2021-01-03 12:00:00', 3, 3),
    (4, '2021-01-03 01:00:00', 4, 3),
    (5, '2021-01-03 03:00:00', 4, 3),
    (6, '2021-01-02 12:00:00', 1, 1),
    (7, '2021-01-02 12:00:00', 2, 2),
    (8, '2021-01-04 13:30:00', 10, 10),
    (9, '2021-01-04 16:00:00', 10, 9),
    (10, '2021-01-05 12:00:00', 7, 8);
