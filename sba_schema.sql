CREATE TABLE IF NOT EXISTS users (
    user_id INT NOT NULL AUTO_INCREMENT ,
    first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	emp_id INT,
	project_id INT,
	task_id INT,
    PRIMARY KEY (user_id)
  
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS project (
   
    project_id INT NOT NULL AUTO_INCREMENT,
    project VARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE,
    priority TINYINT,
    PRIMARY KEY (project_id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS task (
   
    task_id INT NOT NULL AUTO_INCREMENT,
	parent_id INT,
	project_id INT,
    task VARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE,
    priority TINYINT ,
	task_status VARCHAR(255),
    PRIMARY KEY (task_id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS parent_task (
   
    parent_id INT NOT NULL AUTO_INCREMENT,
    parent_task VARCHAR(255) ,
	PRIMARY KEY (parent_id)

  ) ENGINE=INNODB;

select * from users;
select * from project;

commit;

drop table project;
drop table users;