package fr.formation.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HttpRequest {
    private List<String> lines = new ArrayList<>();
    private String path;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();
    private byte[] body;

    public String getHeader(String name) {
        return this.headers.get(name);
    }

    public String getParameter(String name) {
        return this.parameters.get(name);
    }
}
