public class MainApp {
    public static void main(String[] args) {
        FileDownloader fileDownloader1 = new FileDownloader("test.txt", 178.00, 22.3);
        FileDownloader fileDownloader2 = new FileDownloader("video.mp4", 220.00, 14.8);
        FileDownloader fileDownloader3 = new FileDownloader("music.mp3", 70.00, 3.2);
        FileDownloader fileDownloader4 = new FileDownloader("kq.json", 415.00, 42);
        Thread thread1 = new Thread(fileDownloader1);
        Thread thread2 = new Thread(fileDownloader2);
        Thread thread3 = new Thread(fileDownloader3);
        Thread thread4 = new Thread(fileDownloader4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
