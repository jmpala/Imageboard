CREATE TABLE categories (
    ID BIGINT NOT NULL,
    category_name VARCHAR(20),
    PRIMARY KEY (ID)
);

CREATE TABLE boards (
    ID BIGINT NOT NULL,
    full_name VARCHAR(20),
    short_name VARCHAR(10),
    is_available BIT(1),
    is_nsfw BIT(1),
    category_id BIGINT,
    PRIMARY KEY (ID),
    CONSTRAINT FK_CategoriesBoards FOREIGN KEY (category_id)
        REFERENCES categories(ID)
);

CREATE TABLE posts (
    ID BIGINT NOT NULL,
    created DATE,
    photo_path VARCHAR(255),
    title VARCHAR(25),
    body VARCHAR(255),
    board_id BIGINT,
    PRIMARY KEY (ID),
    CONSTRAINT FK_BoardsPosts FOREIGN KEY (board_id)
        REFERENCES boards(ID)
);

CREATE TABLE comments (
    ID BIGINT NOT NULL,
    created DATE,
    attachment_path VARCHAR(255),
    message VARCHAR(255),
    post_id BIGINT,
    PRIMARY KEY (ID),
    CONSTRAINT FK_PostsComments FOREIGN KEY (post_id)
            REFERENCES posts(ID)
);

CREATE TABLE users (
    ID BIGINT NOT NULL,
    username VARCHAR(50),
    password VARCHAR(50),
    is_enabled BIT(1),
    PRIMARY KEY (ID)
);

CREATE TABLE roles (
    ID BIGINT NOT NULL,
    role VARCHAR(50),
    user_id BIGINT,
    PRIMARY KEY (ID),
    CONSTRAINT FK_UsersRoles FOREIGN KEY (user_id)
                REFERENCES users(ID)
);