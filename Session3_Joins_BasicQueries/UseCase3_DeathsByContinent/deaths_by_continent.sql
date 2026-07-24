USE covid_tracker3;

SELECT cont.continent_name, SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries co ON cc.country_id = co.country_id
INNER JOIN continents cont ON co.continent_id = cont.continent_id
GROUP BY cont.continent_name
ORDER BY total_deaths DESC;
