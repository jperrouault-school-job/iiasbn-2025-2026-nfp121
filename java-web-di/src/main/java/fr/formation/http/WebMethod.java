package fr.formation.http;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import fr.formation.annotation.RequestParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter @Setter
@Builder
@Log4j2
public class WebMethod {
    private Object instance;
    private Method method;

    public Object invoke(HttpRequest request, HttpResponse response) {
        try {
            Object[] parameterValues = new Object[this.method.getParameterCount()];
            int i = 0;

            for (Parameter param : this.method.getParameters()) {
                RequestParam requestParamAnnotation = param.getDeclaredAnnotation(RequestParam.class);

                if (requestParamAnnotation != null) {
                    String paramName = requestParamAnnotation.value().isBlank() ? param.getName() : requestParamAnnotation.value();
                    parameterValues[i] = request.getParameter(paramName);

                    if (param.getType() == Integer.class) {
                        parameterValues[i] = Integer.parseInt((String)parameterValues[i]);
                    }
                }

                i++;
            }

            return this.method.invoke(this.instance, parameterValues);
        }

        catch (Exception e) {
            log.error("Une erreur est survenue pendant l'invocation de la méthode {} : {}", this.method.getName(), e.getMessage());

            response.setHttpException(HttpException.builder()
                .cause(e)
                .message(e.getMessage())
                .build()
            );

            return "";
        }
    }
}
