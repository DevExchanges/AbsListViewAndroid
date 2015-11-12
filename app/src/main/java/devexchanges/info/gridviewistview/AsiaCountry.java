package devexchanges.info.gridviewistview;

public class AsiaCountry {

    private String name;
    private int flagResource;
    private String vietnameseName;

    public AsiaCountry (int image, String name, String viName) {
        this.flagResource = image;
        this.name = name;
        this.vietnameseName = viName;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public String getVietnameseName() {
        return vietnameseName;
    }

    public String getName() {
        return name;
    }
}
