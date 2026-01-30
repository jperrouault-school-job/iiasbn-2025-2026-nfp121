package fr.formation.http;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HttpResponse {
    @Setter(AccessLevel.PRIVATE)
    private String content;

    private HttpResponseStatus status;
    private HttpContentType contentType;
    private HttpException httpException;

    public void write(String content) {
        this.content = content;
    }

    public void append(String content) {
        this.content += content;
    }
}
