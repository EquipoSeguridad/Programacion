DELIMITER $$

DROP PROCEDURE IF EXISTS `ejemplo`.`sp_AgregarPerfil` $$
CREATE PROCEDURE `ejemplo`.`sp_AgregarPerfil` (In nombreP varchar(10))
BEGIN
Insert into perfilusuario(nombrePerfil) values(nombreP);
END $$

DELIMITER;



DELIMITER $$

DROP PROCEDURE IF EXISTS `ejemplo`.`sp_BuscarPerfilU` $$
CREATE PROCEDURE `ejemplo`.`sp_BuscarPerfilU` (In nombreP varchar(10))
BEGIN
select * from perfilusuario where nombrePerfil=nombreP;
END $$

DELIMITER;


