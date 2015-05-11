package grp14.itsmap.com.hi414.models;

public class AndroidLevel {

    private String name;
    private String apiLevel;
    private String versionNumber;
    private String description;

    public AndroidLevel(String name, String apiLevel, String versionNumber, String description) {
        this.name = name;
        this.apiLevel = apiLevel;
        this.versionNumber = versionNumber;
        this.description = description;
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
}