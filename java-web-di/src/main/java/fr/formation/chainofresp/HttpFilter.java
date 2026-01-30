package fr.formation.chainofresp;

import fr.formation.http.HttpRequest;
import fr.formation.http.HttpResponse;

public abstract class HttpFilter {
    private HttpFilter next;

    public HttpFilter setNext(HttpFilter next) {
        this.next = next;

        return next;
    }

    protected void doNext(HttpRequest request, HttpResponse response) {
        if (this.next != null) {
            this.next.handle(request, response);
        }
    }

    public abstract void handle(HttpRequest request, HttpResponse response);
}
