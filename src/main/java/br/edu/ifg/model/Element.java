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

}
