import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SequentialFileCopy {
    public static void main(String[] args) {
        String sourceFileName = "source.txt"; // Имя исходного файла
        String destinationPath = "destination/"; // Путь к папке назначения
        String destinationFileName = "destination.txt"; // Имя файла назначения

        try (FileInputStream fileInputStream = new FileInputStream(sourceFileName);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationPath + destinationFileName)) {

            int data;
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }

            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
