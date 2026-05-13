import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {

    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

//    public void add(String lastName, String phoneNumber) {
//        if (directory.containsKey(lastName)) {
//            List<String> numbers = directory.get(lastName);
//            numbers.add(phoneNumber);
//        } else {
//            directory.put(lastName, new ArrayList<>(List.of(phoneNumber)));
//        }
//    }

    public void add(String lastName, String phoneNumber) {
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> getListPhone(String lastName) {
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            sb.append(entry.getKey()).append(" - ");
            sb.append(entry.getValue()).append("\n");
        }

        return sb.toString().trim();
    }

    public List<String> getListPhoneStream(String lastName) {
        return directory.entrySet().stream()
                .filter(entry -> entry.getKey().equals(lastName))
                .map(entry -> entry.getValue())
                .flatMap(list -> list.stream())
                .toList();
    }
}
