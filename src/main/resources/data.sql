DROP TABLE IF EXISTS artifact;

CREATE TABLE artifact (
  id INT PRIMARY KEY,
  umgebung VARCHAR(250) NOT NULL,
  department_id VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  deployment_status VARCHAR(250) NOT NULL,
  deployment_notice VARCHAR(250) NOT NULL
);

INSERT INTO artifact (id, umgebung, department_id, name, deployment_status, deployment_notice) VALUES
  (0, 'PROD', 'cms', 'site','WORKING', ' '),
  (1, 'DEV', 'cms', 'app', 'DEPLOYMENT','update ssh libs'),
  (2, 'TEST', 'cms', 'database', 'OFFLINE', 'server upgrade'),
  (3, 'LASTTEST', 'monitoring', 'app', 'WORKING', ' '),
  (4, 'PROD', 'car', 'site','WORKING', ' '),
  (5, 'DEV', 'car', 'site', 'DEPLOYMENT','update ssh libs'),
  (6, 'TEST', 'car', 'database', 'OFFLINE', 'server upgrade'),
  (7, 'LASTTEST', 'office', 'app', 'WORKING', ' ');

