
CREATE TABLE deployments (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  envirnoment_id VARCHAR(250) NOT NULL,
  department_id VARCHAR(250) NOT NULL,
  artifact_id VARCHAR(250) NOT NULL
  status VARCHAR(250) NOT NULL
  notice VARCHAR(250) NOT NULL
);

INSERT INTO deployments (envirnoment_id, department_id, artifact_id, status, notice) VALUES
  ('PROD', 'cms', 'site','WORKING', ''),
  ('DEV', 'cms', 'app', 'DEPLOYMENT','update ssh libs'),
  ('TEST', 'cms' 'database', 'OFFLINE', 'server upgrade');
  ('LASTTEST', 'monitoring', 'app', 'WORKING', '');