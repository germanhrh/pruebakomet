package tasks;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

import java.util.Map;

public class ExecutePost implements Task {

    private String endpoint;
    private Map<String, String> body;

public ExecutePost(String endpoint, DataTable body)
{
    this.endpoint= endpoint;
    this.body = body.asMap(String.class, String.class);

}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(endpoint).with(request ->
                request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                        .body(body)));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExecutePost createUser(String endpoint, DataTable body){
        return Tasks.instrumented(ExecutePost.class, endpoint, body);
    }
}
