import java.util.List;

public class JsonFormatter {
    public static String toJson(List<Integer> numbers) {
        StringBuilder json = new StringBuilder();
        json.append("[");

        for (int i = 0; i < numbers.size(); i++) {
            json.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                json.append(", ");
            }
        }

        json.append("]");
        return json.toString();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        String json = toJson(numbers);
        System.out.println("JSON Output: " + json);
    }
}
