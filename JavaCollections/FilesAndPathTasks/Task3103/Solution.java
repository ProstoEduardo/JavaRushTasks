public class Solution {
    public static byte[] readBytes(String fileName) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(fileName));
        return content;
    }

    public static List<String> readLines(String fileName) throws IOException {
        List<String> listString = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        return listString;
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName),bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }
}
