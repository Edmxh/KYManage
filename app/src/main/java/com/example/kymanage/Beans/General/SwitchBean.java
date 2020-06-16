package com.example.kymanage.Beans.General;

public class SwitchBean {
    private boolean switch1;
    private boolean switch2;

    public SwitchBean() {
    }

    public SwitchBean(boolean switch1, boolean switch2) {
        this.switch1 = switch1;
        this.switch2 = switch2;
    }

    public boolean isSwitch1() {
        return switch1;
    }

    public void setSwitch1(boolean switch1) {
        this.switch1 = switch1;
    }

    public boolean isSwitch2() {
        return switch2;
    }

    public void setSwitch2(boolean switch2) {
        this.switch2 = switch2;
    }
}
