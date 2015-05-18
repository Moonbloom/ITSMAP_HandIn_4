package grp14.itsmap.com.hi414.models;

public class AndroidLevel {

    //region Variables
    private String name;
    private String apiLevel;
    private String versionNumber;
    private String description;
    private int imageResource;
    //endregion

    //region Constructor
    public AndroidLevel(String name, String apiLevel, String versionNumber, String description, int imageResource) {
        this.name = name;
        this.apiLevel = apiLevel;
        this.versionNumber = versionNumber;
        this.description = description;
        this.imageResource = imageResource;
    }
    //endregion

    //region Name
    public String getName() {
        return name;
    }
    //endregion

    //region ApiLevel
    public String getApiLevel() {
        return apiLevel;
    }
    //endregion

    //region VersionNumber
    public String getVersionNumber() {
        return versionNumber;
    }
    //endregion

    //region Description
    public String getDescription() {
        return description;
    }
    //endregion

    //region ImageResource
    public int getImageResource() {
        return imageResource;
    }
    //endregion
}