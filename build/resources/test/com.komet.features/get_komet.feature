Feature: Automatizacion de api
  Yo como postulante
  Necesito automatizar la ejecucion de api
  Para certificar mis conocimientos en automatizacion

  Scenario: consultar informacion de una mascota de la tienda por ID
    Given "Usuario" establece la base url "https://petstore.swagger.io/" del servicio
    When consulta en el endpoint "v2/pet/" con el id "123"
    Then Validar que el status code sea 200 y la respuesta contega el nombre "doggie"
