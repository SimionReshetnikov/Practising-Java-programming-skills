public class MainApp {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        directory.add("Ivanov", "89132254675");
        directory.add("Petrov", "89814575596");
        directory.add("Sidorov", "85236759844");
        directory.add("Ivanov", "89564753212");
        directory.add("Petrov", "89125478655");
        directory.add("Ivanov", "89751453688");

        System.out.println(directory.getAll());

        System.out.println(directory.getListPhoneStream("Ivanov"));
    }
}
