package exercise.application;

import org.springframework.stereotype.Service;

@Service
public class SystemService {

    public String calculateMemoryUsage() {
        Runtime.getRuntime().gc();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        return makeMessage(freeMemory, totalMemory);
    }

    private String makeMessage(long freeMemory, long totalMemory) {
        return "total(byte) : " + totalMemory + System.lineSeparator() +
                "free(byte) : " + freeMemory + System.lineSeparator() +
                "total - free(byte) : " + (totalMemory - freeMemory) + System.lineSeparator() +
                System.lineSeparator() +
                "total(MB) : " + bytesToMegabytes(totalMemory) + System.lineSeparator() +
                "free(MB) : " + bytesToMegabytes(freeMemory) + System.lineSeparator() +
                "total - free(MB) : " + bytesToMegabytes(totalMemory - freeMemory);
    }

    private double bytesToMegabytes(long bytes) {
        return (double) bytes / (1024 * 1024);
    }
}
