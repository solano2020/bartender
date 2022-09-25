## Bartender

Ejercicio de conceptos básicos de java en Spring Boot. Esta API permite consultar un arreglo de números que representa los "platos" y luego verifica que estos sea divisible uniformemente por los números del arreglo **P** que representan los números primos. De esta verificación está limitada por un número de iteraciones **Q**  que por último devuelve el arreglo de respuesta.

**Requerimientos**

-  **Java 17** o superior (en llegado caso puede configurar el de su preferencia).

- **PostgreSQL 14v**


**Instrucciones de instalación**

- Tenga en cuenta configurar el archivo aplication.yml el cual tiene la configuración requerida para la conexión con la base de datos.

- Luego cree una base de datos llamada **bartender**.

- por último corra el proyecto. automaticamente correra la base de 
datos cargando los datos correspondientes y el servidor en el puerto 8090.

**Uso de la Api**

-El enpoint predeterminado es: localhost:8090/bartender/array_response.

-Recibe dos parámetros, **q** el número de iteraciones y el **id** del arreglo en la base.
