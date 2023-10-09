import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ParallelFileCopy {
    public static void main(String[] args) {
        String sourceFileName = "source.txt"; // Имя исходного файла
        String destinationPath = "destination/"; // Путь к папке назначения
        String destinationFileName = "destination.txt"; // Имя файла назначения

        Thread thread1 = new Thread(() -> copyFile(sourceFileName, destinationPath + destinationFileName));
        Thread thread2 = new Thread(() -> copyFile(sourceFileName, destinationPath + destinationFileName));

        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Файлы успешно скопированы.");
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс.");
    }

    private static void copyFile(String source, String destination) {
        try (FileInputStream fileInputStream = new FileInputStream(source);
             FileOutputStream fileOutputStream = new FileOutputStream(destination)) {

            int data;
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
