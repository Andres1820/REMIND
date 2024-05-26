Descripción del Proyecto: 
REMID es una aplicación móvil que permite realizar una gestión de compromisos centralizada. Su público objetivo es mayormente el ambiente empresarial, en donde permite definir tareas, responsables y fechas limite de cumplimiento. Así como de alertar al usuario cuales de estas tares se encuentran próximas a vencer. Finalmente, para este primer alcance la aplicación esta funcionando netamente de manera local y no ha sido posible la integración con Bases de Datos de manera remota.

Requisitos Previos: 
-	IDE: Android Studio versión 2023.2 
-	Lenguaje: Kotlin 1.9.0

Configuración del proyecto:
En el archivo “build.gradle.kts (Module :app)” es necesario agregar las dos dependencias mencionadas a continuación:
implementation("androidx.recyclerview:recyclerview:1.2.0")
implementation("androidx.cardview:cardview:1.0.0")

Ambiente de pruebas:
Esta aplicación se ejecutó en un ambiente de pruebas por medio de la máquina virtual “Pixel_3a_API_34_extension_level_7_x86_64" integrada en el IDE y en un dispositivo físico “samsung SM-A135m”.

Uso: 
- En la pantalla de inicio, aparece la opción para ingresar o registrarse. Para el caso de “Ingresar” se ha creado el usuario genérico: 
Correo: consulta
Contraseña: consulta
- En caso de que se requiera registrar, la aplicación cuenta con una restricción enfocada a no permitir agregar un usuario que ya se encuentre agregado.
- Después de perimir el ingreso, el usuario se encontrará en la pantalla principal de la aplicación. En donde para visualizar las tareas, previamente deberá seleccionar un proyecto de su elección.
- Actualmente, el botón “Nuevo Proyecto” no se encuentra configurado. Pero se da un primer avance de las vistas del customDialog.
- Una vez seleccionado un proyecto, la aplicación usara el recurso RecyClerView por medio de varias CardView’s para mostrar las actividades relacionadas al mismo.
- Desde esta vista se podrá seleccionar en un futuro cada una de las tareas, con el objetivo de permitir presentar un detalle y gestión de estas.
- En el apartado “Alerta” es donde se van a presentar las tareas próximas a vencer. Para esta entrega, esta gestión no fue completada y seria un punto de mejora en futuras fases.
- Únicamente se podrá cerrar la sesión del usuario desde la vista de “Cuenta”. En donde también presenta el atributo “nombre” del usuario.
- Finalmente, en toda la interacción con la aplicación es posible realizar al cambio de vistas sin perder la información del usuario o proyecto seleccionado.

Contribución: 
- Integrar el proyecto con Base de Datos remota.
- Continuar con la funcionalidad que permita agregar un nuevo proyecto.
- Agregar la funcionalidad que permita gestionar el detalle de una tarea.
- Configurar la alerta de tareas próximas a vencer.

Licencia: El nivel actual de desarrollo relacionado con REMIND no requiere licencia para su uso, distribución y gestión general.

Créditos: 
Docente: Alejandro Franco
Curso: Developing Android Apps with Kotlin
Canales de YouTube: DevExpert - Programación Android y Kotlin, Code With Esau, Codelia
