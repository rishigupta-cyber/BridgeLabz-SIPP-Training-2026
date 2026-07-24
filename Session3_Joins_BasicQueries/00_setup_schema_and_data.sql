CREATE DATABASE IF NOT EXISTS covid_tracker3;
USE covid_tracker3;

DROP TABLE IF EXISTS covid_vaccines;
DROP TABLE IF EXISTS covid_deaths;
DROP TABLE IF EXISTS covid_cases;
DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS continents;

CREATE TABLE continents (
    continent_id INT PRIMARY KEY,
    continent_name VARCHAR(50) NOT NULL
);

CREATE TABLE countries (
    country_id INT PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL,
    population BIGINT NOT NULL,
    continent_id INT NOT NULL,
    FOREIGN KEY (continent_id) REFERENCES continents(continent_id)
);

CREATE TABLE covid_cases (
    case_id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    report_date DATE NOT NULL,
    confirmed BIGINT NOT NULL DEFAULT 0,
    deaths BIGINT NOT NULL DEFAULT 0,
    FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

CREATE TABLE covid_deaths (
    death_id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    report_date DATE NOT NULL,
    deaths BIGINT NOT NULL DEFAULT 0,
    FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

CREATE TABLE covid_vaccines (
    vaccine_id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    vaccination_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

INSERT INTO continents (continent_id, continent_name) VALUES
(1, 'Asia'),
(2, 'North America'),
(3, 'South America'),
(4, 'Europe'),
(5, 'Africa');

INSERT INTO countries (country_id, country_name, population, continent_id) VALUES
(1, 'India', 1400000000, 1),
(2, 'United States', 335000000, 2),
(3, 'Brazil', 216000000, 3),
(4, 'Germany', 84000000, 4),
(5, 'Nigeria', 220000000, 5);

INSERT INTO covid_cases (country_id, report_date, confirmed, deaths) VALUES
(1, '2026-07-22', 45021000, 530450),
(2, '2026-07-22', 103545000, 1180600),
(3, '2026-07-22', 38525000, 710300),
(4, '2026-07-22', 39120000, 178500),
(5, '2026-07-22', 6250000, 92100);

INSERT INTO covid_deaths (country_id, report_date, deaths) VALUES
(1, '2026-07-20', 200),
(1, '2026-07-21', 220),
(1, '2026-07-22', 250),
(2, '2026-07-20', 380),
(2, '2026-07-21', 300),
(2, '2026-07-22', 300),
(3, '2026-07-20', 150),
(3, '2026-07-21', 150),
(3, '2026-07-22', 150),
(4, '2026-07-20', 40),
(4, '2026-07-21', 45),
(4, '2026-07-22', 50),
(5, '2026-07-20', 30),
(5, '2026-07-21', 35),
(5, '2026-07-22', 40);

INSERT INTO covid_vaccines (country_id, vaccination_status) VALUES
(1, 'Fully Vaccinated'),
(2, 'Fully Vaccinated'),
(3, 'Partially Vaccinated'),
(4, 'Fully Vaccinated');
