package fr.formation.http;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter @Setter
@ToString
public class HttpExceptionResponse {
    private int status;
    private String message;
}
