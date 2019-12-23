CREATE TABLE client (
    id UUID NOT NULL PRIMARY KEY,
    gender VARCHAR (10) NOT NULL,
    firstName VARCHAR (100) NOT NULL,
    lastName VARCHAR (100) NOT NULL,
    companyName VARCHAR (100) NOT NULL,
    email VARCHAR (100) NOT NULL,
    phone VARCHAR (10) NOT NULL,
    note VARCHAR (200) NOT NULL
);