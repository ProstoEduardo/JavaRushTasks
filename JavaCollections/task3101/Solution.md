```java
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt"); 
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);   // переименовываем файл
        FileOutputStream fos = new FileOutputStream(allFilesContent);  //открываем поток чтения

        ArrayList<File> needFiles = new ArrayList<>();
        listf(path,needFiles);
        Collections.sort(needFiles);

        for (File file : needFiles) {
            FileInputStream fis = new FileInputStream(file);//открываем поток записи
            byte[] b = new byte[fis.available()];
            fis.read(b, 0, b.length);
            fos.write(b, 0, b.length);
            fis.close();
        }
        fos.close();
    }
    private static void listf(File path, ArrayList<File> needFiles) {    // метод определяет все файлы в директории и добавляет в лист
        File[] fList = path.listFiles();
        for (File file : fList) {
            if (file.isFile() && file.length() <= 50) {
                needFiles.add(file);
            } else if (file.isDirectory()) {
                listf(file, needFiles);
            }
        }
    }
}
```
