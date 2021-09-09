USE team404db;

INSERT INTO location (location_id, name)
VALUES
(1, "London"),
(2, "Birmingham"),
(3, "Gdansk"),
(4, "Belfast"),
(5, "Derry"),
(6, "Toronto");

INSERT INTO band (band_id, name, priority)
VALUES
(1, 'Leadership', 2),
(2, 'Principal', 3),
(3, 'Manager', 4),
(4, 'Consultant', 5),
(5, 'Senior_Associate', 6),
(6, 'Associate', 7),
(7, 'Trainee', 8),
(8, 'Apprentice', 9),
(9, 'Executive', 1);

INSERT INTO capability (capability_id, name)
VALUES
(1, 'Engineering'),
(2, 'Platforms'),
(3, 'Data'),
(4, 'Artificial_Intelligence'),
(5, 'Cyber_Security'),
(6, 'Workday'),
(7, 'Experience_Design'),
(8, 'Product'),
(9, 'Delivery'),
(10, 'Operations'),
(11, 'Business_Development_and_Marketing'),
(12, 'Organisation_Strategy_and_Planning'),
(13, 'People'),
(14, 'Commercial_and_Financial_Management'),
(15, 'Business_Services_Support');

INSERT INTO job_family (job_family_id, name, capability_id)
VALUES
(1,"Engineering Strategy and Planning",1),
(2,"Engineering",1),
(3,"Architecture",1),
(4,"Testing and Quality Assurance",1),
(5,"Product Specialist",1);


INSERT INTO job_role (job_id, title, contract_type, capability_id, band_id, sharepoint_link)
VALUES
(1, "Head of test job", "full_time", 1, 1,
"Test Link"),

