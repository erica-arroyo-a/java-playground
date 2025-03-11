public class StringCompressor {
    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        compressed.append(input.charAt(input.length() - 1)).append(count);

        return compressed.toString();
    }

    public static void main(String[] args) {
        String input = "aaabbbcccd";
        String input2 = "aaabbb";
        String compressed = compressString(input);
        String compressed2 = compressString(input2);
        System.out.println("Compressed: " + compressed);
        System.out.println("Compressed2: " + compressed2);
    }
}
