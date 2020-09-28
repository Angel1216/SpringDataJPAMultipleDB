# SpringDataJPAMultipleDB

Proyecto:

- Archivos de configuración de los datasources para ambas bases de datos
- Los repositorios de spring-data para JPA
- Sus entity para el SP y la tabla
- Sus propiedades de conexión
- El pom con sus dependencias

César me hizo el favor de proporcionarme la definición de la tabla que el utiliza y el Stored procedure que invoco para replicar el escenario real.

Notas: 
- El proyecto que cree lo hice con properties, pero pues ya solo es pasar esas mismas configuraciones a un bootstrap.yml a su sintaxis de indentación.
- Por el momento, este proyecto que cree lo hice conectando a una base de datos MSSQLServer y un PostgreSQL (pero pues eso seria transparente ya que solo se le tendrían que cambiar los datos de propiedades de conexión para que JPA pues haga el cambio, y seria transparente el cambio)

Te proporciono los datos del sql de la estructura de los objetos que utilice para crear los objetos en mis bases de datos que levanté en mi maquina.

Stored Procedure
Aquí solo asigne un valor de regreso al campo que recuperamos:
CREATE PROCEDURE dbo.sp_Certified_CellPhone_Validation(@customer_numer char(12), @Adding char,
                                                        @cellphone varchar(15) output, @carrier varchar(3) output,
                                                        @certification_type int output, @rejected_count int output,
                                                        @blocked char output, @attemps int output,
                                                        @certification_way char output, @DB_Status_Code int output,
                                                        @DB_Status_Code_Description varchar(255) output)
                                                        as
begin
    set @cellphone = '5557344334';
end

Declare @cell varchar(15);
exec dbo.sp_Certified_CellPhone_Validation @customer_numer = '34344', @Adding = '',
                                                        @cellphone = @cell output, @carrier = '',
                                                        @certification_type = 2, @rejected_count = 3,
                                                        @blocked = '', @attemps = 4,
                                                        @certification_way = '', @DB_Status_Code = 4,
                                                        @DB_Status_Code_Description = '';
Select @cell;


Tabla
Para su creación, le puse la propiedad de JPA para creara el objeto de la entidad en la base de datos, ya nada mas lo poble para poder recuperar información.

INSERT INTO CLIENTS (CLIENT_ID, CLIENT_NAME, ACCESS_DATE_TIME, FIRST_TIME, FIRST_NAME, LAST_NAME, SECOND_LAST_NAME,
                     KEEP_SESSION_COUNTER, HARDWARE_ID, STATUS_BM, CREATE_DT, DEVICE_ID, MODIFICATION_DT, LAST_LOGIN_DT,
                     CERTIFIED_CELLPHONE, CODI_ID)
       VALUES (254656, 'Angel Martinez Leon', '27/09/2020', '21:46', 'Angel', 'Martinez', null,
                     2, 'HARDWARE_ID', 3, '27/09/2020', 'Desktop', '27/09/2020','27/09/2020',
                     '51209192', 'CODI_ID');

Saludos.