(2, "Head of People Operations", "full_time", 13, 1,
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EXYqFjDBzXZFiXMGdbXni2YBIM8ZztDBqB5naCdnXhbYew?e=DWvKrR"),

(3, "Security Engineer", "full_time", 5, 5,
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERa52ZFdOhxJuKYbwl5w27YBUGgHxFh6qz9AtTflB2YPGA?e=mMeOWH"),

(4, "Product Owner", "full_time", 11, 3,
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbWlHfJkEF1HhJ6_BC4aqLoBAGXd7z6SYRwcdEBcNgygCQ?e=nTVpB6");


INSERT INTO job_role (job_id, title, contract_type, capability_id, band_id, job_family_id, sharepoint_link)
VALUES
(5, "Technical Architect", "full_time", 1, 4, 3,
"https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Workday/Product%20Development/Job%20Profile%20-%20Product%20Manager%20(Manager).pdf?web=1"),

(6, "Senior Software Engineer (Java)", "full_time", 1, 5, 2,
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EeS73plMEQ9Fjf-tovttXuYBEo-0tlfT-U3bFMcgryapVw?e=wJFypU"),

(7, "Test Engineer", "full_time", 1, 6, 5,
"https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcGbc8drFRlBoh2H2BZSeVwBV1tAiDCTwirdTmrz2EYYmQ?e=XMqXJh");


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

-- Trainee - Consultant Personal Performance
(1, 1, "Developing self-awareness"),
(2, 1, "Managing yourself"),
(3, 1, "Continuing personal development"),
(4, 1, "Acting with integrity"),

-- Trainee - Consultant Working With Others
(5, 2, "Mobilises self and others to drive self-improvement"),
(6, 2, "Champions continuous improvement"),
(7, 2, "Developing networks and building and maintaining relationships"),
(8, 2, "Working within teams"),

-- Trainee - Consultant Setting Direction
(9, 3, "Effective time management"),
(10, 3, "Promoting accountability"),
(11, 3, "Effective meetings"),
(12, 3, "Problem solving"),

-- Trainee - Consultant Supporting and Delivering
(13, 4, "Supporting the strategy and vision"),
(14, 4, "Organisational awareness"),
(15, 4, "Cultural and ethical awareness"),

-- Trainee - Consultant Commerciality and Risk
(16, 5, "Demonstrates commercial awareness and behaviours"),
(17, 5, "Improves efficiency and effectiveness to drive profitability"),
(18, 5, "Promotes and adheres to Kainos process and policies"),

-- Trainee - Consultant Communication And Influence
(19, 6, "Communicates effectively "),
(20, 6, "Influencing others"),
(21, 6, "Customer Focus and Stakeholder management"),



-- Manager - Executive Personal Performance
(22, 1, "Developing self-awareness"),
(23, 1, "Managing yourself"),
(24, 1, "Continuing personal development"),
(25, 1, "Acting with integrity"),

-- Manager - Executive Working with others
(26, 2, "Mobilises people to drive business improvement & innovation"),
(27, 2, "Champions continuous improvement in self & others creating a positive environment and encouraging contribution"),
(28, 2, "Managing performance"),
(29, 2, "Developing networks and building and maintaining relationships"),
(30, 2, "Working within teams"),

-- Manager - Executive Setting Direction
(31, 3, "Identifying the contexts for change"),
(32, 3, "Improvement and Innovation"),
(33, 3, "Making decisions"),
(34, 3, "Creating and Evaluating impact"),

-- Manager - Executive Supporting and Delivering
(35, 4, "Framing the strategy"),
(36, 4, "Developing the strategy"),
(37, 4, "Implementing the strategy "),
(38, 4, "Embedding the strategy"),

-- Manager - Executive Commerciality and Risk
(39, 5, "Demonstrates commercial awareness and behaviours"),
(40, 5, "Contributes to the ongoing development of new business to support Kainos’ growth ambitions"),
(41, 5, "Improves efficiency and effectiveness to drive profitability "),
(42, 5, "Manages risk to Kainos and the interest of our shareholders "),
(43, 5, "Promotes and adheres to Kainos process and policies "),

-- Manager - Executive Communicating and Influence
(44, 6, "Develops, communicates and promotes the Kainos vision and strategy"),
(45, 6, "Influencing the vision and beyond"),
(46, 6, "Influencing change and transformation"),
(47, 6, "Stakeholder management");


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
8, 17,
"Understands the markets and sectors in which Kainos operates while acknowledging how role links in and has an impact on other teams and the business."
),
(
8, 18,
"Wiling to learn, and embrace new ideas, to improve processes and procedures."
),
(
8, 19,
"Cooperates with business processes completing accurately and honestly e.g., timesheets/EOY Review and travel requests."
),
(
8, 20,
"Acts in a respectful manner in all forms of communication while being open and honest.Displays a positive approach when interacting with others."
),
(
8, 21,
"Recognises influencing as a key skill required to work effectively with internal and external customers."
),
(
8, 21,
"Acts in accordance with the Kainos values demonstrating through own behaviours and interactions with colleagues and customers."
),

-- Indicators for Trainee level
(
7, 1,
"Understands others strengths and areas for development. Recognising diversity and its value within self and team.Proactively uses wellbeing tools to support self-regulation."
),
(
7, 2,
"Able to identify own goals and discusses these with People Manager. Understands the need to work conscientiously to achieve tasks on schedule."
),
(
7, 3,
"Identifies learning gaps and seeks out opportunities to improve skills. Open to developmental feedback from others."
),
(
7, 4,
"Demonstrates positive behaviours when dealing with others and ensures application of the values while working and representing Kainos to our customers."
),
(
7, 5,
"Shares learning with the team and other colleagues, contributing to the team’s understanding."
),
(
7, 6,
"Maintains consistent performance, challenging self and others to be positive and focused on achieving results, despite setbacks.Support others to work in a way that is mutually supportive"
),
(
7, 7,
"Builds strong working relationships within team and project teams and start to consider building a wider network."
),
(
7, 8,
"Aware of the consequences of own behaviour and how this may affect others within the team. Supports the sharing of knowledge, information and learning with other colleagues."
),
(
7, 9,
"Plans time effectively to ensure deadlines are met, and seen to be honest, escalating in advance any issues with completing tasks within the specified time."
),
(
7, 10,
"Takes ownership of all responsibilities within own role and honours commitments to others and to Kainos."
),
(
7, 11,
"Effectively manages diary, coming prepared for meetings and actively listen."
),
(
7, 12,
"Breaks down issues, and actively seeks further information and understanding."
),
(
7, 13,
"Recognise show to contribute to the wider organisational objectives and strategic principles."
),
(
7, 14,
"Pays attention to organisational information, how well we are doing and what is changing."
),
(
7, 15,
"Awareness of cultural differences and willingness to develop and grow understanding of global and cultural effectiveness."
),
(
7, 16,
"Understand show the business generates income. Supporting the business by assisting in activities such as Recruitment events, Career fairs and Work experience mentoring. Keeps up to date with current trends relating to work."
),
(
7, 17,
"Reviews current practices and constructive in implementing changes to own work."
),
(
7, 18,
"Consistently cooperates with business processes completing accurately and honestly e.g., timesheets/EOY Review and travel requests."
),
(
7, 19,
"Communicates own views in a clear and constructive manner, while listening to different views and considers all employees from various backgrounds."
),
(
7, 20,
"Observes team/colleagues influencing internally and externally and understands the benefits of adapting personal style to shape, motivate and influence effectively."
),
(
7, 21,
"Understands who our customers are and what problems the team is trying to solve. "
),

-- Associate Level Indicators
(
6, 1,
"Seeks out new challenges and opportunities that may stretch current abilities. Builds on own self-awareness of overall wellbeing."
),
(
6, 2,
"Recognises the need for SMART goals, and demonstrates a “can do” attitude, through having own internal standards of performance."
),
(
6, 3,
"Seeksout opportunities to improve skills beyond the role scope whilst also seeking regular feedback."
),
(
6, 4,
"Encourages positive behaviours in others, while role modelling the Kainos values."
),
(
6, 5,
"Actively take opportunities to learn from a diverse range of people, to maximise performance and mentor/coach more junior colleagues."
),
(
6, 6,
"Is creative in finding ways to learn and personally improve results, suggesting new approaches to benefit self and the team.Review progress against goals making necessary adjustments to deliver successfully."
),
(
6, 7,
"Consistently collaborates within immediate teams and finds opportunities to build rapport and trust while supporting others.Proactively contribute to the work of the whole team whilst building positive colleague relationships."
),
(
6, 8,
"Actively participates and cooperates to support others within the team to achieve common goals. Able to interact effectively in stressful or frustrating situations, knowing when to step away for composure."
),
(
6, 9,
"Recognises how much time is required for different tasks and start to prioritise and communicate effectively within teams. Seeking appropriate support while supporting peers and junior team members."
),
(
6, 10,
"Identifies commitments and proactively seeks responsibility in delivering towards the wider team and project objectives."
),
(
6, 11,
"Establishes effective meetings through setting an agenda and coming prepared and speaking on projects calls where appropriate. Follows up and delivers upon actions from meetings."
),
(
6, 12,
"Makes suggestions for improvements to personal work and processes. "
),
(
6, 13,
"Articulates individual contribution to the wider Kainos objectives and uses evidence by including SMART goals that align to the Capability/BU."
),
(
6, 14,
"Clearly defines how individual personal performance can have an impact on the business achieving the vision and objectives."
),
(
6, 15,
"Respects differences and promotes inclusion on a transactional level.Displays appropriate ethical behaviours and acknowledges own unconscious bias."
),
(
6, 16,
"Comprehends the need for the business to generate additional income and respects that costs need to be managed.Recognises the contribution that role makes to the success of the business, consistently delivering to task deadlines."
),
(
6, 17,
"Acknowledges what is required to manage costs within the business. Considers and suggests ideas for improvements,sharing this feedback with others in a constructive manner."
),
(
6, 18,
"Constantly achieves personal productive utilisation targets. Appreciating how the team/project supports increased income for Kainos."
),
(
6, 19,
"Involved at meetings, asking questions, listening and develops and presents a well-reasoned point of view.Remaining communicative and clear in own thoughts and ideas when approached by others, giving consideration to the communication needs of other staff and customers."
),
(
6, 20,
"Demonstrates influencing skills internally and able to communicate points clearly and open to feedback from others."
),
(
6, 21,
"Demonstrate show to participate in stakeholder management, escalates effectively,and strives to provide a quality service and showcase Kainos positively."
),

-- Senior Associate Level indicators
(
5, 1,
"Understands and confidently articulates own learning and developmental needs and proactively seek opportunities to gain experience.Has a strong level of self-awareness and in tune with own wellbeing needs and intuitive of others."
),
(
5, 2,
"Seeks and responds positively to feedback regarding own learning and development. Approach with a willingness to take on tasks that are outside role scope."
),
(
5, 3,
"Looks for opportunities to take on new challenges while proactively supporting and encouraging others in identifying learning needs."
),
(
5, 4,
"Recognises inappropriate behaviours and challenges constructively while promoting the Kainos values. Adapting behaviours and acting in the most appropriate way to enable others to respond constructively."
),
(
5, 5,
"Proactively supports the development of other team members while identifying opportunities to increase innovation to achieve team’s objectives."
),
(
5, 6,
"Encourages both formal and inform all learning opportunities, ensuring others take responsibility for own learning and share this to increase organisational capability.Support and stretches self and others to deliver agreed goals and objectives"
),
(
5, 7,
"Effectively builds wider networks across projects, Capabilities and BUs and constructively challenges colleagues including those in positions of authority."
),
(
5, 8,
"Encourages collaborative team working within immediate teams and across the whole business. Supports an environment where others can make mistakes and learn from it. Open to giving and receiving honest feedback in order to highlight areas of improvement and recognise high performance."
),
(
5, 9,
"A strong ability to multitask and prioritise to deadlines, overcoming obstacles to ensure the work is completed within time. Researching and communicating in advance any barriers that may affect projects."
),
(
5, 10,
"Demonstrates individual responsibility for achieving objectives and able to articulate success, failures and proposing remedial actions."
),
(
5, 11,
"Consistently prepared for meetings and effectively manages own diary for preparation and an agenda is set in advance. Actively seeks input from colleagues and challenges others where appropriate."
),
(
5, 12,
"Processes and distils a variety of information to understand a problem fully while proposing options for solutions and building on the ideas of others."
),
(
5, 13,
"Supports peers and team members in understanding the wider Kainos objectives and how we all have a role in Kainos’success."
),
(
5, 14,
"Recognises and reflects on how personal actions may have a wider impact on other people and teams."
),
(
5, 15,
"Demonstrates awareness and appreciation for the global multi-dimensional and diverse perspectives of our people.Provide a protective environment within immediate teams in which colleagues can escalate any issues while demonstrating impartial application of Kainos policies, procedure and practices."
),
(
5, 16,
"Demonstrates a clear understanding of how the business makes profit and how individual role effects profitability of the company.Respectfully challenges commercial decisions to contribute an increased profitability."
),
(
5, 17,
"Manages and meets the expectations of customers without compromising budgets. Supports change in a constructive manner to help colleagues and stakeholders understand changes and why they have been introduced."
),
(
5, 18,
"Understands the organisational structure of Kainos, reporting lines and can actively identify where key responsibilities lie. "
),
(
5, 19,
"Recognises and respect that communication is a two-way process and demonstrate effective questioning and active listening skills to achieve this. Confidently handles challenging conversations and is clear and constructive in response."
),
(
5, 20,
"Persuades and influences with sound rationale argument ‘appealing to others’ interest or reason to gain support."
),
(
5, 21,
"Authentic in stakeholder relationships and take pride in being inclusive and trustworthy while keeping promises made with customers. Responds honestly and promptly to customer requests and whenever possible within agreed timeframes. "
),

-- Consultant Level Indicators
(
4, 1,
"Understands own personal preferences, biases and values different cultures, backgrounds and circumstances in decision making and takes actions. Champions Kainos wellbeing offerings and provides direction to the various wellbeing guides and support available for our people."
),
(
4, 2,
"Consistently sets own goals and manages this independently. Making autonomous decisions and are able to ‘get on with the job’ escalating decisions only when appropriate."
),
(
4, 3,
"Identifies and addresses team or individual capability requirements and gaps to deliver current and future work. Consistently identifies and develops self and others to support talent development."
),
(
4, 4,
"Demonstrates professional and organisational values through actions and behaviours. Behaves in an inclusive manner and respects equality and diversity."
),
(
4, 5,
"Support and empower team members through a range of activities to include coaching and mentoring. Demonstrate that leadership and technical skills are equally valued"
),
(
4, 6,
"Role model continuous learning and self-development, evaluating own effectiveness and growth.Motivate others to achieve through challenging times. Regularly monitor and discuss own and team’s performance expectations defined within the performance management system."
),
(
4, 7,
"Builds a strong network of collaborative relationships, in order to achieve objectives, whilst supporting wider stakeholder agendas. Recognised as an active mentor and coach and can demonstrate examples of coaching others in immediate teams to improve performance."
),
(
4, 8,
"Encourages involvement from others to deliver through collaboration better results for Kainos. Recognises and builds on individual strengths of colleagues and team members while building relationships based on trust. Consistently publicise what the team members have achieved and give feedback and recognition awards where appropriate."
),
(
4, 9,
"Develops effective systems to organise and track workload while, motivating and encouraging others to achieve planned results, delegating work to use people and resources to best effect. Ensuring colleagues are aware of any changing priorities and monitor progress."
),
(
4, 10,
"Delegates authority to match responsibilities and holds staff accountable for agreed-upon commitments. Within immediate teams creates accountability by using experience and advice to guide others."
),
(
4, 11,
"Sets an example of leading internal and external meetings through preparation, prioritisation, and considered agendas,ensuring any challenges and issues are discussed."
),
(
4, 12,
"Seeks the opinions and experiences of others to understand different approaches while thinking laterally about own work and encouraging creative problem solving."
),
(
4, 13,
"Balances own teams needs with wider organisational needs while translating the Vision and Strategy into practical and tangible goals."
),
(
4, 14,
"Effectively ensures immediate teams understand how their work contributes to and delivers organisational priorities."
),
(
4, 15,
"Consistently role models cultural effectiveness in the demonstration of ethical behaviours while understanding the value diversity brings to Kainos. Promoting diversity and inclusion within teams while adapting to the needs of our diverse people."
),
(
4, 16,
"Identifies potential new opportunities for Kainos to generate income and proactively takes action to progress. Understanding the commercial implications of changes in scope and negotiate with customers proactively. Able to look beyond the immediate problems/issues to see the impact on the bigger picture."
),
(
4, 17,
"Uses financial information to find pragmatic new ways of saving cost/effort without reducing output. Review procedures or systems with immediate teams to identify improvements and simplify processes and decision making."
),
(
4, 18,
"Recognise the impact of BU and company profitability and supports company decisions that affect+profit.Ensures own team are adhering to policies, processes, and procedures."
),
(
4, 19,
"Uses communication to create a shared sense of purpose and direction. Adapting own style to effectively communicate and able to demonstrate this when difficult conversations have a positive outcome."
),
(
4, 20,
"Acts as an influential and effective member of multi-disciplinary teams or projects. Initiate’s collaboration and actively encourages people to cooperate in initiatives where they can add value."
),
(
4, 21,
"Assesses customer needs accurately by listening and applying sensitive questioning. Managing customer expectations in relation to scope of work and are honest in what can and cannot be achieved within timescales. Confident in negotiating with customers to reflect changes in scope of work."
),

-- Manager Level Indicators
(
3, 22,
"Reflects on how factors such as own values, prejudices and emotions influences own judgement, behaviour, and self-belief. Uses feedback from appraisals and other sources to consider personal impact and changes behaviour. Understands personal sources of stress and wellbeing."
),
(
3, 23,
"Plans and manages own time effectively and fulfils work requirements and commitments to a high standard, without compromising own health and wellbeing. Remains calm and focused under pressure. "
),
(
3, 24,
"Proactively manages self and career and identifies personal learning needs plan and completes a broad range of formal andinformal learning opportunitiesby taking responsibility for own personal development and seeking opportunities for learning. Strives to put learning into practice.Clearly demonstrates that leadership and technical skills are equally valued. "
),
(
3, 25,
"Behaves in an open, honest, and inclusive manner, upholding personal and organisational ethics and values. Shows respect for the needs of others and promotes equality and diversity."
),
(
3, 26,
"Supports others in delivering high quality services and excellence by supporting mobilising teams and contributing to business improvement."
),
(
3, 27,
"Seeks and acknowledges the views and inputs of others. Shows respect for the contributions and challenges of others through positive and constructive feedback."
),
(
3, 28,
"Uses information and data about performance to identify improvements which will strengthen services."
),
(
3, 29,
"Identifies where working and cooperating with others can result in better services. Endeavours to work collaboratively. Communicates with and listens to others, recognising different perspectives. Empathises and considers the needs and feelings of others. Gains and maintains trust andsupport."
),
(
3, 30,
"Understands roles, responsibilities, and purpose within the team. Adopts a collaborative approach and respects team decisions."
),
(
3, 31,
"Understands the range of factors which determine why changes are made and supports Kainos senior leaders to deliver key messages."
),
(
3, 32,
"Gathers data and information about aspects of the business, analyses evidence and uses this knowledge to suggest changes that will improve services in the future.Questions established practices which do not add value. Puts forward creative suggestions to improve the quality of service provided."
),
(
3, 33,
"Consults with others and contributes to decisions including the future direction/vision of own business area or projects. "
),
(
3, 34,
"Assesses the effects of change on service delivery and customer outcomes. Makes recommendations for future improvements."
),
(
3, 35,
"Strategic awareness including an understanding and knowledge of how role and those within in immediate team fit with and support delivery of the organisational objectives."
),
(
3, 36,
"Feeds in ideas and knowledge from immediate teams and supports the senior leaders in developing a strategy."
),
(
3, 37,
"Support, develop and implement the strategy in immediate teams. "
),
(
3, 38,
"Passionately advocates the strategy and vision and translates this into action and opportunities within immediate teams. Understands the need for OKR’s/KPI’s and own role in supporting and shaping in relation to immediate teams. "
),
(
3, 39,
"Aware of the importance of effective commercial behaviours and the needs of the business. Identifies and ensures that personal objectives are focussed on innovative solutions to achieve commercial outcomes and objectives as well as contributing to our growth ambitions. Recognises when products or services are not being  delivered to the required level of quality or standard and takes appropriate action. "
),
(
3, 40,
"Contributes to development of new business through involvement in BD process, for example, bid/proposal writing, customer presentations, pricing solutions. Establishes trusted customer relationships and adds value by helping and advising customers in areas beyond current project work, identifying possible areas where additional Kainos business can be generated."
),
(
3, 41,
"Looks to support and drive efficiencies and profitability through immediate team. Reviews processes within own teams and challenges through the right behaviours and channels to support the overall commercial objectives. "
),
(
3, 42,
"Understands and protects Kainos from risks associated with contractual commitments. Takes a balanced risk and reward view to activities and commitments while managing quality and Kainos interests."
),
(
3, 43,
"Supports and aligns to Kainos policies and processes escalating or challenging where appropriate. Ensures compliance across own team. "
),
(
3, 44,
"Provides feedback and support in communicating the vision, and advocates within immediate teams."
),
(
3, 45,
"Credible communicator, displaying authenticity and adapting influencing style for different audiences."
),
(
3, 46,
"Articulates the need for changes to processes and systems, acknowledging the impact on people and services."
),
(
3, 47,
"Applies and adapts various approaches to stakeholder management through influencing and negotiating to maximise business for Kainos by developing and maintaining internal and external networks."
),


-- Principal Level Indicators
(
2, 22,
"Appreciates the impact of self on others and the impact others have on self. Routinely seeks feedback and adapts own behaviour appropriately. Identifying the impact others have on self and others."
),
(
2, 23,
"Ensures that own work plans and priorities fit with the needs of others involved in delivering services. Demonstrates flexibility and sensitivity and remains assertive in pursuing service goals.Builds and managed own personal brand both internally and externally."
),
(
2, 24,
"Encouragesa broad range of formal and informal learning opportunities, supporting development and career management by putting self forward for challenging assignments and projects which will develop strengths and address development areas. Seeks and provides constructive feedback from a variety of sources to support personal growth."
),
(
2, 25,
"Acts as a role model for others in demonstrating integrity and inclusiveness in all aspects of own work. Challenges where organisational values are compromised."
),
(
2, 26,
"Provides others with clear purpose and direction. Helping others in developing their roles and responsibilities.Balances the long-term business strategy against short term deliverables."
),
(
2, 27,
"Creates a supportive environment which encourages others to express diverse opinions and engage in decision making. Constructively challenges suggestions and reconciles conflicting views.Balanced and constructive feedback is provided with a view to support change and improvement."
),
(
2, 28,
"Works with others to set and monitor performance standards, addressing areas where performance objectives are not achieved.Broadens knowledge about teams for Talent development, retention and succession planning."
),
(
2, 29,
"Uses networks to bring individuals and groups together to share information and resources and to achieve goals. Builds and maintains relationships with a range of individuals involved in delivering the service. Manages sensitivities between individuals and groups."
),
(
2, 30,
"Helps lead others towards common goals, providing clear objectives and offering appropriate support. Shows awareness of team dynamics and acts to promote effective team working.Appreciates the efforts of others.Builds a motivated team to be open, inclusive, honest and collaborative."
),
(
2, 31,
"dentifies the external and internal drivers of change. Positively role models and communicates the rationale for change to others."
),
(
2, 32,
"Obtains and analyses information about services to inform future direction. Supports and encourages others to use knowledge and evidence to inform decisions about the future of services.Acts as a positive role model for innovation. Encourages dialogue and debate in the development of new ideas with a wide range of people."
),
(
2, 33,
"Involves key people and groups in making decisions. Actively engages in formal and informal decision-making processes about the future of services."
),
(
2, 34,
"Evaluates and embeds approaches and working methods which have proved to be effective into the working practices of teams and individuals. "
),
(
2, 35,
"Assesses and brings together views and perspectives of self and others to support shaping the strategy.Ensures relevant issues relating to immediate business area are effectively fed into strategy and big pictureconsiderations."
),
(
2, 36,
"Strives to understand the key drivers and motivations of strategic objectives and the role in which own area supports these."
),
(
2, 37,
"Establishes clear responsibilities and roles within teams to support delivering elements of the strategy while holding people to account. Identifies, nurtures, and leads talent effectively to help meet future strategic objectives. "
),
(
2, 38,
"Supports and inspires others responsible for delivering strategic and operational plans, helping them to overcome obstacles and challenges and remain focused. Supports shaping and redirecting KPI’s across teams. "
),
(
2, 39,
"Understands the commercial drivers that will influence our customers, stakeholders, and suppliers and how these can be used to achieve mutually beneficial outcomes and potential growth opportunities for Kainos. Works effectively with customers, colleagues, and stakeholders to understand their requirements and implement innovative and commercial solutions that will drive efficiency and enable growth. "
),
(
2, 40,
"Takes ownership and responsibility for specific bid production and proposal creation opportunities, leading and motivating a team to create innovative and differentiating solutions that address customer needs. Identifying and maturing new opportunities with customers, helping them in their thought process and positioning Kainos to undertake the work through a consultative ‘trusted advisor’ approach. Contributes to business development strategy for accounts, territories, offerings or practices as well as execution to achieve assigned news business targets."
),
(
2, 41,
"Identifies alternative cost-effective methods to achieve desired outcomes through considered decisions on spend. Creates and effectively articulates robust business cases with support. Does not avoid the difficult conversations with internal and external customers. "
),
(
2, 42,
"Advocates for Kainos, and constantly operates in alignment with the company values and ambition. Manging risk within discipline area/teams to ensure no reputational damage to the brand."
),
(
2, 43,
"Champions alignment to company policies and procedures in everyday work and decision making. Delivers what is expected against each business process. "
),
(
2, 44,
"Communicates the vision and engages others outside of immediate teams effectively and checks understanding. Translates the vision into meaningful messages that empowers direct reports."
),
(
2, 45,
"Articulates opinions and adopts several ways to gain support and influence across diverse teams with the aim of securing improvements. "
),
(
2, 46,
"Focuses self and others on achieving changes to systems and processes which will lead to improved services."
),
(
2, 47,
"Aware and proactive to what is happening in the wider business to identify opportunities for collaboration to drive benefits for Kainos.Customer focused and achieves high levels of customer satisfaction."
),

-- Leadership Level Indicators
(
1, 22,
"An exemplary role model of self-awareness and welcomes feedback openly. A strong advocate and voice for building a culture of self-development and seen to set the tone for effective leadership at a senior level."
),
(
1, 23,
"Confident and independent in own personal impact and recognises an influence on others beyond immediate teams. Goals are aligned to strategic objectives and Kainos values. Champions self and others for equality, diversity, and inclusion."
),
(
1, 24,
"Role models continuous learning and self-development, evaluating own effectiveness and growth and planning further development. Progresses in the right direction for self and Kainos through strong personal ownership."
),
(
1, 25,
"Assures standards of integrity are maintained across the business and communicates the importance of always adopting an ethical and inclusive approach."
),
(
1, 26,
"Inspires and supports the business to mobilise diverse teams that are committed to and aligned with organisational values and goals. Engages with influencers to deliver joined up services."
),
(
1, 27,
"Creates systems which encourage contribution throughout the organisation. Invites contribution from different regions, sectors, and business units to bring about consistent improvements."
),
(
1, 28,
"Successfully accountable for the direction of the wider business on creating performance standards and recognises business areas that require focus and adapts approach to meet the demands and needs of employees, customers, and services."
),
(
1, 29,
"Works across boundaries creating networks which facilitate high levels of collaboration within and across organisations and sectors. Builds and maintains sustainable strategic alliances across the system and other sectors. Has high impact when interacting with others at all levels."
),
(
1, 30,
"Contributes and leads senior teams. Enables others to take on leadership responsibilities, building high level leadership capability and capacity from a diverse range of backgrounds."
),
(
1, 31,
"Synthesises knowledge from a broad range of sources to identify future challenges and imperatives that will create the need for change. Influences the context for change in the best interests of our people, our customers,and our business."
),
(
1, 32,
"Uses knowledge, evidence,and experience of national and international developments in technology and our consumers to influence the future development of Kainos and our services.Drives a culture of innovation and improvement. Integrates radical and innovative approaches into strategic plans to make Kainos world class in the provision of technology services."
),
(
1, 33,
"Ensures that corporate decision-making is conducted with appropriate rigour and takes account of the full range of factors impinging on the future direction of the organisation and the wider business. Can operate without all the facts. Takes unpopular decisions when in the best interests of Kainos in the long term."
),
(
1, 34,
"Synthesises learning arising from changes which have been introduced and incorporates these into strategic plans. Shares learning with the wider business."
),
(
1, 35,
"Takes account of the culture, history, and long-term strategic direction for Kainos. Critically reviewing relevant thinking, ideas and best practice and applies whole systems thinking to conceptualise a strategy in line with the vision."
),
(
1, 36,
"Integrates the views of a broad range of stakeholders to develop a coherent, joined up and sustainable strategy for own domain.Assesses organisational readiness for change. Manages the risks, political sensitivities and environmental uncertainties involved."
),
(
1, 37,
"Responds constructively to challenge. Puts systems, structures, processes, resources, and plans in place to deliver the strategy. Establishes accountabilities and holds people in local, regional, and national structures to account for jointly delivering strategic and operational plans. Demonstrates flexibility when change is required. "
),
(
1, 38,
"Enables and supports the conditions and culture needed to sustain changes integral to the successful delivery of the strategy. Keeps momentum alive by reinforcing key messages, monitoring progress, and recognising where the strategy has been embraced by others. Evaluates outcomes and uses learnings to adapt strategic and operational plans. Aligns KPI’s across the business and reports on progress to ensure continued progress. "
),
(
1, 39,
"Develops teams focussed on maximising commercial value for Kainos who are focused on pace, execution, and decisiveness. Builds a culture of challenging discretionary spend to ensure alignment to Kainos and organisational objectives, as well as seeking and driving opportunities that will deliver increased growth and profit. "
),
(
1, 40,
"Identifies and leads significant new business streams that positively deliver growth for Kainos, for example, running a major practice or region and responsible for generating new business that will achieve agreed targets and OKRs. Leading and inspiring a team with devolved responsibility to deliver success. With an entrepreneurial mindset, yet balanced against robust business plans, creating and driving new business initiatives that support growth, staff development and market differentiation."
),
(
1, 41,
"Independently accountable for leading and executing the business plan while building commercial acumen across the wider business and our customers, including introducing incremental and ongoing change and innovation to drive improvements that impact profitability. "
),
(
1, 42,
"Ensure that commercial considerations and risks are fully considered when defining strategic priorities and plans. Seeks opportunities to expand the Kainos brand through accountability for leading company wide initiatives that will bolster the Kainos brand positively. Confidence to take calculated and assessed risks to support growth objectives. "
),
(
1, 43,
"Creates and establishes high performance and effective working across Kainos by leading consistent application of processes and setting new direction for process including constructive challenge in the interests of continuous improvement. "
),
(
1, 44,
"Develops and clearly communicates the vision and strategy for own business area in a way that engages and empowers others. Uses enthusiasm and energy to inspire others and encourage joint ownership of the vision. Anticipates and constructively addresses challenge."
),
(
1, 45,
"Actively participates in and leads on debates about the future of Kainos and our related services. Manages political interests, balancing tensions between organisational aspirations and the wider environment. Shapes and influences local, regional,and national priorities and agendas."
),
(
1, 46,
"Inspires others to take bold action and make important advances in how services are delivered. Removes organisational obstacles to change and creates new structures and processes to facilitate transformation."
),
(
1, 47,
"Proactively creates, maintains,and promotes a strong network of connections with colleagues across Kainos and external stakeholders. Creates an inclusive environment while maximising opportunities for teams to engage with a variety of partners and stakeholders."
),

-- Executive Responsibilities
(
9, 22,
"Uses sophisticated tools and sources to continuously learn about own leadership impact across the wider business community and improve personal effectiveness as a senior leader. Understands how pressures associated with carrying out a high-profile role impacts personally and own performance."
),
(
9, 23,
"Remains focused on the wider Kainos strategic goals when faced with competing and, at times, conflicting demands arising from differing priorities. Identifies where the need to personally get involved to achieve the most benefit for the wider organisation."
),
(
9, 24,
"Develops through systematically scanning the external environment and exploring leading edge thinking and best practice.Applies learning to build and refresh the business. Treats challenge as a positive force for improvement."
),
(
9, 25,
"Actively develops and protects Kainos through promoting and role modelling our values and competencies to achieve desired culture. Ensuring the business priorities maximise sustainability, equality, and diversity."
),
(
9, 26,
"Removes barriers to preventing business improvement and innovation across Kainos. Drives innovation and diversity and enables inclusive environments while challenging and empowering others to lead."
),
(
9, 27,
"Improves company performance through engaging the company’s purpose both internally and externally."
),
(
9, 28,
"Promotes an inclusive culture that enables people to perform to their best, ensuring that appropriate performance management systems are in place and that performance data is systematically evaluated and fed into future plans."
),
(
9, 29,
"Takes a strategic and objective perspective to identifying potential and capability needs of Kainos, identifying and nurturing future leaders and innovators."
),
(
9, 30,
"Drives and delivers a culture that emphasises continuous improvement and effective team working relationships. Not afraid to lead in challenging times and make the hard decisions and communicate to the whole business with confidence and integrity."
),
(
9, 31,
"Develops an in-depth insight into the dynamics and issues surrounding Kainos including political, economic, social, environmental, technological,and legal impacts.Fully understands the impact of change on organisation culture and proactively seeks feedback and ideas from employees and stakeholders while also empowering leaders."
),
(
9, 32,
"Creates an environment that fosters knowledge sharing and innovation, demonstrating the courage to take risks to enable significant improvements and empowering others to do so where appropriate.Creates a culture of flexibility and responsiveness, mobilising Kainos to respond quickly to changing priorities."
),
(
9, 33,
"Fully engages and utilises external experts wider experience and knowledge to support strategic decision making. Navigates and balances external pressures while empowering leaders and principals to shape Kainos strategy and business priorities. "
),
(
9, 34,
"Creates a culture of transparency and honesty when it comes to evaluating impact challenges and successes. Fostering an ethos of one Kainos. Scanning the broad internal and external environment and taking account of wider impact to develop long term implementation strategies that maximise opportunities to add value to customers and support sustainable growth. "
),
(
9, 35,
"Sets, maintains, and ensures a clear direction for Kainos with highly focused priorities and results by articulating short, medium-and long-term strategies focused on adding real value to Kainos and our customers"
),
(
9, 36,
"Creates joined up strategies and plans which help put into practice and support Kainos vision and long-term direction which are challenging yet achievable.Based upon external economic, social, technology and environmental trends."
),
(
9, 37,
"Enables the whole company to remain focused on business priorities, irrespective of challenges. Swiftly refocuses Kainos on new priorities as changing situations dictate. Models personal resilience and accountability for achieving strategic priorities and results. Balances challenging operational and strategic priorities."
),
(
9, 38,
"Establishes transparency and trust where results are discussed openly. Encourages and inspires the organisation to energise delivery, while driving a performance culture across Kainos and achieve results through others. Monitors and evaluates strategic outcomes, adjusting to ensure sustainability of the strategy and ongoing communication and engagement."
),
(
9, 39,
"Role models leadership, influencing and accountability in relation to commerciality and risks to create and deliver the corporate plan. Creates and embeds a culture of commercial awareness and solid business acumen, ensuring that all employees understand the commercial environment in which we operate and can pro- actively play a part in delivering change, efficiency and growth."
),
(
9, 40,
"Role model for others to follow. Inspires staff across the whole organisation to contribute to BD and celebrate its success. Champions BD, promoting Kainos at levels including internal ‘all hands’, partners, investors, customers and senior figureheads within regions. Takes responsibility for strategic investment decisions, for example, acquisitions, new markets, new regions."
),
(
9, 41,
"Draws on insights of current and future marketplace dynamics to seize opportunities to stimulate sustainable growth. Drives and delivers a continuous pipeline of innovation through our business models, products, and services ensuring sustainable commercial growth. "
),
(
9, 42,
"Makes and encourages strategic investment decisions, challenging to ensure appropriate levels of expenditure and maximise return. Demonstrates transparency both in terms of key investment decisions and appropriate use of resources. Initiates and build strategic commercial relationships with the shareholder, partners, customers, and competitors to deliver results."
),
(
9, 43,
"Sets clear direction against all processes and policies and ensures we continue to develop and adapt to the ever-evolving risks and changes to the needs of the whole business. "
),
(
9, 44,
"Actively engages key stakeholders in creating a bold, innovative, shared vision which reflects the future needs and aspirations of the whole company and the future direction of Kainos. Thinks broadly and aligns the vision to the Kainos values and communicates gaining buy in."
),
(
9, 45,
"Takes action to shape and implement a vision for the future of Kainos and our customers while sharing leadership and empowering others to contribute and collaborate."
),
(
9, 46,
"Empowers senior leaders within Kainos to drive change and transformation while providing direction and creating a collaborative environment for sustained change."
),
(
9, 47,
"Builds a strong network of collaborative relationships and partnerships globally to achieve our objectives, whist supporting wider stakeholder agendas. Utilises the experience and input of external partners, non-executive directors, and industry experts to improve effectiveness."
);