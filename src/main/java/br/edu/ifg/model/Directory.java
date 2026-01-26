package br.edu.ifg.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//LocalDate localdate = LocalDate.now();

//essa classe vai servir para basicamente apenas armazenar os dados sobre o diretorio
//como o nome, o dir pai, a data de criacao e os dir filhos
public class Directory {

    public String dirName;
    public Element Parent; //elemento pai
    public LocalDateTime creationDate;
    public List<Element> childElements;

    public Directory(String name, Element parent){
       this.dirName = name;
       this.Parent = parent;
       this.creationDate = LocalDateTime.now();
       this.childElements = new ArrayList<>();
    }

    public List<Element> getChildren(){
        return childElements;
    }



}
