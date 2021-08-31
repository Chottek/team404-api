DROP DATABASE team404db;
CREATE DATABASE team404db;

USE team404db;

CREATE TABLE job_role (
    job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    contract_type ENUM ('full_time', 'part_time', 'consultant') NOT NULL,
    sharepoint_link VARCHAR(200),
    posted DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE location (
    location_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE job_location (
    location_job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    job_id INT NOT NULL, FOREIGN KEY (job_id) REFERENCES job_role(job_id),
    location_id INT NOT NULL, FOREIGN KEY (location_id) REFERENCES location(location_id)
);

DROP TABLE IF EXISTS job_detail;

CREATE TABLE job_detail (
    job_detail_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    job_id INT NOT NULL, FOREIGN KEY (job_id) REFERENCES job_role(job_id),
    description TEXT NOT NULL
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





