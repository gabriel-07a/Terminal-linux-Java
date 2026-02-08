package br.edu.ifg.model;

import br.edu.ifg.service.DirectoryManager;

import java.time.LocalDateTime;

public abstract class Element {
    protected String name;
    protected Directory parent;

    public Element(String name, Directory parent){
        this.name = name;
        this.parent = parent;

    }

    public String getName(){
        return name;
    }
    public Directory getParent() {
        return parent;
    }

    // (Opcional) Setter para renomear (comando mv)
    public void setName(String name) {
        this.name = name;
    }

    // (Opcional) Setter para mover de pasta (comando mv)
    public void setParent(Directory parent) {
        this.parent = parent;
    }

}
