CREATE TABLE IF NOT EXISTS users (
    user_id INT NOT NULL AUTO_INCREMENT ,
    fname VARCHAR(255) NOT NULL,
	lname VARCHAR(255) NOT NULL,
	emp_id INT,
	project_id INT,
    PRIMARY KEY (user_id),
    KEY project_fk (project_id),
  CONSTRAINT project_fk FOREIGN KEY (project_id) REFERENCES project (project_id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS project (
   
    project_id INT NOT NULL AUTO_INCREMENT,
    project VARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE,
    priority TINYINT NOT NULL,
    PRIMARY KEY (project_id)
)  ENGINE=INNODB;

select * from users;

commit;