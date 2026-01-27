package br.edu.ifg.service;

import br.edu.ifg.model.Directory;
import br.edu.ifg.model.Element;

//esse vai ser o que armzena o diretorio atual e a raiz
public class DirectoryManager {
    private Directory root; //Diretorio raiz
    private Directory currentDirectory; //Diretorio atual


    public DirectoryManager(){
        this.root = new Directory("/", null);
        this.currentDirectory = this.root;
    }

    //retorna o diretoria autal
    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void createDirectory(String dirName){
        //Cria o diretorio e retorna uma string


        for(Element child : currentDirectory.getChildren()){
            if(child.getName().equals(dirName) && child instanceof Directory){
                System.out.println("mkdir: não foi possível criar o diretório \"" + dirName + "\": Arquivo existe");
                return;
            }
        }

        Directory dir = new Directory(dirName, currentDirectory);

        currentDirectory.getChildren().add(dir);



    }

    //basicamente vai ser usado para quando eu querer entrar em um diretorio
    public void enterDirectory(Directory dir){
        if(dir != null){
            this.currentDirectory = dir;
        }
    }

    public void leaveDirectory(Directory dir){
        //if(dir.getParent() != null){
         //   this.currentDirectory = dir.getParent();
        //}//else {
            //se não ele ja esta na raiz
            //pode ver oq fazer aq sla

        //}
    }

}
