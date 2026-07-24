USE covid_tracker;

DROP TABLE IF EXISTS covid_cases_audit;

CREATE TABLE covid_cases_audit (
    audit_id       INT AUTO_INCREMENT PRIMARY KEY,
    case_id        INT NOT NULL,
    country        VARCHAR(100) NOT NULL,
    report_date    DATE NOT NULL,
    old_confirmed  BIGINT,
    new_confirmed  BIGINT,
    old_deaths     BIGINT,
    new_deaths     BIGINT,
    old_recovered  BIGINT,
    new_recovered  BIGINT,
    changed_at     DATETIME NOT NULL
);

DROP TRIGGER IF EXISTS trg_covid_cases_before_update;

DELIMITER $$

CREATE TRIGGER trg_covid_cases_before_update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit (
        case_id, country, report_date,
        old_confirmed, new_confirmed,
        old_deaths, new_deaths,
        old_recovered, new_recovered,
        changed_at
    )
    VALUES (
        OLD.case_id, OLD.country, OLD.report_date,
        OLD.confirmed, NEW.confirmed,
        OLD.deaths, NEW.deaths,
        OLD.recovered, NEW.recovered,
        NOW()
    );
END $$

DELIMITER ;

UPDATE covid_cases
SET confirmed = confirmed + 1000, deaths = deaths + 10, recovered = recovered + 900
WHERE country = 'Brazil' AND report_date = '2026-07-22';

SELECT * FROM covid_cases_audit ORDER BY changed_at DESC;
