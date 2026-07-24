USE covid_tracker6;

ROLLBACK;

SELECT confirmed
FROM covid_cases
WHERE country = 'India' AND report_date = '2026-07-22';
