USE covid_tracker3;

SELECT co.country_name, cc.report_date, cc.confirmed
FROM covid_cases cc
INNER JOIN countries co ON cc.country_id = co.country_id
WHERE cc.report_date = '2026-07-22'
ORDER BY cc.confirmed DESC
LIMIT 1;
