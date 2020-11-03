package controllers.requests.parsers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.F;
import play.mvc.Result;
import play.mvc.Results;

import java.util.function.Function;

public class ReqtParserFuncFactory {
    public static <T> Function<F.Either<Result, JsonNode>, F.Either<Result, T>> create(
            Function<JsonNode, T> func
    ) {
        return resultOrJson -> {
            if (resultOrJson.left.isPresent()) {
                return F.Either.Left(resultOrJson.left.get());
            } else {
                try {
                    return F.Either.Right(func.apply(resultOrJson.right.get()));
                } catch (Exception e) {
                    return F.Either.Left(
                            Results.badRequest("invalid request."));
                }
            }
        };
    }
}