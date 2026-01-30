package fr.formation.http;

import fr.formation.visitor.Visitable;
import fr.formation.visitor.Visitor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HttpResponse implements Visitable {
    private HttpResponseStatus status;
    private HttpContentType contentType;
    private HttpException httpException;

    private Object rawContent;

    @Setter(AccessLevel.PRIVATE)
    private String content;

    public void write(String content) {
        this.content = content;
    }

    public void append(String content) {
        this.content += content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
