package model;

public class Module {
    int localId;
    int globalId;
    String description;
    int type;
    int panelId;


    public Module(int localId, int globalId, String description, int type, int panelId) {
        this.localId = localId;
        this.globalId = globalId;
        this.description = description;
        this.type = type;
        this.panelId = panelId;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public int getGlobalId() {
        return globalId;
    }

    public void setGlobalId(int globalId) {
        this.globalId = globalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    @Override
    public String toString() {
        return "Module{" +
                "localId=" + localId +
                ", globalId=" + globalId +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", panelId=" + panelId +
                '}';
    }
}
