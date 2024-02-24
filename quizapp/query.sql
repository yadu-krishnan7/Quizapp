 CREATE TABLE answer (
        answer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        correct VARCHAR(255)
    );

     CREATE TABLE options (
        option_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        OptionA VARCHAR(255),
        OptionB VARCHAR(255),
        OptionC VARCHAR(255)
    );
 CREATE TABLE question (
     question_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     Question VARCHAR(255),
     options_id BIGINT,
     ans_id BIGINT,
     FOREIGN KEY (options_id) REFERENCES option(option_id),
     FOREIGN KEY (ans_id) REFERENCES answer(answer_id)
 );

 INSERT INTO answer (correct)
     VALUES ('A) Washington D.C.');

 INSERT INTO answer (correct)
     VALUES ('A) Paris');

 INSERT INTO answer (correct)
     VALUES ('C) Tokyo');

 INSERT INTO answer (correct)
     VALUES ('C) Canberra');

 INSERT INTO answer (correct)
     VALUES ('C) Brasilia');

 INSERT INTO options (OptionA, OptionB, OptionC)
     VALUES ('A) Washington D.C.', 'B) New York City', 'C) Los Angeles');

 INSERT INTO options (OptionA, OptionB, OptionC)
     VALUES ('A) Paris', 'B) Berlin', 'C) Madrid');

 INSERT INTO options (OptionA, OptionB, OptionC)
     VALUES ('A) Beijing', 'B) Seoul', 'C) Tokyo');

 INSERT INTO options (OptionA, OptionB, OptionC)
     VALUES ('A) Sydney', 'B) Melbourne', 'C) Canberra');

 INSERT INTO options (OptionA, OptionB, OptionC)
     VALUES ('A) Rio de Janeiro', 'B) Sao Paulo', 'C) Brasilia');


insert into question(question,options_id,ans_id) values('What is the capital of the United States?',1,1);

insert into question(question,options_id,ans_id) values('Which city is the capital of France?',2,2);

insert into question(question,options_id,ans_id) values('What is the capital of Japan?',3,3);

insert into question(question,options_id,ans_id) values('Which city serves as the capital of Australia?',4,4);

insert into question(question,options_id,ans_id) values('What is the capital of Brazil?',5,5);