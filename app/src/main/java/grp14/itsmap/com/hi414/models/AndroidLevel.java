package grp14.itsmap.com.hi414.models;

public class AndroidLevel {

    private String name;
    private String apiLevel;
    private String versionNumber;
    private String description;
    private int imageResource;

    public AndroidLevel(String name, String apiLevel, String versionNumber, String description, int imageResource) {
        this.name = name;
        this.apiLevel = apiLevel;
        this.versionNumber = versionNumber;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getApiLevel() {
        return apiLevel;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}