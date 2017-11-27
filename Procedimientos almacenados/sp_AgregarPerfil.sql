﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `ejemplo`.`sp_AgregarPerfil` $$
CREATE PROCEDURE `ejemplo`.`sp_AgregarPerfil` (In nombreP varchar(50))
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


DELIMITER $$

DROP PROCEDURE IF EXISTS `ejemplo`.`sp_ModificarPerfil` $$
CREATE PROCEDURE `ejemplo`.`sp_ModificarPerfil` (In idPerf int, In nombreP varchar(10))
BEGIN
Update perfilusuario SET nombrePerfil=nombreP Where idPerfil = idPerf;
END $$

DELIMITER;


DELIMITER $$

DROP PROCEDURE IF EXISTS `ejemplo`.`sp_EliminarPerfil` $$
CREATE PROCEDURE `ejemplo`.`sp_EliminarPerfil` (In idPerf int)
BEGIN
Delete from perfilusuario where idPerfil=idPerf;
END $$

DELIMITER;

