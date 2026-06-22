import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Method> methodsWithImportant = getMethodsWithAnnotation(TestClass.class, Important.class);
        printImportantMethods(methodsWithImportant);

        List<Method> methodsWithDeprecated = getMethodsWithAnnotation(TestClass.class, Deprecated.class);
        printDeprecatedMethods(methodsWithDeprecated);
    }

    private static void printImportantMethods(List<Method> methods) {
        System.out.println("Print name methods: ");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("------------------------------------------");
    }

    private static void printDeprecatedMethods(List<Method> methods) {
        System.out.println("WARNING!!! This methods is deprecated");
        System.out.println("Print name methods: ");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("------------------------------------------");
    }

    private static <T extends Annotation> List<Method> getMethodsWithAnnotation(Class<?> clazz, Class<T> annotationType) {
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(annotationType))
                .toList();
    }
}
