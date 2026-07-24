USE covid_tracker3;

SELECT report_date, AVG(deaths) AS avg_daily_deaths
FROM covid_deaths
GROUP BY report_date
ORDER BY report_date;
