# PROYECTO FINAL OrangeHRM

Santiago Becerra Almancy (64647)

### Acerca del proyecto
----
El proyecto fue realizado en Intellij para la ejecución automatizada de tests para la siguiente página web: [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login). Se realizó un total de 4 Tests donde en cada test se revisan varias funciones de la página web. Cada test realiza una acción dentro de la web, verifica las acciones realizadas y realiza un logout al finalizar.

### Requisitos previos
----
- Descargar Intellij IDEA: recomendablemente descargar la versión "Community Edition" del siguiente link: INTELLIJ Link
- JDK: IntelliJ IDEA es una herramienta de desarrollo Java, por lo que necesita tener instalado un JDK en su sistema. Puede usar Oracle JDK, OpenJDK u otros JDK compatibles. El proyecto utiliza la versión "Oracle OpenJDK Version 20.0.2".
- Google Chrome: las pruebas automatizadas fueron realizadas utilizando el navegador Google Chrome.

### Instrucciones de ejecución
----
1. Descargar el proyecto del repositorio
2. Abrir el proyecto con Intellij IDEA
3. Revisar que el JDK sea el correcto, el proyecto utiliza: "Oracle OpenJDK Version 20.0.2"
4. Abrir dentro de Intellij la carpeta: src > test > java > utils
5. Entrar al archivo TestRunner y hacer click derecho y seleccionar la opción "Run TestRunner".
6. El resultado de la ejecución se verá en la consola de la parte inferior, donde se indicará los test que pasaron y aquellos que fallaron.

### Notas Adicionales
----
Si desea revisar el proyecto más a detalle considerar lo siguiente:
- La carpeta src > test > resources: contiene todos los testcases automatizados, se definen estos mediante pasos.
- La carpeta src > main > java > utilities: contiene la configuración del driver que facilita la gestión y configuración de controladores (drivers) del navegador web utilizado (Google Chrome).
- La carpeta src > main > java > pages: contiene todas las acciones y verificaciones que se realizan en cada página de OrangeHRM.
- La carpeta src > test > java > stepDefinitions: contiene todos los pasos definidos para la carpeta resources, la implementación de los pasos. 

Se realizó esta división para cumplir con el "Page Object Pattern", un patrón de diseño en Selenium que crea un repositorio de objetos para almacenar todos los elementos web.
