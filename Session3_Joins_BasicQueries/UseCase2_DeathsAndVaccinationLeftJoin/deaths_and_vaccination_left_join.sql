USE covid_tracker3;

SELECT co.country_name, cd.report_date, cd.deaths, cv.vaccination_status
FROM covid_deaths cd
INNER JOIN countries co ON cd.country_id = co.country_id
LEFT JOIN covid_vaccines cv ON cd.country_id = cv.country_id
ORDER BY co.country_name, cd.report_date;
