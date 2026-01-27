package br.edu.ifg.commands;

import br.edu.ifg.service.DirectoryManager;
import br.edu.ifg.service.FileManager;

public class MkdirCommand implements Command {
    @Override
    public void execute(String[] args, DirectoryManager dirManager, FileManager fileManager) {
        if (args.length > 2){
            System.out.println("mkdir: sobra operando");
            return;
        }

        if(args.length == 1){
            System.out.println("mkdir: falta operando");
            return;
        }

        String nomeDoDiretorio = args[1];

        dirManager.createDirectory(nomeDoDiretorio);


    }
}
