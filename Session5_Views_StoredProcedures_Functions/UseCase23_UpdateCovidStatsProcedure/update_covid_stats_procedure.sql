USE covid_tracker;

DROP PROCEDURE IF EXISTS UpdateCovidStats;

DELIMITER $$

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_new_confirmed BIGINT,
    IN p_new_deaths BIGINT,
    IN p_new_recovered BIGINT
)
BEGIN
    DECLARE v_exists INT DEFAULT 0;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    SELECT COUNT(*) INTO v_exists
    FROM covid_cases
    WHERE country = p_country AND report_date = p_date;

    IF v_exists > 0 THEN
        UPDATE covid_cases
        SET confirmed = p_new_confirmed,
            deaths    = p_new_deaths,
            recovered = p_new_recovered
        WHERE country = p_country
          AND report_date = p_date;
    ELSE
        INSERT INTO covid_cases (country, report_date, confirmed, deaths, recovered)
        VALUES (p_country, p_date, p_new_confirmed, p_new_deaths, p_new_recovered);
    END IF;

    COMMIT;
END $$

DELIMITER ;

CALL UpdateCovidStats('India', '2026-07-22', 45050000, 530900, 44360000);
SELECT * FROM covid_cases WHERE country = 'India' AND report_date = '2026-07-22';

CALL UpdateCovidStats('India', '2026-07-23', 45070000, 531100, 44390000);
SELECT * FROM covid_cases WHERE country = 'India' ORDER BY report_date;
