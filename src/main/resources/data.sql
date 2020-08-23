DROP TABLE IF EXISTS artifacts;

CREATE TABLE artifacts (
  id INT PRIMARY KEY,
  umgebung VARCHAR(250) NOT NULL,
  department_id VARCHAR(250) NOT NULL,
  artifact_id VARCHAR(250) NOT NULL,
  deployment_status VARCHAR(250) NOT NULL,
  deployment_notice VARCHAR(250) NOT NULL
);

INSERT INTO artifacts (id, umgebung, department_id, artifact_id, deployment_status, deployment_notice) VALUES
  (0, 'PROD', 'cms', 'site','WORKING', ' '),
  (1, 'DEV', 'cms', 'app', 'DEPLOYMENT','update ssh libs'),
  (2, 'TEST', 'cms', 'database', 'OFFLINE', 'server upgrade'),
  (3, 'LASTTEST', 'monitoring', 'app', 'WORKING', ' '),
  (4, 'PROD', 'cms', 'site','WORKING', ' '),
  (5, 'DEV', 'cms', 'app', 'DEPLOYMENT','update ssh libs'),
  (6, 'TEST', 'cms', 'database', 'OFFLINE', 'server upgrade'),
  (7, 'LASTTEST', 'monitoring', 'app', 'WORKING', ' ');

