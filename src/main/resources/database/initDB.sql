CREATE TABLE Gender
(
    id serial,
    Gender   VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Candidates
(
    id serial,
    Surname      VARCHAR(20) NOT NULL,
    Name         VARCHAR(20) NOT NULL,
    MiddleName   VARCHAR(20) NOT NULL,
    BirthDay     DATE,
    genderID     INT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (genderID) REFERENCES Gender (id)
);

CREATE TABLE Contacts
(
    id   serial,
    Contact      VARCHAR(50) NOT NULL,
    candidatesID INT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (candidatesID) REFERENCES Candidates (id)
);

CREATE TABLE Technologies
(
    id   serial,
    Technologies      VARCHAR(50),
    candidatesID INT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (candidatesID) REFERENCES Candidates (id)
);


