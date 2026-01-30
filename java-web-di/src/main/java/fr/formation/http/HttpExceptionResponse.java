package fr.formation.http;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class HttpExceptionResponse {
    private int status;
    private String message;
}
