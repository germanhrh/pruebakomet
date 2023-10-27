package tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecutionGet implements Task {

    private String endpoint;
    private String id;

    public ExecutionGet(String endpoint, String id){
        this.endpoint = endpoint;
        this.id = id;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint.concat(id)));
        //SerenityRest.lastResponse().prettyPeek();
    }
    public static ExecutionGet getInformation (String endpoint, String id){
        return Tasks.instrumented(ExecutionGet.class, endpoint, id);
    }
}
