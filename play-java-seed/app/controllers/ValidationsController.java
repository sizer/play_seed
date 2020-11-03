package controllers;

import controllers.requests.ValidationsReuqests;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class ValidationsController extends Controller {

    @BodyParser.Of(ValidationsReuqests.Create.Parser.class)
    public Result create(Http.Request request) {
        final ValidationsReuqests.Create reqBody = request.body().as(ValidationsReuqests.Create.class);

        return ok("Got: " + reqBody.getInput());
    }
}
