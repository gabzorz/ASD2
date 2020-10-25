CREATE TABLE HELPTICKET(
    HELPTICKETID INT NOT NULL PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY,
    "DETAILS" VARCHAR(1000),
    "SUBJECT" VARCHAR (100),
    "CATEGORY" VARCHAR (50),
    "DATESENT" DATE NOT NULL,
    "DATECOMPLETED" DATE,
    "STATUS" VARCHAR (10),
    "USERID" INT NOT NULL,
    "STAFFID" INT,
    "RESPONSE" VARCHAR (1000)
);