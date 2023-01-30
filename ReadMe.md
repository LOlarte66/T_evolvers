Proyecto de automatización WEB y API 

(Demoblaze web app: https://www.demoblaze.com/ y Restful web Api: https://restful-booker.herokuapp.com/apidoc/index.html)

Nombre archivos proyectos: API="RestfulKarate_TEvolv"  // WEB="T_Evolv"

Otro archivo: Reportes (se deja evidencia un reporte de cada proyecto) 

// API: build/cucumber-html-reports/overview-features.html 

// WEB: target/site/serenity/index.html

Objetivo: 

Web: Probar el aseguramiento de la calidad para la página Demoblaze enfocado en comprar productos y realizar su pago.
API: Probar el funcionamiento de las API //1. CreateBooking.// 2. GetBooking.// 3. UpdateBooking. // para la página Restful.

Stack tecnologico:****************************************************************************************************************************

-IDE: Intellij.

-Lenguaje: Java-POO.

-gestor de proyectos: Gradle.

-Patrón de diseño: Screenplay.

-Herramienta de automatizacion de pruebas: Cucumber con Serenity BDD + Gherkin como lenguaje especifico (Proyecto WEB) // KarateDSL + Cucumber (Proyecto API)

-Herramienta de interacción web: Selenium

-Gestor de pruebas unitarias: JUnit+Hamcrest (Proyecto WEB) // JUnit (Proyecto API)

-versionador: Git

-manejo de repositorios: Github

-Servicios web: KarateDSL para el manejo de APIS de forma automatica.

Comandos de ejecución:****************************************************************************************************************************

Comandos correr proyecto API (RestfulKarate_TEvolv):*************

Generan reporte dentro de la /ruta/nombrearchivo -> build/cucumber-html-reports/overview-features.html

Todos los features :: gradle clean test --tests AllFeaturesRunner

Flujo E2E :: gradle clean test --tests UpdateBookingPutRunner

Comandos API por feature:

-GetBookingRuuner <-> get_booking.feature :: 
gradle clean test --tests GetBookingRuuner

-AuthPostRunner <-> auth_post.feature :: 
gradle clean test --tests AuthPostRunner

-CreateBookingPostRunner <-> create_booking_post.feature :: 
gradle clean test --tests CreateBookingPostRunner

-UpdateBookingPutRunner <-> update_booking_put.feature (Este hace enfasis a la prueba E2E) :: 
gradle clean test --tests UpdateBookingPutRunner



Comandos correr proyecto WEB (T_Evolv):********************

El Comandoo 1 genera reporte en la /ruta/nombrearchivo -> target/site/serenity/index.html

Comando 1 :: 
gradle clean test aggregate

Comando 2 :: 
gradle clean test
