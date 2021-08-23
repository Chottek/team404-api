USE team404db;

DROP TABLE IF EXISTS job_role;

CREATE TABLE job_role (
    job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    contract_type ENUM ('full_time', 'part_time', 'consultant') not null
) ;


INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (0, "Head of test job", "In this role you will be expected to act as a test entry to our database", "full_time");


