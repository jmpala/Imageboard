INSERT INTO categories (ID, category_name) VALUES
(300, 'a'),
(301, 'b'),
(302, 'c');

INSERT INTO boards (ID, full_name, is_available, is_nsfw, short_name, category_id) VALUES
(1, 'aaaaaaa', 1, 1, 'a', 300),
(2, 'bbbbbbb', 1, 1, 'b', 301),
(3, 'ccccccc', 1, 1, 'c', 302);

INSERT INTO posts (ID, body, created, photo_path, title, board_id) VALUES
(100, 'Body 1', '2021-06-19', 'path', 'Title 1', 1),
(101, 'Body 2', '2021-06-19', 'path', 'Title 2', 1),
(102, 'Body 3', '2021-06-19', 'path', 'Title 3', 1),
(103, 'Body of post', '2021-06-19', 'path', 'Post 222', 2);

INSERT INTO comments (ID, attachment_path, created, message, post_id) VALUES
(200, 'path', '2021-06-19', 'Hola 1', 100),
(201, 'path', '2021-06-19', 'Hola 2', 100),
(202, 'path', '2021-06-19', 'Hola 3', 100),
(203, 'path', '2021-06-19', 'Hola 4', 101),
(204, 'path', '2021-06-19', 'Hola 5', 101),
(205, 'path', '2021-06-19', 'Hola 6', 102);

INSERT INTO users (ID, username, password, enabled) VALUES
(500, 'user1', '$2a$10$CfBM1IjkCt16AvGi4NSKsOY8ZGMwDUdkVnSCttNbC.6K4uupAOFE6', 1),
(501, 'user2', '$2a$10$CfBM1IjkCt16AvGi4NSKsOY8ZGMwDUdkVnSCttNbC.6K4uupAOFE6', 1),
(502, 'user3', '$2a$10$CfBM1IjkCt16AvGi4NSKsOY8ZGMwDUdkVnSCttNbC.6K4uupAOFE6', 1),
(503, 'admin1', '$2a$10$CfBM1IjkCt16AvGi4NSKsOY8ZGMwDUdkVnSCttNbC.6K4uupAOFE6', 1),
(504, 'admin1', '$2a$10$CfBM1IjkCt16AvGi4NSKsOY8ZGMwDUdkVnSCttNbC.6K4uupAOFE6', 1);

INSERT INTO roles (ID, role, user_id) VALUES
(600,'user',500),
(601,'user',501),
(602,'user',502),
(603,'admin',503),
(604,'admin',504);