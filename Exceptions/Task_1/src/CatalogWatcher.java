import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

class CatalogWatcher {
    private Path currentPath = Paths.get("src");

    CatalogWatcher() {
        currentPath = currentPath.toAbsolutePath();
    }

    void showPath() {
        System.out.println("Absolute path is: " + currentPath.toString());
        try {
            Arrays.stream(currentPath.toFile().listFiles(File::isDirectory))
                    .forEach(a -> System.out.println(a.getName()));
        } catch (NullPointerException e) {
            System.out.println("This directory does not exist!");
            currentPath = currentPath.getParent();
        }
    }

    void showFiles() {
        Arrays.stream(currentPath.toFile().listFiles(a -> !(a.isDirectory())))
                .forEach(a -> System.out.println(a.getName()));
    }

    void moveUp() {
        currentPath = currentPath.getParent();
        showPath();
    }
    void moveToSub(String StrPath) {
        currentPath = currentPath.resolve(StrPath);
        showPath();
    }

    void createTextFile(String fileName) {
        Path filePath = currentPath.resolve(fileName);
        try {
            Files.createFile(filePath);
        } catch (FileAlreadyExistsException a) {
            a.printStackTrace();
            System.out.println("File already exist");
        }
        catch (IOException a) {
            a.printStackTrace();
        }
    }

    void readFile(String fileName) {
        Path filePath = currentPath.resolve(fileName);
        try {
            Files.readAllLines(filePath).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFile(String fileName, String message) {
        Path filePath = currentPath.resolve(fileName);
        try (FileWriter fileWriter = new FileWriter(filePath.toFile(),true)) {
            fileWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void deleteFile(String fileName) {
        Path filePath = currentPath.resolve(fileName);
        if (Files.isDirectory(filePath)) {
            System.out.println("You want to delete directory. DO NOT DO IT.");
        } else {
            try {
                Files.delete(filePath);
                System.out.println("File deleted");
            } catch (NoSuchFileException a) {
                a.printStackTrace();
                System.out.println("There are no file with this name");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
