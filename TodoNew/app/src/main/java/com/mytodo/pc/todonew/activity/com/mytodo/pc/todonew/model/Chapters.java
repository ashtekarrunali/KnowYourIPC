package com.mytodo.pc.todonew.activity.com.mytodo.pc.todonew.model;

import java.util.ArrayList;
import java.util.List;

public class Chapters {


    public String a;
    public String b;
    public String c;
   public List<D> listd=new ArrayList<>();

    public List<D> getListd() {
        return listd;
    }

    @Override
    public String toString() {
        return "Chapters{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", listd=" + listd +
                '}';
    }

    public void setListd(List<D> listd) {
        this.listd = listd;
    }
    //  public String d;


    public Chapters(String menuItemA, String menuItemB, String menuItemC) {
        this.a=menuItemA;
        this.b=menuItemB;
        this.c=menuItemC;

    }

    /* public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
*/



    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public static class D{
        String title,D,E,F;

        @Override
        public String toString() {
            return "D{" +
                    "title='" + title + '\'' +
                    ", D='" + D + '\'' +
                    ", E='" + E + '\'' +
                    ", F='" + F + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getD() {
            return D;
        }

        public void setD(String d) {
            D = d;
        }

        public String getE() {
            return E;
        }

        public void setE(String e) {
            E = e;
        }

        public String getF() {
            return F;
        }

        public void setF(String f) {
            F = f;
        }
    }


}




