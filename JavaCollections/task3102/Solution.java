public class Solution {
    public static List<String> getFileTree(String root) {
       Queue<File> directoryes = new ArrayDeque<>();
        ArrayList<String> names = new  ArrayList<String>();
        directoryes.add(new File(root));

        while (directoryes.size() != 0) {
            File file = directoryes.remove();
            for (File f: file.listFiles()){
                if(f.isFile()){
                    names.add(f.getAbsolutePath());
                }
                else directoryes.add(f);
            }
        }
        return names;
    }

    public static void main(String[] args) {
    }
}
