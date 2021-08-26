USE team404db;

INSERT INTO location (location_id, name)
VALUES
(1, "London"),
(2, "Birmingham"),
(3, "Gdansk"),
(4, "Belfast"),
(5, "Derry"),
(6, "Toronto");

INSERT INTO job_role (job_id, title, contract_type, capability, band)
VALUES
(1, "Head of test job", "full_time", "Engineering", "Associate"),
(2, "Head of People Operations", "full_time", "People", "Leadership"),
(3, "Technical Architect", "full_time", "Engineering", "Consultant"),
(4, "Security Engineer", "full_time", "Cyber_Security", "Senior_Associate"),
(5, "Product Owner", "full_time", "Business_Development_and_Marketing", "Manager"),
(6, "Senior Software Engineer (Java)", "full_time", "Engineering", "Senior_Associate"),
(7, "Test Engineer", "full_time", "Engineering", "Associate");

-- Link inserted Jobs to their available locations
INSERT INTO job_location (job_id, location_id)
VALUES
(1, 1), (1, 2), (1, 3),
(2, 4),
(3, 6),
(4, 1), (4, 4),
(5, 1),
(6, 1), (6, 4), (6, 2), (6, 3),
(7, 1);

-- Insert Job descriptions
INSERT INTO job_detail (job_id, description)
VALUES
(1, "<b>What you will be expected to do </b> <br/> Day to day you will be expected to be a test entry in our tables."),
(2, "Some detailed description goes here"),
(3, "Some detailed description goes here"),
(4, "Some detailed description goes here"),
(5, "Some detailed description goes here"),
(6, "Some detailed description goes here"),
(7, "Some detailed description goes here");