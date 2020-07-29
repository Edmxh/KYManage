package com.example.kymanage.Beans.UpdateApp;

public class UpdateAppRep {
    private boolean update;
    private String version;

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
