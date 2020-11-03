package controllers.requests;

import akka.util.ByteString;
import com.google.inject.Inject;
import controllers.requests.parsers.ReqtParserFuncFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import play.libs.F;
import play.libs.streams.Accumulator;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;

import java.util.concurrent.Executor;

public class ValidationsReuqests {

    @Getter
    @NoArgsConstructor
    public static class Create {
        String input;

        public static class Parser implements BodyParser<Create> {
            @Inject
            protected BodyParser.Json jsonParser;
            @Inject
            protected Executor executor;

            @Override
            public Accumulator<ByteString, F.Either<Result, Create>> apply(Http.RequestHeader request) {
                return jsonParser.apply(request).map(
                    ReqtParserFuncFactory.create(reqJson -> play.libs.Json.fromJson(reqJson, Create.class)),
                    executor
                );
            }
        }

    }

}