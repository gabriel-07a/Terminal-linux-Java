package br.edu.ifg.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//LocalDate localdate = LocalDate.now();

//essa classe vai servir para basicamente apenas armazenar os dados sobre o diretorio
//como o nome, o dir pai, a data de criacao e os dir filhos
public class Directory extends Element{

    //public String dirName;
    //public LocalDateTime creationDate;
    public List<Element> childElements;
    //a variavel dos filho é tipo element para poder adicionar diretorios e arquivos nela

    public Directory(String name, Directory parent){
       super(name, parent);
       //this.creationDate = LocalDateTime.now();
       this.childElements = new ArrayList<>();
    }

    public List<Element> getChildren(){
        //retorna os elemento filhos do diretorio
        return childElements;
    }



}
