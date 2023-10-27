Feature: Automatizacion de api
  Yo como postulante
  Necesito automatizar la ejecucion de api
  Para certificar mis conocimientos en automatizacion


  Scenario Outline: Crear un usuario en petstore
    Given "Actor" establece la base url "https://petstore.swagger.io/" del servicio
    When proporciona la informacion del usuario "v2/user"
      | id         | <id>         |
      | username   | <username>   |
      | firstName  | <firstName>  |
      | lastName   | <lastName>   |
      | email      | <email>      |
      | password   | <password>   |
      | phone      | <phone>      |
      | userStatus | <userStatus> |
    Then valida que la respuesta tenga el nombre "<id>" y el status code sea 200

    Examples:
      | id  | username | firstName | lastName | email           | password | phone      | userStatus |
      | 123 | alejo123 | Alejandro | Ramos    | alejo@gmail.com | 123*     | 3011234567 | 0          |