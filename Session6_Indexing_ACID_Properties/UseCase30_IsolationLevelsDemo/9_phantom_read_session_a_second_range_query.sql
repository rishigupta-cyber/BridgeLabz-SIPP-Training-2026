USE covid_tracker6;

SELECT COUNT(*)
FROM covid_cases
WHERE report_date BETWEEN '2026-07-20' AND '2026-07-22'
AND country = 'Nigeria';

COMMIT;
