package com.example.miguel.firebaseprueba;

public class Color {
    private String name;
    private String hex;

    public Color(){}

    public Color(String name,String hex) {
        this.name = name;
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
