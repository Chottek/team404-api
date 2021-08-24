USE team404db;

DROP TABLE IF EXISTS job_role;

CREATE TABLE job_role (
    job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    contract_type ENUM ('full_time', 'part_time', 'consultant') NOT NULL,
    posted DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO job_role (title, contract_type)
VALUES
("Head of test job", "full_time"),
("Head of People Operations", "full_time"),
("Technical Architect", "full_time"),
("Security Engineer", "full_time"),
("Product Owner", "full_time"),
("Senior Software Engineer (Java)", "full_time"),
("Test Engineer", "full_time");





