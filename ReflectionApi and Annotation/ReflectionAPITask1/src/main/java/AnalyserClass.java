import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class AnalyserClass {

    public String getInfoClass(Class<?> element) {
        StringBuilder sb = new StringBuilder();
        sb.append(getNameClass(element));
        sb.append(getAllPublicMethods(element));
        sb.append(getAllPrivateMethodsName(element));
        return sb.toString();
    }

    private String getNameClass(Class<?> element) {
        return "Name class: " + element.getName() + "\n";
    }

    private String getAllPublicMethods(Class<?> element) {
        StringBuilder sb = new StringBuilder("Methods:\n");
        Method[] methods = element.getMethods();
        Arrays.stream(methods)
                .forEach(method -> sb.append(method).append("\n"));
        return sb.toString();
    }

    private String getAllPrivateMethodsName(Class<?> element) {
        StringBuilder sb = new StringBuilder("Name private methods:\n");
        Method[] allMethods = element.getDeclaredMethods();
        Arrays.stream(allMethods)
                .filter(method -> Modifier.isPrivate(method.getModifiers()))
                .map(Method :: getName)
                .forEach(name -> sb.append(name).append("\n"));
        return sb.toString();
    }
}
