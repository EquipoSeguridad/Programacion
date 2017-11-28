#Procedimiento para validar al usuario

DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_ValidarUsuario` $$
CREATE PROCEDURE `erp`.`sp_ValidarUsuario` (
  IN _NombreUsuario Varchar(50),
  IN _HashContra Varchar(50),
  OUT _idPerfiles int)
BEGIN
  SET _idPerfiles = -1;
  IF ( EXISTS( SELECT idPerfiles FROM usuarios WHERE NombreUsuario=_NombreUsuario AND HashContra = _HashContra))
  THEN SET _idPerfiles = (Select idPerfiles from usuarios where NombreUsuario=_NombreUsuario AND HashContra = _HashContra);
END IF;
END $$

DELIMITER;

#Procedimiento para buscar el nombre de un perfil
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_BuscarPerfil` $$
CREATE PROCEDURE `erp`.`sp_BuscarPerfil` (IN _idPerfiles int, OUT _NombrePerfil Varchar(50))
BEGIN
SET _NombrePerfil = '';
IF(Exists(Select NombrePerfil from perfiles where IdPerfiles=_idPerfiles))
THEN SET _NombrePerfil = (Select NombrePerfil from perfiles where IdPerfiles=id_Perfil);
END IF;
END $$

DELIMITER ;


#Procedimiento para agregar un perfil
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_AgregarPerfil` $$
CREATE PROCEDURE `erp`.`sp_AgregarPerfil` (In _NombrePerfil varchar(50))
BEGIN
Insert into perfiles(NombrePerfil) values(_NombrePerfil);
END $$

DELIMITER;


#Procedimiento para modificar un perfil
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_ModificarPerfil` $$
CREATE PROCEDURE `erp`.`sp_ModificarPerfil` (In _idPerfiles int, In _NombrePerfil varchar(10))
BEGIN
Update perfiles SET NombrePerfil=_idPerfiles Where idPerfiles = _idPerfiles;
END $$

DELIMITER;



#Procedimiento para eliminar un perfil
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_EliminarPerfil` $$
CREATE PROCEDURE `erp`.`sp_EliminarPerfil` (In _idPerfiles int)
BEGIN
Delete from perfiles where idPerfiles=_idPerfiles;
END $$

DELIMITER;











