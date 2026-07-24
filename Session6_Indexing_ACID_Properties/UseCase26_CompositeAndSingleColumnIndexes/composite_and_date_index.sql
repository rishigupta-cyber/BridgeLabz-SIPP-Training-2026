USE covid_tracker6;

CREATE INDEX idx_country_date ON covid_cases (country, report_date);

CREATE INDEX idx_report_date ON covid_cases (report_date);

SHOW INDEX FROM covid_cases;

EXPLAIN SELECT confirmed, deaths, recovered
FROM covid_cases
WHERE country = 'India' AND report_date = '2026-07-22';

EXPLAIN SELECT country, SUM(deaths)
FROM covid_cases
WHERE report_date = '2026-07-22'
GROUP BY country;
