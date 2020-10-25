CREATE TABLE Post
(
    postID       integer NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1),
    title       varchar (50),
    category    varchar (50),
    content     varchar (500)
);

