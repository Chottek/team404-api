USE team404db;

DROP TABLE IF EXISTS job_role;

CREATE TABLE job_role (
    job_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    contract_type ENUM ('full_time', 'part_time', 'consultant') NOT NULL
) ;


INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (0, "Head of test job", "In this role you will be expected to act as a test entry to our database", "full_time");

INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (1,
    "Head of People Operations",
    "Key member of the People Support Management team and provide strategic people direction across Kainos",
    "full_time");

INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (2,
    "Technical Architect",
    "Leading teams and developing high quality solutions which delight our customers and impact the lives of users worldwide",
    "full_time");

INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (3,
    "Security Engineer",
    "Security of technical solutions, identifying and introducing appropriate security controls, training the team in secure development practices",
    "full_time");

INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (4,
    "Product Owner",
    "Gathering and prioritising product and customer requirements, working closely with development, sales, marketing and professional services to ensure customer satisfaction goals are met and exceeded",
    "full_time");

INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (5,
    "Senior Software Engineer (Java)",
    "Developing high quality solutions which delight our customers and impact the lives of users worldwide",
    "full_time");

INSERT INTO job_role (job_id, title, description, contract_type)
VALUES (6,
    "Test Engineer",
    "Developing and executing functional automated and manual tests to help the team deliver working application software that meets user needs",
    "full_time");





