CREATE DATABASE IF NOT EXISTS covid_tracker6;
USE covid_tracker6;

DROP TABLE IF EXISTS vaccine_administration;
DROP TABLE IF EXISTS vaccine_shipments;
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
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed BIGINT NOT NULL DEFAULT 0,
    deaths BIGINT NOT NULL DEFAULT 0,
    recovered BIGINT NOT NULL DEFAULT 0,
    population BIGINT NOT NULL,
    infection_rate DECIMAL(10,6) NOT NULL DEFAULT 0
);

CREATE TABLE vaccine_shipments (
    shipment_id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    shipment_date DATE NOT NULL,
    vaccine_name VARCHAR(100) NOT NULL,
    doses_shipped BIGINT NOT NULL CHECK (doses_shipped >= 0)
);

CREATE TABLE vaccine_administration (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    admin_date DATE NOT NULL,
    doses_administered BIGINT NOT NULL CHECK (doses_administered >= 0)
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

INSERT INTO covid_cases (country, report_date, confirmed, deaths, recovered, population, infection_rate) VALUES
('India', '2026-07-20', 45000000, 530000, 44300000, 1400000000, 3.214286),
('India', '2026-07-21', 45010000, 530200, 44312000, 1400000000, 3.215000),
('India', '2026-07-22', 45021000, 530450, 44325000, 1400000000, 3.215786),
('United States', '2026-07-20', 103500000, 1180000, 101800000, 335000000, 30.895522),
('United States', '2026-07-21', 103520000, 1180300, 101830000, 335000000, 30.901493),
('United States', '2026-07-22', 103545000, 1180600, 101865000, 335000000, 30.908955),
('Brazil', '2026-07-20', 38500000, 710000, 37600000, 216000000, 17.824074),
('Brazil', '2026-07-21', 38512000, 710150, 37610000, 216000000, 17.829630),
('Brazil', '2026-07-22', 38525000, 710300, 37622000, 216000000, 17.835648),
('Germany', '2026-07-20', 39100000, 178300, 38700000, 84000000, 46.547619),
('Germany', '2026-07-21', 39110000, 178400, 38710000, 84000000, 46.559524),
('Germany', '2026-07-22', 39120000, 178500, 38720000, 84000000, 46.571429),
('Nigeria', '2026-07-20', 6240000, 92000, 6100000, 220000000, 2.836364),
('Nigeria', '2026-07-21', 6245000, 92050, 6105000, 220000000, 2.838636),
('Nigeria', '2026-07-22', 6250000, 92100, 6110000, 220000000, 2.840909);

INSERT INTO vaccine_shipments (country, shipment_date, vaccine_name, doses_shipped) VALUES
('India', '2026-07-15', 'Covaxin', 500000),
('United States', '2026-07-15', 'Pfizer', 750000);

INSERT INTO vaccine_administration (country, admin_date, doses_administered) VALUES
('India', '2026-07-16', 480000),
('United States', '2026-07-16', 720000);
