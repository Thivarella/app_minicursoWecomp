package com.varella.classnotes;

import android.graphics.Color;

import java.io.Serializable;

/**
 * Created by Thiago- on 08/11/2017.
 */

public class Note implements Serializable {
    private String title;
    private String description;
    private int color;

    public int getColor() { return color; }

    public void setColor(int color) { this.color = color; }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
