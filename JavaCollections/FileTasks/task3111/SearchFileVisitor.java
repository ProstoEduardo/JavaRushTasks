public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = 0;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentStr = new String(Files.readAllBytes(file)); // содержимое текущего файла в виде строки

        boolean filter1 = true;
        boolean filter2 = true;

        if (partOfName != null && !file.getFileName().toString().contains(partOfName) ||
                partOfContent != null && !contentStr.contains(partOfContent))
            filter1 = false;

        if (minSize != 0 && !(content.length > minSize) ||
                maxSize != 0 && !(content.length < maxSize))
            filter2 = false;

        if(filter1 && filter2)
            getFoundFiles().add(file);
        return super.visitFile(file, attrs);
    }

    void setPartOfName(String amigo) {
        this.partOfName = amigo;
    }

    void setPartOfContent(String programmer) {
        this.partOfContent = programmer;
    }

    void setMinSize(int i) {
        this.minSize = i;
    }

    void setMaxSize(int i) {
        this.maxSize = i;
    }

    List<Path> getFoundFiles() {
        return foundFiles;
    }
}
