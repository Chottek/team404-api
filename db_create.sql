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

CREATE TABLE job_detail (
    job_detail_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    job_id INT NOT NULL, FOREIGN KEY (job_id) REFERENCES job_role(job_id),
    description TEXT NOT NULL
);

ALTER TABLE job_role ADD responsibilities VARCHAR(400) NOT NULL;

ALTER TABLE job_role ADD COLUMN capability ENUM (
    'Engineering',
    'Platforms',
    'Data',
    'Artificial_Intelligence',
    'Cyber_Security',
    'Workday',
    'Experience_Design',
    'Product',
    'Delivery',
    'Operations',
    'Business_Development_and_Marketing',
    'Organisation_Strategy_and_Planning',
    'People',
    'Commercial_and_Financial_Management',
    'Business_Services_Support'
) NOT NULL;

CREATE TABLE band (
    band_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    priority INT NOT NULL,
    name VARCHAR(100) NOT NULL
);

ALTER TABLE job_role ADD COLUMN band_id INT NOT NULL;
ALTER TABLE job_role ADD FOREIGN KEY (band_id) REFERENCES band(band_id);

CREATE TABLE competency (
    competency_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE sub_competency (
    sub_competency_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    competency_id INT NOT NULL,
    FOREIGN KEY (competency_id) REFERENCES competency(competency_id)
);

CREATE TABLE competency_indicator (
    competency_indicator_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    sub_competency_id INT NOT NULL,
    band_id INT NOT NULL,
    description VARCHAR(200) NOT NULL,
    FOREIGN KEY (band_id) REFERENCES band(band_id),
    FOREIGN KEY (sub_competency_id) REFERENCES sub_competency(sub_competency_id)
);

-- Break out capability into it's own table

ALTER TABLE job_role DROP COLUMN capability;

CREATE TABLE capability (
    capability_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL
);

ALTER TABLE job_role ADD COLUMN capability_id INT;
ALTER TABLE job_role ADD FOREIGN KEY (capability_id) REFERENCES capability(capability_id);

-- Create job families and link job_Role and capability

CREATE TABLE job_family (
    job_family_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(100),
    capability_id INT, FOREIGN KEY (capability_id) REFERENCES capability(capability_id)
);

-- Each job role can belong to a single job_family (a family may have multiple job roles)
ALTER TABLE job_role ADD COLUMN job_family_id INT;
ALTER TABLE job_role ADD FOREIGN KEY (job_family_id) REFERENCES job_family(job_family_id);


