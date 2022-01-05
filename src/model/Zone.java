package model;

public class Zone {
    private int zoneNumber;
    private String description;
    private int panelId;

    public Zone(int zoneNumber, String description, int panelId) {
        this.zoneNumber = zoneNumber;
        this.description = description;
        this.panelId = panelId;
    }

    public int getZoneNumber() {
        return zoneNumber;
    }

    public void setZoneNumber(int zoneNumber) {
        this.zoneNumber = zoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneNumber=" + zoneNumber +
                ", description='" + description + '\'' +
                ", panelId=" + panelId +
                '}';
    }
}
