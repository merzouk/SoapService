DROP TABLE IF EXISTS test.Person;
 
CREATE TABLE test.Person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL
);
 
INSERT INTO test.Person (id, firstname, lastname) VALUES
  (1, 'Merzouk', 'MENHOUR'),
  (2, 'Rool', 'MENHOUR'),
  (3, 'Cool', 'MENHOUR');