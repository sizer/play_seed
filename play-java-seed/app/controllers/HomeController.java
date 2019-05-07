package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.mvc.Session;
import play.libs.Json;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        java.util.Optional<java.lang.String> uuid = session().getOptional("uuid");
        if(uuid.isPresent()) {
            return ok(comeBackResponse());
        } else {
            session("uuid", "hogehoge");
            return ok(firstTimeResponse());
        }
    }

    private ObjectNode firstTimeResponse() {
        ObjectNode response = Json.newObject();
        response.put("message", "hello!");
        return response;
    }

    private ObjectNode comeBackResponse() {
        ObjectNode response = Json.newObject();
        response.put("message", "yay! you came back here!!");
        return response;
    }
}
