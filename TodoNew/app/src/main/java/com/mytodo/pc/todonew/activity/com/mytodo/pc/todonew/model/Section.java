package com.mytodo.pc.todonew.activity.com.mytodo.pc.todonew.model;

class Section {
    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String d;
    public String e;
    public Section(String menuItemD, String menuItemE, String s) {

        this.d=menuItemD;
        this.e=menuItemE;

    }
}
