import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    /**
     * Doc content trong file.
     *
     * @param path p
     * @return n
     */
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * Ghi de content trong file.
     *
     * @param path    p
     * @param content n
     */
    public static void writeContentToFile(String path, String content) {
        try (BufferedWriter writeToFile = new BufferedWriter(new FileWriter(path))) {
            writeToFile.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * In vao cuoi file.
     *
     * @param path    p
     * @param content n
     */
    public static void appendContentToFile(String path, String content) {
        try (BufferedWriter writeToFile = new BufferedWriter(new FileWriter(path, true))) {
            writeToFile.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tim kiem thu muc.
     *
     * @param folderPath p
     * @param fileName   n
     * @return a
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    return file;
                }
            }
        }

        return null;
    }


}