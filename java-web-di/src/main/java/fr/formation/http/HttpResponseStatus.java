package fr.formation.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HttpResponseStatus {
    OK(200),
    BAD_REQUEST(400),
    FORBIDDEN(403),
    NOT_FOUND(404);

    private final int code;
}
