R1 Table Below:

CREATE TABLE AUCTION_ITEM (
    ITEMID INT NOT NULL
    GENERATED ALWAYS AS IDENTITY,
    "PROPERTYID" INT NOT NULL,
    "STAFFUSERID" INT NOT NULL,
    "SELLERID" INT NOT NULL,
    "SOLDTO" INT,
    "PURCHASEID" INT,
    "SOLDFOR" INT,
    "DATEVERIFIED" DATE,
    "STARTDATE" DATE NOT NULL,
    "STARTTIME" TIME NOT NULL,
    "ENDDATE" DATE NOT NULL,
    "ENDTIME" TIME NOT NULL,
    "RESERVEPRICE" INT NOT NULL,
    "STARTINGPRICE" INT NOT NULL,
    "STATUS" VARCHAR(10),
    PRIMARY KEY (ITEMID),
    FOREIGN KEY (STAFFUSERID) REFERENCES USER_ACCOUNT,
    FOREIGN KEY (SELLERID) REFERENCES USER_ACCOUNT,
    FOREIGN KEY (SOLDTO) REFERENCES USER_ACCOUNT
);

R2 table below:

CREATE TABLE AUCTION_ITEM (
    ITEMID INT NOT NULL
    GENERATED ALWAYS AS IDENTITY,
    "PROPERTYID" INT NOT NULL,
    "STAFFUSERID" INT NOT NULL,
    "SELLERID" INT NOT NULL,
    "SOLDTO" INT,
    "KEYWORDID" INT NOT NULL,
    "PURCHASEID" INT,
    "SOLDFOR" INT,
    "DATEVERIFIED" DATE,
    "STARTDATE" DATE NOT NULL,
    "STARTTIME" TIME NOT NULL,
    "ENDDATE" DATE NOT NULL,
    "ENDTIME" TIME NOT NULL,
    "RESERVEPRICE" INT NOT NULL,
    "STARTINGPRICE" INT NOT NULL,
    "STATUS" VARCHAR(10),
    PRIMARY KEY (ITEMID),
    FOREIGN KEY (PROPERTYID) REFERENCES PROPERTY,
    FOREIGN KEY (STAFFUSERID) REFERENCES USER_ACCOUNT,
    FOREIGN KEY (SELLERID) REFERENCES USER_ACCOUNT,
    FOREIGN KEY (SOLDTO) REFERENCES USER_ACCOUNT,
    FOREIGN KEY (KEYWORDID) REFERENCES KEYWORDS
);