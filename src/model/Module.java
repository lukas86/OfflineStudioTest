package model;

public class Module {

    private int idLocal;
    private int idGlobal;
    private int panelId;
    private int moduleTypeId;
    private boolean isActive;
    private String moduleDescription;

    public Module(int idLocal, int idGlobal, int panelId, int moduleTypeId, boolean isActive, String moduleDescription) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
        this.panelId = panelId;
        this.moduleTypeId = moduleTypeId;
        this.isActive = isActive;
        this.moduleDescription = moduleDescription;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(int idGlobal) {
        this.idGlobal = idGlobal;
    }

    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    public int getModuleTypeId() {
        return moduleTypeId;
    }

    public void setModuleTypeId(int moduleTypeId) {
        this.moduleTypeId = moduleTypeId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    @Override
    public String toString() {
        return "Module{" +
                "idLocal=" + idLocal +
                ", idGlobal=" + idGlobal +
                ", panelId=" + panelId +
                ", moduleTypeId=" + moduleTypeId +
                ", isActive=" + isActive +
                ", moduleDescription='" + moduleDescription + '\'' +
                '}';
    }
}
