SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS login (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR,
  email VARCHAR,
  password VARCHAR,
  birthday TIMESTAMP NULL DEFAULT NULL
);

--USER INFO------------------------------------------------
CREATE TABLE IF NOT EXISTS user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  firstName VARCHAR,
  lastName VARCHAR,
  gender VARCHAR,
  tagLine VARCHAR,
  --foreign keys
  loginId INTEGER
);

--PROFILE INFO------------------------------------------------
CREATE TABLE IF NOT EXISTS profile (
  id INT PRIMARY KEY AUTO_INCREMENT,
  profilePicture VARCHAR,
  aboutMe VARCHAR,
  --foreign keys
  userId INTEGER
);

CREATE TABLE IF NOT EXISTS job (
  id INT PRIMARY KEY AUTO_INCREMENT,
  job VARCHAR,
  position VARCHAR,
  description VARCHAR,
);

CREATE TABLE IF NOT EXISTS education (
  id INT PRIMARY KEY AUTO_INCREMENT,
  education VARCHAR
);

CREATE TABLE IF NOT EXISTS aboutMe (
  id INT PRIMARY KEY AUTO_INCREMENT,
  about VARCHAR
);

--GLOBAL TABLES------------------------------------------------
CREATE TABLE IF NOT EXISTS interests (
  id INT PRIMARY KEY AUTO_INCREMENT,
  interest VARCHAR
);

CREATE TABLE IF NOT EXISTS singles (
  id INT PRIMARY KEY AUTO_INCREMENT,
);

CREATE TABLE IF NOT EXISTS dateIdeas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  dateTitle VARCHAR,
  description VARCHAR
);

CREATE TABLE IF NOT EXISTS categories (
  id INT PRIMARY KEY AUTO_INCREMENT,
  category VARCHAR,
);

--JOIN TABLES:USER ------------------------------------------------
CREATE TABLE IF NOT EXISTS users_singles (
  id INT PRIMARY KEY AUTO_INCREMENT,
  --foreign keys
  userId  INTEGER,
  singlesId  INTEGER
);

CREATE TABLE IF NOT EXISTS user_interests (
  id INT PRIMARY KEY AUTO_INCREMENT,
    --foreign keys
  interestsId  INTEGER,
  userId  INTEGER
);

--JOIN TABLES:PROFILE------------------------------------------------
CREATE TABLE IF NOT EXISTS profile_job (
  id INT PRIMARY KEY AUTO_INCREMENT,
    --foreign keys
  profileId  INTEGER,
  jobId  INTEGER
);

CREATE TABLE IF NOT EXISTS profile_education (
  id INT PRIMARY KEY AUTO_INCREMENT,
    --foreign keys
  profileId  INTEGER,
  educationId  INTEGER
);

CREATE TABLE IF NOT EXISTS profile_aboutMe (
  id INT PRIMARY KEY AUTO_INCREMENT,
    --foreign keys
  profileId  INTEGER,
  aboutMeId  INTEGER
);

--JOIN TABLES:INTERESTS ------------------------------------------------
CREATE TABLE IF NOT EXISTS interests_categories (
  id INT PRIMARY KEY AUTO_INCREMENT,
    --foreign keys
  interestsId  INTEGER,
  categoriesId  INTEGER
);
