/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Corey
 * Created: 19/10/2020
 */

CREATE TABLE KEYWORDS(
    KEYWORDSID INT NOT NULL PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    "USERID" INT,
    "BATHROOM" INT,
    "BEDROOM" INT,
    "GARAGE" INT); 