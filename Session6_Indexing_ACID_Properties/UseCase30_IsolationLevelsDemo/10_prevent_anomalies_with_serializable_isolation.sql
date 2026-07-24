USE covid_tracker6;

SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

START TRANSACTION;

SELECT COUNT(*)
FROM covid_cases
WHERE report_date BETWEEN '2026-07-20' AND '2026-07-22'
AND country = 'Germany';

SELECT confirmed
FROM covid_cases
WHERE country = 'Germany' AND report_date = '2026-07-22';

COMMIT;
