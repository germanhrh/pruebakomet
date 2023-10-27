package com.komet.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import tasks.ExecutionGet;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetKometStepsDefinitions {

    @Before
    public void setup(){
        setTheStage(new OnlineCast());
    }

    @Given("{string} establece la base url {string} del servicio")
    public void estableceLaBaseUrlDelServicio(String actorName, String baseUrl) {
        theActorCalled(actorName).whoCan(CallAnApi.at(baseUrl));
    }

    @When("consulta en el endpoint {string} con el id {string}")
    public void consultaEnElEndpointConElId(String endpoint, String id) {
        theActorInTheSpotlight().attemptsTo(ExecutionGet.getInformation(endpoint, id));
    }

    @Then("Validar que el status code sea {int} y la respuesta contega el nombre {string}")
    public void validarQueElStatusCodeSeaYLaRespuestaContegaElNombre(Integer status, String name) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(status).body(
                "name", equalTo(name))));


    }
}