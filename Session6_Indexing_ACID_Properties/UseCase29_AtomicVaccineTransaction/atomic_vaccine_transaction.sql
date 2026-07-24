USE covid_tracker6;

DROP PROCEDURE IF EXISTS InsertVaccineDistribution;

DELIMITER $$

CREATE PROCEDURE InsertVaccineDistribution(
    IN p_country VARCHAR(100),
    IN p_shipment_date DATE,
    IN p_vaccine_name VARCHAR(100),
    IN p_doses_shipped BIGINT,
    IN p_admin_date DATE,
    IN p_doses_administered BIGINT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    INSERT INTO vaccine_shipments (country, shipment_date, vaccine_name, doses_shipped)
    VALUES (p_country, p_shipment_date, p_vaccine_name, p_doses_shipped);

    INSERT INTO vaccine_administration (country, admin_date, doses_administered)
    VALUES (p_country, p_admin_date, p_doses_administered);

    COMMIT;
END $$

DELIMITER ;

CALL InsertVaccineDistribution('Brazil', '2026-07-23', 'AstraZeneca', 400000, '2026-07-24', 380000);

SELECT * FROM vaccine_shipments WHERE country = 'Brazil';
SELECT * FROM vaccine_administration WHERE country = 'Brazil';

START TRANSACTION;

INSERT INTO vaccine_shipments (country, shipment_date, vaccine_name, doses_shipped)
VALUES ('Germany', '2026-07-23', 'Moderna', 300000);

INSERT INTO vaccine_administration (country, admin_date, doses_administered)
VALUES ('Germany', '2026-07-24', -50000);

ROLLBACK;

SELECT * FROM vaccine_shipments WHERE country = 'Germany';
SELECT * FROM vaccine_administration WHERE country = 'Germany';
