package model;

public class PanelSetting {

    int panelId;

    String key;
    String value;

    //TODO
    //    String secondLevelPassword;
    //    String thirdLevelPassword;
    //    int dbVersion;
    //    String datetime;
    //    int fireAlarmCounter;
    //    int sosAlarmCounter;
    //    int gasAlarmCounter;
    //    int technicalAlarmCounter;


    public PanelSetting(int panelId, String key, String value) {
        this.panelId = panelId;
        this.key = key;
        this.value = value;
    }

    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "panelId=" + panelId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
