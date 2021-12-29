package model;

public class Panel {

    private int id;
    private String description;
    private boolean isLocal;
    private boolean isActive;

    public Panel(int id, String description, boolean isLocal, boolean isActive) {
        this.id = id;
        this.description = description;
        this.isLocal = isLocal;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Panel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isLocal=" + isLocal +
                ", isActive=" + isActive +
                '}';
    }
}
