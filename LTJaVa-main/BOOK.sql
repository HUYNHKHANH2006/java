CREATE DATABASE BOOK;
USE BOOK;
CREATE TABLE book.authors 
(
  authorID INT NOT NULL AUTO_INCREMENT,
  firstName varchar(20) NOT NULL,
  lastName varchar(30) NOT NULL,
  PRIMARY KEY (authorID)
);

CREATE TABLE book.titles
(
	isbn varchar(20) NOT NULL,
    title varchar(100) NOT NULL,
    editionNumber INT NOT NULL,
    copyright varchar(4) NOT NULL,
    PRIMARY KEY (isbn)
);

CREATE TABLE book.authoriSBN
(
  authorID INT NOT NULL,
  isbn varchar(20) NOT NULL,
  FOREIGN KEY (authorID) REFERENCES book.authors(authorID),
  FOREIGN KEY (isbn) REFERENCES book.titles(isbn)
);

