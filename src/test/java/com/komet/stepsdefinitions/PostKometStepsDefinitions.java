package com.komet.stepsdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import tasks.ExecutePost;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class PostKometStepsDefinitions {

    @When("proporciona la informacion del usuario {string}")
    public void proporcionaLaInformacionDelUsuario(String endpoint, DataTable userInformation) {
        theActorInTheSpotlight().attemptsTo(ExecutePost.createUser(endpoint, userInformation));
    }

    @Then("valida que la respuesta tenga el nombre {string} y el status code sea {int}")
    public void validaQueLaRespuestaTengaElNombreYElStatusCodeSea(String id, Integer statusCode) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statusCode)
                .body("message", equalTo(id))));
    }
}
