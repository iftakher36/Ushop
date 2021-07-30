package com.changetech.ushop.ViewModel;

public class ModelProductColour {
    int color;
    Boolean check;

    public ModelProductColour(int color) {
        this.color = color;
        this.check = false;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
