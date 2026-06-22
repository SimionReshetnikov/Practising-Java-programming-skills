import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainApp {
    public static void main(String[] args) {
        Class<User> clazz = User.class;
        try {
            Constructor<User> constructorWithParameters = clazz.getConstructor(String.class, int.class, String.class);
            User user1 = constructorWithParameters.newInstance("Sveta", 22, "SvetaLeto@example.com");
            printUserInfo(user1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            Constructor<User> constructorNoParameters = clazz.getConstructor();
            User user2 = constructorNoParameters.newInstance();
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(user2, "Elena");
            setField(user2, "name", "Elena");
            setField(user2, "age", 25);
            setField(user2, "email", "ElenaPionera@example.com");

            printUserInfo(user2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printUserInfo(User user) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Method method = User.class.getMethod("displayInfo");
        System.out.println(method.invoke(user));
    }

    private static void setField(User user, String fieldName, Object value) throws NoSuchFieldException,
            IllegalAccessException {
        Field field = User.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(user, value);
    }
}
