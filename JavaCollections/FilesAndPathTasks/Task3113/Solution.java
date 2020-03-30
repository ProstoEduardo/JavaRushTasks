public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        File file = new File(String.valueOf(path));
        if (!Files.isDirectory(path)) {
            System.out.println(file.getAbsolutePath() + " - не папка");
            return;
        }
        FileVizitor fileVizitor = new FileVizitor();
        Files.walkFileTree(path,fileVizitor);
        System.out.println("Всего папок - " + fileVizitor.foldersCount);
        System.out.println("Всего файлов - " + fileVizitor.filesCount);
        System.out.println("Общий размер - " + fileVizitor.size);
    }
    static class FileVizitor extends SimpleFileVisitor<Path> {

        private int foldersCount = -1;
        private int filesCount = 0;
        private int size = 0;

        public int getFilesCount() {
            return filesCount;
        }

        public int getFoldersCount() {
            return foldersCount;
        }

        public int getSize() {
            return size;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            size += attrs.size();
            ++filesCount;
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            ++foldersCount;
            return super.postVisitDirectory(dir, exc);
        }
    }
}
