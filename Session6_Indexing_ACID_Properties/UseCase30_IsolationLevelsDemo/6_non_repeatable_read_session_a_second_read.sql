USE covid_tracker6;

SELECT confirmed
FROM covid_cases
WHERE country = 'Brazil' AND report_date = '2026-07-22';

COMMIT;
