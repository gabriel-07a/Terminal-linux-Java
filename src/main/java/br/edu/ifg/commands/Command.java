package br.edu.ifg.commands;

import br.edu.ifg.service.DirectoryManager;
import br.edu.ifg.service.FileManager;

public interface Command {
    //função padrao que vai ter em todos os comandos
    void execute(String[] args, DirectoryManager dirManager, FileManager fileManager);
}
