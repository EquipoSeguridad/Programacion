DELIMITER $$

DROP PROCEDURE IF EXISTS `ejemplo`.`sp_ValidarUsuario` $$
CREATE PROCEDURE `ejemplo`.`sp_ValidarUsuario` (
IN userName Varchar(50),
IN passw Varchar(50),
OUT resp int)
BEGIN
SET resp = -1;
IF(Exists(Select id_Perfil from usuarios where Nick=userName AND Contrasena = passw))
THEN SET resp = (Select id_Perfil from usuarios where Nick=userName AND Contrasena = passw);
END IF;
END $$

DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS `ejemplo`.`login_usuario` $$
CREATE  PROCEDURE `login_usuario`(IN nombre VARCHAR(30),
				IN passw VARCHAR(30),
				OUT existe INT,
				OUT user_name VARCHAR(30))
BEGIN
         SET existe=0;
         SELECT Nick,idUsuario into user_name,existe
            FROM usuarios
            WHERE STRCMP(Nick,nombre)=0
				AND STRCMP(Contrasena,passw)=0;
END $$
DELIMITER;


DELIMITER $$
DROP PROCEDURE IF EXISTS `ejemplo`.`proc_Verificar_Usuario` $$
CREATE PROCEDURE proc_Verificar_Usuario(
IN UserName	varchar(30),
IN Pass	varchar(30),
OUT idP int)
begin
SET @idP	= -1;
if(EXISTS (select * from usuarios where (Nick = UserName and Contrasena = Pass))) THEN
select idP = idUsuario from usuarios where Nick = UserName and Contrasena = Pass;
end if;
end $$
DELIMITER;