package fr.formation.http;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

import fr.formation.annotation.RequestParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class WebMethod {
    private Object instance;
    private Method method;

    public Object invoke(Map<String, String> queryParameters) {
        try {
            Object[] parameterValues = new Object[this.method.getParameterCount()];
            int i = 0;

            for (Parameter param : this.method.getParameters()) {
                RequestParam requestParamAnnotation = param.getDeclaredAnnotation(RequestParam.class);

                if (requestParamAnnotation != null) {
                    String paramName = requestParamAnnotation.value().isBlank() ? param.getName() : requestParamAnnotation.value();
                    parameterValues[i] = queryParameters.get(paramName);

                    if (param.getType() == Integer.class) {
                        parameterValues[i] = Integer.parseInt((String)parameterValues[i]);
                    }
                }

                i++;
            }

            return this.method.invoke(this.instance, parameterValues);
        }

        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
