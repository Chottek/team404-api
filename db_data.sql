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
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FPeople%2FJob%20profile%20-%20Global%20Head%20of%20People%20Support%20%28Leader%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FPeople"
),
(3, "Technical Architect", "full_time",
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20-%20Technical%20Architect%20%28Consultant%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering"
),
(4, "Security Engineer", "full_time",
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FCyber%20Security%2FJob%20profile%20-%20Security%20Engineer%20%28Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FCyber%20Security"
),
(5, "Product Manager", "full_time",
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FWorkday%2FProduct%20Development%2FJob%20Profile%20%2D%20Principal%20Product%20Manager%20%28Principal%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FWorkday%2FProduct%20Development"
),
(6, "Senior Software Engineer", "full_time",
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Software%20Engineer%20%28Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering"
),
(7, "Test Engineer", "full_time",
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FTesting%2FJob%20profile%20%2D%20Test%20Engineer%20%28Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FTesting"
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