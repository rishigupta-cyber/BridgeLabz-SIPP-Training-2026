CREATE DATABASE IF NOT EXISTS covid_tracker;
USE covid_tracker;

DROP TABLE IF EXISTS covid_cases;

CREATE TABLE covid_cases (
    case_id     INT AUTO_INCREMENT PRIMARY KEY,
    country     VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed   BIGINT NOT NULL DEFAULT 0,
    deaths      BIGINT NOT NULL DEFAULT 0,
    recovered   BIGINT NOT NULL DEFAULT 0,
    UNIQUE KEY uq_country_date (country, report_date)
);

INSERT INTO covid_cases (country, report_date, confirmed, deaths, recovered) VALUES
('India',         '2026-07-20', 45000000, 530000, 44300000),
('India',         '2026-07-21', 45010000, 530200, 44312000),
('India',         '2026-07-22', 45021000, 530450, 44325000),
('United States', '2026-07-20', 103500000, 1180000, 101800000),
('United States', '2026-07-21', 103520000, 1180300, 101830000),
('United States', '2026-07-22', 103545000, 1180600, 101865000),
('Brazil',        '2026-07-20', 38500000, 710000, 37600000),
('Brazil',        '2026-07-21', 38512000, 710150, 37610000),
('Brazil',        '2026-07-22', 38525000, 710300, 37622000);
