DROP TABLE Projects IF EXISTS;

CREATE TABLE Project (
  project_id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(4000),
  PRIMARY KEY(id)
);
