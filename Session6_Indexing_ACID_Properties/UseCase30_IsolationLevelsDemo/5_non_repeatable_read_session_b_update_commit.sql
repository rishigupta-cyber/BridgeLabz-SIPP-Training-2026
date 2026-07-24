USE covid_tracker6;

START TRANSACTION;

UPDATE covid_cases
SET confirmed = 38600000
WHERE country = 'Brazil' AND report_date = '2026-07-22';

COMMIT;
