import java.io.File;
import java.util.Scanner;

public class Task0 {

    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Please provide file path: ");
            String path = reader.nextLine();
            getPath(path);
        } else {
            getPath(args[0]);
        }
    }

    private static void terminate(String msg) {
        System.out.println(msg);
        System.exit(0);
    }

    private static void getPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            terminate("Invalid path");
        }

        int countFolders = 0;
        int countFiles = 0;

        File[] fileList = file.listFiles();
        if (fileList == null) {
            System.out.println("Something went wrong with folder:" + path);
            return;
        }

        for (File currentFile : fileList) {
            if (currentFile.isFile()) {
                countFiles++;
            }

            if (currentFile.isDirectory()) {
                countFolders++;
                getPath(currentFile.getAbsolutePath());
            }
        }

        if (file.isDirectory()) {
            System.out.println(String.format("Folder %s - contain: %s files, %s folders", path, countFiles, countFolders));
        }
    }
}
