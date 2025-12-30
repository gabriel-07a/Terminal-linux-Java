package br.edu.ifg.commands;

import br.edu.ifg.service.DirectoryManager;
import br.edu.ifg.service.FileManager;

import java.util.List;

public class PwdCommand implements Command{
    private List<String> listaNomes;
    private String currDir;

    @Override
    public void execute(String[] args, DirectoryManager dirManager, FileManager fileManager) {
        do{
            //coloquei to string de sacanagem
            //mas esse addfirst ajuda muito
            listaNomes.addFirst(dirManager.toString());
        }while(!dirManager.getCurrentDirectory().equals("/"));

        System.out.println(listaNomes);
    }
}
