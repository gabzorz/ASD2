CREATE TABLE Payment
(
    paymentID       integer NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1),
    userID          integer,
    firstName       varchar (30),
    lastName        varchar (30),
    accountNumber   integer,
    bsb             integer
);
