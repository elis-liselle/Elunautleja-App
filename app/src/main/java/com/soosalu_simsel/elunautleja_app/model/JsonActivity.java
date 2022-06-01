package com.soosalu_simsel.elunautleja_app.model;

public class JsonActivity {

    private int id;
    private String toDo;

    public JsonActivity(int id, String toDo) {
        this.id = id;
        this.toDo = toDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
