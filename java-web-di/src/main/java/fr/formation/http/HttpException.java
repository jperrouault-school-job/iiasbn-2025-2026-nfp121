package fr.formation.http;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class HttpException {
    private Exception cause;
    private String message;
}
