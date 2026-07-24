USE covid_tracker6;

CREATE INDEX idx_infection_rate_covering ON covid_cases (report_date, infection_rate DESC, country, confirmed);

EXPLAIN SELECT country, confirmed, infection_rate
FROM covid_cases
WHERE report_date = '2026-07-22'
ORDER BY infection_rate DESC
LIMIT 10;

SELECT country, confirmed, infection_rate
FROM covid_cases
WHERE report_date = '2026-07-22'
ORDER BY infection_rate DESC
LIMIT 10;
