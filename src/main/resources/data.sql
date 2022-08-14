-- test data
-- roles
insert into roles ( name) values ('admin');
insert into roles ( name) values ( 'professor');
insert into roles ( name) values ( 'student');
-- topics
insert into topics ( name,description, expected_hours) values ( 'SQL', 'SQL is a relational database management system.', 20);
insert into topics ( name,description, expected_hours) values ('Java', 'Java is a programming language.', 30);
insert into topics (name,description, expected_hours) values ( 'SpringBoot','Framework for the JAVA language.', 40);
insert into topics ( name,description, expected_hours) values ( 'Postman','Restful API.', 20);
insert into topics ( name,description, expected_hours) values ( 'GIT','Working with GIT repositories.', 10);
-- -- -- education_levels
--
insert into education_levels ( name, abbreviation) values ( 'Bachelor of Science in Business Administration', 'B.S.B.A.');
insert into education_levels ( name, abbreviation) values ( 'Bachelor of Science in Education', 'B.S.Ed.');
insert into education_levels ( name, abbreviation) values ( 'Bachelor', 'Bc.');
insert into education_levels ( name, abbreviation) values ( 'Master of Business Administration', 'MBA');
insert into education_levels ( name, abbreviation) values ( 'Master of Education', 'M.Ed.');
insert into education_levels ( name, abbreviation) values ( 'Master of Science', 'M.S.');
insert into education_levels ( name, abbreviation) values ( 'Master ', 'M.');
insert into education_levels ( name, abbreviation) values ( 'Doctor of Education', 'D.P.C.');
insert into education_levels ( name, abbreviation) values ( 'Educational Specialist', 'Ed.S.');
insert into education_levels ( name, abbreviation) values ( 'High school ', 'H.S.');
-- -- -- tests
insert into tests ( name, description, deadline, possible_points) values ( 'SQL basics', 'INSERT/CREATE/SELECT', "2022-07-22", 5);
insert into tests ( name, description, deadline, possible_points) values ( 'SQL advanced', 'TRIGGERS & JOINS', "2022-07-25", 10);
insert into tests ( name, description, deadline, possible_points) values ('DB model', 'Create model for your project', "2022-07-28", 15);
insert into tests ( name, description, deadline, possible_points) values ( 'JAVA introduction', 'Classes and OOP', "2022-07-22", 10);
insert into tests ( name, description, deadline, possible_points) values ( 'JAVA classes', 'inheritance/abstract/interfaces', "2022-07-31", 15);
insert into tests ( name, description, deadline, possible_points) values ( 'SpringBoot #1', 'Simple test', "2022-07-22", 10);
insert into tests ( name, description, deadline, possible_points) values ( 'SpringBoot #2', 'Implement project model', "2022-08-05", 20);
insert into tests ( name, description, deadline, possible_points) values ( 'SpringBoot #3', 'Creating CRUD operations', "2022-08-08", 20);
-- --meetings
insert into meetings (meeting_begin, meeting_end, topic_id, name, location) values (  "2022-07-18 13:00", "2022-07-18 14:30", 1, "Introduction to bootcamp", "Online");
insert into meetings (meeting_begin, meeting_end, topic_id, name, location) values (  "2022-07-21 13:00", "2022-07-21 14:30", 1, "Intermidiate SQL", "Ured");
insert into meetings ( meeting_begin, meeting_end, topic_id, name, location) values (  "2022-07-25 13:00", "2022-07-25 14:30", 2, "JAVA", "Ured");
insert into meetings (  meeting_begin, meeting_end, topic_id, name, location) values ( "2022-08-01 13:00", "2022-08-01 14:30", 2, "Intermidiate SpringBoot", "Online");
insert into meetings (  meeting_begin, meeting_end, topic_id, name, location) values ( "2022-08-04 13:00", "2022-08-04 14:30", 3, "GIT", "Ured");
insert into meetings (  meeting_begin, meeting_end, topic_id, name, location) values (  "2022-08-08 13:00", "2022-08-08 14:30", 3, "Postman", "Online");
-- -- user profiles
insert into user_profiles ( birth_date, faculty, mobile, name, residence, surname, education_level_id) values ( '2000-02-28', 'Faculty of Organization and Informatics', '+385997585344', 'Luka', 'Ivanić-Grad', 'Svetlečić', 3);
insert into user_profiles ( birth_date, faculty, mobile, name, residence, surname, education_level_id) values ( '1995-07-18', 'Veleučilište  Velika Gorica', '+385923712223', 'Ivica', 'Velika Gorica', 'Ivić', 4);
insert into user_profiles ( birth_date, faculty, mobile, name, residence, surname, education_level_id) values ( '2001-12-12', 'FER', '+385997523456', 'Miroslav', 'Zagreb', 'Ilić', 7);
insert into user_profiles ( birth_date, faculty, mobile, name, residence, surname, education_level_id) values ( '1999-12-22', 'Veleičilište Velika Gorica', '+385235622223', 'Mijo', 'Kloštar-Ivanić', 'Murič', 10);
-- --users
insert into users ( email, password, arrival_sum, sum_points, user_profile_id, role_id, username) VALUES ( "svetlecic.luka@gmail.com", "lozinka", 0, 0, 1, 3, "roki");
insert into users ( email, password, arrival_sum, sum_points, user_profile_id, role_id, username) VALUES ( "ivic.ivica@gmail.com", "lozinka", 0, 0, 2, 3, "amigo213");
insert into users ( email, password, user_profile_id, role_id, username) VALUES ( "ilic.miroslav@gmail.com", "lozinka", 3, 2, "nemamUsername");
insert into users ( email, password, user_profile_id, role_id, username) VALUES ( "muric.mijo@gmail.com", "lozinka", 4, 1, "mama");
--users_tests
insert into users_tests ( user_id, test_id) values ( 1, 1);
insert into users_tests ( user_id, test_id) values ( 1, 2);
insert into users_tests ( user_id, test_id) values ( 1, 3);
insert into users_tests ( user_id, test_id) values ( 1, 4);

-- --users_arrivals
insert into users_arrivals ( user_id, meeting_id,  arrival_approved) values ( 1, 1,  1);
insert into users_arrivals ( user_id, meeting_id,  arrival_approved) values ( 1, 2, 1);