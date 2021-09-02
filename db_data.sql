USE team404db;

INSERT INTO location (location_id, name)
VALUES
(1, "London"),
(2, "Birmingham"),
(3, "Gdansk"),
(4, "Belfast"),
(5, "Derry"),
(6, "Toronto");

INSERT INTO job_role (job_id, title, contract_type, sharepoint_link)
VALUES
(1, "Head of test job", "full_time", "Test Link"),
(2, "Head of People Operations", "full_time",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EXYqFjDBzXZFiXMGdbXni2YBIM8ZztDBqB5naCdnXhbYew?e=DWvKrR"
),
(3, "Technical Architect", "full_time",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERa52ZFdOhxJuKYbwl5w27YBUGgHxFh6qz9AtTflB2YPGA?e=mMeOWH"
),
(4, "Security Engineer", "full_time",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbWlHfJkEF1HhJ6_BC4aqLoBAGXd7z6SYRwcdEBcNgygCQ?e=nTVpB6"
),
(5, "Product Manager", "full_time",
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Workday/Product%20Development/Job%20Profile%20-%20Product%20Manager%20(Manager).pdf?web=1"
),
(6, "Senior Software Engineer", "full_time",
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EeS73plMEQ9Fjf-tovttXuYBEo-0tlfT-U3bFMcgryapVw?e=wJFypU"
),
(7, "Test Engineer", "full_time",
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