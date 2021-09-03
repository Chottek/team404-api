USE team404db;

INSERT INTO location (location_id, name)
VALUES
(1, "London"),
(2, "Birmingham"),
(3, "Gdansk"),
(4, "Belfast"),
(5, "Derry"),
(6, "Toronto");

INSERT INTO job_role (job_id, title, contract_type, responsibilities, capability, band, sharepoint_link)
VALUES
(1, "Head of test job", "full_time",
 "\nBasically just existing and showing that everything works fine :)",
"Engineering","Associate", "Test Link"),

(2, "Head of People Operations", "full_time",
"\nLead and manage a busy global HR operational function\nIn tandem transform the function to ensure key people initiatives and processes are user centric, standardised, efficient and delivered within clearly defined SLA’s\nWorking closely with Systems team, you will drive a road map of HCM improvements with a focus on employee and manager self-serve\nEnsuring that new functionality is fully embedded"
"People", "Leadership",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EXYqFjDBzXZFiXMGdbXni2YBIM8ZztDBqB5naCdnXhbYew?e=DWvKrR"
),
(3, "Technical Architect", "full_time",
"\nLeading teams and developing high quality solutions\nWork with customer architects to agree technical designs, advising on estimated effort and technical implications of user stories and user journeys\nYou’ll manage, coach and develop a small number of staff, with a focus on managing employee performance and assisting in their career development",
"Engineering", "Consultant",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERa52ZFdOhxJuKYbwl5w27YBUGgHxFh6qz9AtTflB2YPGA?e=mMeOWH"
),
(4, "Security Engineer", "full_time",
"\nIdentifying and introducing appropriate security controls\nTraining the team in secure development practices\nSharing knowledge on threats and vulnerabilities",
"Cyber_Security", "Senior_Associate"),

(5, "Product Owner", "full_time",
"\nGathering and prioritising product and customer requirements\nWorking closely with development, sales, pre-sales, marketing and professional services to ensure customer satisfaction goals are met and exceeded\nHelping us maintain our leading market position",
 "Cyber_Security", "Senior_Associate",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbWlHfJkEF1HhJ6_BC4aqLoBAGXd7z6SYRwcdEBcNgygCQ?e=nTVpB6"
),
(6, "Product Manager", "full_time",
 "\nIncreasing the profitability of existing products to developing new products for the company\nBuilding products from existing ideas\nHelping in development of new ideas based on industry experience",
 "Business_Development_and_Marketing", "Manager",
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Workday/Product%20Development/Job%20Profile%20-%20Product%20Manager%20(Manager).pdf?web=1"
),
(7, "Senior Software Engineer", "full_time",
 "\nDeveloping high quality solutions which delight our customers and impact the lives of users worldwide",
 "Engineering", "Senior_Associate",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EeS73plMEQ9Fjf-tovttXuYBEo-0tlfT-U3bFMcgryapVw?e=wJFypU"
),
(8, "Test Engineer", "full_time",
 "\nDeveloping and executing functional automated and manual tests to help the team deliver working application software that meets user needs",
 "Engineering", "Associate",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcGbc8drFRlBoh2H2BZSeVwBV1tAiDCTwirdTmrz2EYYmQ?e=XMqXJh"
);

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
