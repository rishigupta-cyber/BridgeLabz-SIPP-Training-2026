USE covid_tracker;

DROP FUNCTION IF EXISTS CalculateRecoveryRate;

DELIMITER $$

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(6,3)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_confirmed BIGINT DEFAULT 0;
    DECLARE v_recovered BIGINT DEFAULT 0;
    DECLARE v_rate DECIMAL(6,3) DEFAULT 0.000;

    SELECT confirmed, recovered
    INTO v_confirmed, v_recovered
    FROM covid_cases
    WHERE country = p_country
      AND report_date = p_date
    LIMIT 1;

    IF v_confirmed IS NULL OR v_confirmed = 0 THEN
        RETURN 0.000;
    END IF;

    SET v_rate = (v_recovered / v_confirmed) * 100;

    RETURN v_rate;
END $$

DELIMITER ;

SELECT CalculateRecoveryRate('Brazil', '2026-07-22') AS brazil_recovery_rate;
SELECT CalculateRecoveryRate('United States', '2026-07-22') AS us_recovery_rate;

SELECT
    country,
    report_date,
    CalculateRecoveryRate(country, report_date) AS recovery_rate_pct,
    CalculateMortalityRate(country, report_date) AS mortality_rate_pct
FROM covid_cases
WHERE report_date = '2026-07-22';
