USE team404db;

INSERT INTO location (location_id, name)
VALUES
(1, "London"),
(2, "Birmingham"),
(3, "Gdansk"),
(4, "Belfast"),
(5, "Derry"),
(6, "Toronto");

INSERT INTO band (band_id, name)
VALUES
(1, 'Leadership'),
(2, 'Principal'),
(3, 'Manager'),
(4, 'Consultant'),
(5, 'Senior_Associate'),
(6, 'Associate'),
(7, 'Trainee'),
(8, 'Apprentice');

INSERT INTO job_role (job_id, title, contract_type, capability, band_id)
VALUES
(1, "Head of test job", "full_time", "Engineering", 1),
(2, "Head of People Operations", "full_time", "People", 1),
(3, "Technical Architect", "full_time", "Engineering", 4),
(4, "Security Engineer", "full_time", "Cyber_Security", 5),
(5, "Product Owner", "full_time", "Business_Development_and_Marketing", 3),
(6, "Senior Software Engineer (Java)", "full_time", "Engineering", 5),
(7, "Test Engineer", "full_time", "Engineering", 6);

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

INSERT INTO competency (competency_id, name)
VALUES
(1,"Personal Performance"),
(2,"Working With Others"),
(3,"Setting Direction, Development & Accountability"),
(4,"Supporting and Delivering the strategy"),
(5,"Commerciality and Risk"),
(6, "Communication And Influence");

INSERT INTO sub_competency (sub_competency_id, competency_id, name)
VALUES
(1, 1, "Developing self-awareness"),
(2, 1, "Managing yourself"),
(3, 1, "Continuing personal development"),
(4, 1, "Acting with integrity"),
(5, 2, "Mobilises self and others to drive self-improvement"),
(6, 2, "Champions continuous improvement"),
(7, 2, "Developing networks and building and maintaining relationships"),
(8, 2, "Working within teams"),
(9, 3, "Effective time management"),
(10, 3, "Promoting accountability"),
(11, 3, "Effective meetings"),
(12, 3, "Problem solving"),
(13, 4, "Supporting the strategy and vision"),
(14, 4, "Organisational awareness"),
(15, 4, "Cultural and ethical awareness"),
(16, 5, "Demonstrates commercial awareness and behaviours"),
(17, 5, "Improves efficiency and effectiveness to drive profitability"),
(18, 5, "Promotes and adheres to Kainos process and policies"),
(19, 6, "Communicates effectively "),
(20, 6, "Influencing others"),
(21, 6, "Customer Focus and Stakeholder management");

INSERT INTO competency_indicator (band_id, sub_competency_id, description)
VALUES

-- Beginner band
(
8, 1,
"Understands own strengths and areas of development. Self-aware of own well being and seeks support where appropriate."
),
(
8, 2,
"Works with People Manager to sets and achieve goals by monitoring progress regularly against performance."
),
(
8, 3,
"Flexible and willingness to learn on the job while proactively keeping up to date with the knowledge and skills needed."
),
(
8, 4,
"Understands the company values and applies this to own principles. Is open and honest and acts respectfully with others and customers."
),
(
8, 5,
"Understand how to respond constructively to developmental feedback from a diverse range of people and implement changes as a result."
),
(
8, 6,
"Displays high levels of enthusiasm, energy and pace to achieve performance and results."
),
(
8, 7,
"Recognises the need to build internal networks within immediate teams and projects."
),
(
8, 8,
"Respects others by attending meetings on time and contributing where appropriate. Recognising how current role relates to others within Capability and project."
),
(
8, 9,
"Understands role, tasks and deadlines and work towards these, escalating any issues where appropriate to People/Project Manager."
),
(
8, 10,
"Accepts personal responsibility for quality and timelines of work set."
),
(
8, 11,
"Works to manage diary, commitments and ready to attend meetings on time."
),
(
8, 12,
"Actively supports new initiatives and tries different ways of doing things, learning from others’ experiences."
),
(
8, 13,
"Understands the Kainos Vision, Strategy and Principles."
),
(
8, 14,
"Understands the organisation structure and the purpose of Kainos."
),
(
8, 15,
"Possess general knowledge of local cultural differences and familiar with the Kainos policy towards Diversity and Inclusion."
),
(
8, 16,
"Understands the markets and sectors in which Kainos operates while acknowledging how role links in and has an impact on other teams and the business."
),
(
8, 16,
"Wiling to learn, and embrace new ideas, to improve processes and procedures."
),
(
8, 16,
"Cooperates with business processes completing accurately and honestly e.g., timesheets/EOY Review and travel requests."
),
(
8, 16,
"Acts in a respectful manner in all forms of communication while being open and honest.Displays a positive approach when interacting with others."
),
(
8, 16,
"Recognises influencing as a key skill required to work effectively with internal and external customers."
),
(
8, 16,
"Acts in accordance with the Kainos values demonstrating through own behaviours and interactions with colleagues and customers."
);





