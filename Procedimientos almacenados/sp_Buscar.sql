DELIMITER $$

DROP PROCEDURE IF EXISTS `ejemplo`.`sp_BuscarPerfil` $$
CREATE PROCEDURE `ejemplo`.`sp_BuscarPerfil` (IN id_Perfil int, OUT nombreP Varchar(50))
BEGIN
SET nombreP = '';
IF(Exists(Select nombrePerfil from perfilusuario where idPerfil=id_Perfil))
THEN SET nombreP = (Select nombrePerfil from perfilusuario where idPerfil=id_Perfil);
END IF;
END $$

DELIMITER ;