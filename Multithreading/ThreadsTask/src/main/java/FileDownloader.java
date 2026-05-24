public class FileDownloader implements Runnable {

    private String fileName;
    private double fileSize;
    private double downloadSpeed;

    public FileDownloader(String fileName, double fileSize, double downloadSpeed) {
        fileNameValidation(fileName);
        fileSizeValidation(fileSize);
        downloadSpeedValidation(downloadSpeed);
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.downloadSpeed = downloadSpeed;
    }

    @Override
    public void run() {
        double downloadedSize = 0.0;
        while (downloadedSize < fileSize) {
            try {
                Thread.sleep(1000);
                downloadedSize = Math.min(downloadedSize + downloadSpeed, fileSize);
                System.out.printf("%s: %.1f МБ из %.1f МБ (%.1f%%)%n",
                        fileName, downloadedSize, fileSize, getPercent(downloadedSize));
            } catch (InterruptedException ex) {
                System.out.println("Загрузка " + fileName + " была прервана");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(fileName + " загружен.");
    }

    private double getPercent(double downloadedSize) {
        return (downloadedSize / fileSize) * 100;
    }

    private void fileNameValidation(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Название файла не может быть пустым.");
        }
    }

    private void fileSizeValidation(double fileSize) {
        if (fileSize < 0) {
            throw new IllegalArgumentException("Размер файла не может быть меньше нуля.");
        }
    }

    private void downloadSpeedValidation(double downloadSpeed) {
        if (downloadSpeed < 0) {
            throw new IllegalArgumentException("Скорость загрузка файла не может быть меньше нуля.");
        }
    }
}
