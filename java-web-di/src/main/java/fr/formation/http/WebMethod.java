package fr.formation.http;

import java.lang.reflect.Method;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class WebMethod {
    private Object instance;
    private Method method;

    public Object invoke() {
        try {
            return this.method.invoke(this.instance);
        }

        catch (Exception e) {
            return null;
        }
    }
}
