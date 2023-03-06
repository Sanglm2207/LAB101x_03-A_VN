import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String inputFileName = "src/input.txt";
            String outputFileName = "src/output.txt";

            String inputText = readTextFile(inputFileName);
            String normalizedText = normalizeText(inputText);
            writeTextFile(outputFileName, normalizedText);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String readTextFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static void writeTextFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(text);
        bufferedWriter.close();
    }

    public static String normalizeText(String text) {
        // Xóa khoảng trắng trước và sau văn bản
        text = text.trim();

        // Chỉ có một khoảng trắng giữa các từ
        text = text.replaceAll("\\s+", " ");

        // Chỉ một dấu cách sau dấu phẩy (,), dấu chấm (.) và dấu hai chấm (:)
        text = text.replaceAll("\\s+,", ",");
        text = text.replaceAll("\\s+\\.", ".");
        text = text.replaceAll("\\s+:\\s", ": ");

        // Ký tự đầu tiên của từ sau dấu chấm là chữ hoa và các từ khác ở dạng chữ thường
        String[] sentences = text.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                String[] words = sentence.split("\\s");
                for (int i = 0; i < words.length; i++) {
                    if (!words[i].isEmpty()) {
                        if (i == 0) {
                            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                        } else {
                            words[i] = words[i].toLowerCase();
                        }
                    }
                }
                sb.append(String.join(" ", words)).append(". ");
            }
        }
        text = sb.toString().trim();

        // Không có khoảng trắng trước và sau câu hoặc cụm từ trong dấu ngoặc kép (“”)
        text = text.replaceAll("\\s+\"", "\"");
        text = text.replaceAll("\"\\s+", "\"");

        // Ký tự đầu tiên của từ trong dòng đầu tiên là chữ hoa
        String[] lines = text.split("\\r?\\n");
        if (lines.length > 0) {
            String firstLine = lines[0].trim();
            if (!firstLine.isEmpty()) {
                String[] words = firstLine.split("\\s");
                for (int i = 0; i < words.length; i++) {
                    if (!words[i].isEmpty()) {
                        words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                    }
                }
                lines[0] = String.join(" ", words);
            }
        }
        text = String.join(System.lineSeparator(), lines);

        // Không có xuống dòng giữa các đoạn
        text = text.replaceAll("\\n+", " ");

        // Không có khoảng cách giữa dấu phẩy hoặc dấu chấm và từ phía trước nó
        text = text.replaceAll("\\s+,", ",");
        text = text.replaceAll("\\s+\\.", ".");

         // Phải có dấu chấm ở cuối văn bản
        if (!text.endsWith(".")) {
            text += ".";
        }

        return text;
    }

}