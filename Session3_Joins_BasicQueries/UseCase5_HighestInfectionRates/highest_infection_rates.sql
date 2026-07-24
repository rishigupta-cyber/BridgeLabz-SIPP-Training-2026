USE covid_tracker3;

SELECT co.country_name, cc.confirmed, co.population,
    (cc.confirmed / co.population) * 100 AS infection_rate
FROM covid_cases cc
INNER JOIN countries co ON cc.country_id = co.country_id
WHERE cc.report_date = '2026-07-22'
ORDER BY infection_rate DESC;
