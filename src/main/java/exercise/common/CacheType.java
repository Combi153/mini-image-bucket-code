package exercise.common;

public enum CacheType {

    IMAGES("images", 1);

    private final String cacheName;
    private final int maximumSize;

    CacheType(String cacheName, int maximumSize) {
        this.cacheName = cacheName;
        this.maximumSize = maximumSize;
    }

    public String cacheName() {
        return cacheName;
    }

    public int maximumSize() {
        return maximumSize;
    }
}
