#Procedimiento para validar al usuario

DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_ValidarUsuario` $$
CREATE PROCEDURE `erp`.`sp_ValidarUsuario` (
  IN _NombreUsuario Varchar(50),
  IN _HashContra Varchar(50),
  OUT _idPerfiles int,
  OUT _idUsuarios int )
BEGIN
  SET _idPerfiles = -1;
  SET _idUsuarios = -1;
  IF ( EXISTS( SELECT idPerfiles FROM usuarios WHERE NombreUsuario=_NombreUsuario AND HashContra = _HashContra))
  THEN
      SET _idPerfiles = (Select idPerfiles from usuarios where NombreUsuario=_NombreUsuario AND HashContra = _HashContra);
      SET _idUsuarios = (Select idUsuarios from usuarios where NombreUsuario=_NombreUsuario AND HashContra = _HashContra);

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
THEN SET _NombrePerfil = (Select NombrePerfil from perfiles where IdPerfiles=_idPerfiles);
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



#Procedmiento para agregar un usuario
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_AgregarUsuario` $$
CREATE PROCEDURE `erp`.`sp_AgregarUsuario` (In _IdPerfiles int, In _NombreUsuario varchar(50), In _HashContra varchar(50), In _Clave varchar(10))
BEGIN
Insert into usuarios(IdPerfiles, NombreUsuario, Hashcontra, Clave) values (_IdPerfiles, _NombreUsuario, _HashContra, _Clave);
END $$

DELIMITER;


#procedimiento para modificar un usuario
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_ModificarUsuario` $$
CREATE PROCEDURE `erp`.`sp_ModificarUsuario` (In _IdUsuarios int, In _IdPerfiles int, In _NombreUsuario varchar(50), In _Clave varchar(10))
BEGIN
Update usuarios SET IdPerfiles=_IdPerfiles, NombreUsuario=_NombreUsuario, Clave= _Clave Where IdUsuarios = _IdUsuarios;
END $$

DELIMITER;


#Procedimiento para eliminar un usuario
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_EliminarUsuario` $$
CREATE PROCEDURE `erp`.`sp_EliminarUsuario` (In _IdUsuarios int)
BEGIN
Delete from usuarios where IdUsuarios=_IdUsuarios;
END $$

DELIMITER;



#Procedimiento para buscar nombre empleado
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_buscarNombreEmp` $$
CREATE PROCEDURE `erp`.`sp_buscarNombreEmp` (In _Clave int, Out _Nombre varchar(50))
BEGIN
SET _Nombre = null;
  IF ( EXISTS( SELECT Nombre FROM personal WHERE Clave=_Clave))
  THEN SET _Nombre = (SELECT Nombre FROM personal WHERE Clave=_Clave);
END IF;
END $$

DELIMITER;


#Metodo para ingresar un dato a la bitacora
DELIMITER $$

DROP PROCEDURE IF EXISTS `erp`.`sp_InsertarBitacora` $$
CREATE PROCEDURE `erp`.`sp_InsertarBitacora` (In _IdErroresERP int, In _IdPerfiles int, In _IdUsuarios int, In _Timestamp Datetime, In _Accion varchar(50))
BEGIN

insert into Bitacora (IdErroresERP, IdPerfiles, IdUsuarios, Timestamp, Accion) values (_IdErroresERP, _IdPerfiles, _IdUsuarios, now(), _Accion);

END $$

DELIMITER;






