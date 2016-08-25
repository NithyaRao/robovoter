use robovoter;

set FOREIGN_KEY_CHECKS = 0;
truncate table voters;
truncate table candidates;
truncate table elections;
truncate table candidates_voters;

INSERT INTO `robovoter`.`elections` (`name`, `created_at`, `updated_at`)
VALUES
  ('November 2017', '2001-01-11', '2001-01-11');

INSERT INTO `robovoter`.`candidates` (`name`, `position`, `state`, `party`, `election_id`, `created_at`, `updated_at`)
VALUES
  ('Hilary Clinton', 'PRESIDENT', 'IA', 'DEMOCRATIC', '1', '2001-01-11', '2001-01-11'),
  ('Donald Trump', 'PRESIDENT', 'ND', 'REPUBLICAN', '1', '2001-01-11', '2001-01-11'),
  ('Curly Joe', 'GOVERNOR', 'IL', 'REPUBLICAN', '1', '2001-01-11', '2001-01-11'),
  ('Bobbi Joe', 'GOVERNOR', 'IL', 'DEMOCRATIC', '1', '2001-01-11', '2001-01-11'),
  ('Joey Bimbato', 'SENATOR', 'IND', 'DEMOCRATIC', '1', '2001-01-11', '2001-01-11'),
  ('Alice Smith', 'SENATOR', 'IND', 'DEMOCRATIC', '1', '2001-01-11', '2001-01-11');

INSERT INTO `robovoter`.`voters` (`name`, `age`, `gender`, `ethnicity`, `state`, `party`, `created_at`, `updated_at`)
VALUES
('Bob', '21','M','CAUCASIAN','IL','DEMOCRATIC','2001-01-11', '2001-01-11'),
('Jill', '24','F','CAUCASIAN','IND','DEMOCRATIC','2001-01-11', '2001-01-11'),
('John', '35','M','ASIAN','SD','REPUBlICAN','2001-01-11', '2001-01-11'),
('Jack', '39','M','AFRICANAMERICAN','ND','DEMOCRATIC','2001-01-11', '2001-01-11'),
('Ann', '51','F','CAUCASIAN','ND','REPUBLICAN','2001-01-11', '2001-01-11'),
('Sally', '60','F','CAUCASIAN','IL','DEMOCRATIC','2001-01-11', '2001-01-11');



-- INSERT INTO `robovoter`.`candidates_voters` (`candidate_id`, `voter_id`)
-- VALUES