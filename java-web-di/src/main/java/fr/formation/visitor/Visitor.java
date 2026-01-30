package fr.formation.visitor;

import fr.formation.http.HttpResponse;

public interface Visitor {
    public void visit(HttpResponse response);
}
