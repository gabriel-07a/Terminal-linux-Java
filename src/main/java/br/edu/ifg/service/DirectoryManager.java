package br.edu.ifg.service;

import br.edu.ifg.model.Directory;
import br.edu.ifg.model.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public String createDirectory(String dirName){
        //Cria o diretorio e retorna uma string



        for (Element child : currentDirectory.getChildren()) {
            if (child.getName().equals(dirName)) {
                // Se achou alguma coisa com esse nome retorna erro.
                return "mkdir: não foi possível criar o diretório \"" + dirName + "\": O arquivo já existe";
            }
        }

        Directory dir = new Directory(dirName, currentDirectory);
        currentDirectory.getChildren().add(dir);

        return "Diretório criado com sucesso.";
    }

    //para mudar de diretorio
    public void changeDirectory(Directory target) {
        if (target != null) {
            this.currentDirectory = target;
        }
    }

    //para ajudar no comando cd
    public Directory getSubDiretorio(String nome) {
        for (Element child : currentDirectory.getChildren()) {
            if (child.getName().equals(nome) && child instanceof Directory) {
                return (Directory) child;
            }
        }
        return null; // Não achou
    }


    //para pegar o caminho do diretorio
    public String getCurrentPath() {
        if (currentDirectory == root) {
            return "/";
        }

        List<String> pathParts = new ArrayList<>();
        Directory temp = currentDirectory;

        //vai caminhando ate chegar no null
        while (temp != null && temp.getParent() != null) {
            pathParts.add(temp.getName());
            temp = temp.getParent();
        }

        //inverte o caminho subido
        Collections.reverse(pathParts);

        // junta tudo com barras
        return "/" + String.join("/", pathParts);
    }

}
