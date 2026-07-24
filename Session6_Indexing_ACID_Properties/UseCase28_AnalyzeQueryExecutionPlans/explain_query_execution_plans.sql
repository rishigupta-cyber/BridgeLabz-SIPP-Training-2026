USE covid_tracker6;

EXPLAIN SELECT cont.continent_name, SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries co ON cc.country = co.country_name
INNER JOIN continents cont ON co.continent_id = cont.continent_id
WHERE cc.report_date = '2026-07-22'
GROUP BY cont.continent_name
ORDER BY total_deaths DESC;

CREATE INDEX idx_countries_continent_id ON countries (continent_id);

CREATE INDEX idx_countries_country_name ON countries (country_name);

EXPLAIN SELECT cont.continent_name, SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries co ON cc.country = co.country_name
INNER JOIN continents cont ON co.continent_id = cont.continent_id
WHERE cc.report_date = '2026-07-22'
GROUP BY cont.continent_name
ORDER BY total_deaths DESC;

EXPLAIN FORMAT=JSON SELECT cont.continent_name, SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries co ON cc.country = co.country_name
INNER JOIN continents cont ON co.continent_id = cont.continent_id
WHERE cc.report_date = '2026-07-22'
GROUP BY cont.continent_name
ORDER BY total_deaths DESC;
