public class MainApp {
    public static void main(String[] args) {
        AnalyserClass analyserClass = new AnalyserClass();
        System.out.println(analyserClass.getInfoClass(Person.class));
        System.out.println(analyserClass.getInfoClass(String.class));
    }
}
