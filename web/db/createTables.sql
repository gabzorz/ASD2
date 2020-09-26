CREATE TABLE ROLE(
    ROLEID INT NOT NULL
    GENERATED ALWAYS AS IDENTITY,
    "ROLENAME" VARCHAR(20),
    PRIMARY KEY (ROLEID)
);

CREATE TABLE USER_ACCOUNT(
    USERID INT NOT NULL
    GENERATED ALWAYS AS IDENTITY,
    "ROLEID" INT,
    "FNAME" VARCHAR(50),
    "LNAME" VARCHAR(50),
    "ADDRESS" VARCHAR(100),
    "DATEOFBIRTH" VARCHAR(10),
    "EMAILADDRESS" VARCHAR(100),
    "CONTACTNUMBER" INTEGER,
    "PASSWORD" VARCHAR(50),
    PRIMARY KEY (USERID),
    FOREIGN KEY (ROLEID) REFERENCES ROLE
);

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
    FOREIGN KEY (KEYWORDID) REFERENCES KEYWORDS,
    FOREIGN KEY (PURCHASEID) REFERENCES PURCHASE
);

CREATE TABLE BID (
    "ITEMID" INT NOT NULL,
    "USERID" INT NOT NULL,
    "DATE" DATE DEFAULT CURRENT_DATE,
    "TIME" TIME DEFAULT CURRENT_TIME,
    "AMOUNT" INT NOT NULL,
    FOREIGN KEY (ITEMID) REFERENCES AUCTION_ITEM,
    FOREIGN KEY (USERID) REFERENCES USER_ACCOUNT
);