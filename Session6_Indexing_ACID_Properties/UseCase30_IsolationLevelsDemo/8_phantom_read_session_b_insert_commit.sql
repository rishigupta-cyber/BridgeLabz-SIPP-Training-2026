USE covid_tracker6;

START TRANSACTION;

INSERT INTO covid_cases (country, report_date, confirmed, deaths, recovered, population, infection_rate)
VALUES ('Nigeria', '2026-07-21', 6247000, 92080, 6107000, 220000000, 2.839545);

COMMIT;
