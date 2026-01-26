package br.edu.ifg.service;

import br.edu.ifg.commands.Command;

import java.util.Arrays;
import java.util.HashMap;

//Esse vai ser o tradutor, oq vai receber o texto bruto e descobre oq tem que ser feito
public class CommandHandler {
    DirectoryManager dirManager;
    FileManager fileManager;


    HashMap<String, Command> comandos = new HashMap<>();

    public CommandHandler(DirectoryManager dir, FileManager file){
        this.dirManager = dir;
        this.fileManager = file;
    }


    public void execute(String input){

        String[] args = input.trim().split(" ");
        //System.out.println(Arrays.toString(this.args));


        //agora nesse caso a gente tem que fazer um jeito de identificar o comando
        //se ele não for identificado é só printar ele e dizer comando não encontrado
        Command command = CommandFactory.getComand(args[0]);
        //System.out.println(command);

        //verifica se o comando é nullo
        if (command != null){
            //esse execute vai rodar no objeto que veio da factory
            command.execute(args, dirManager, fileManager);
        }else{
            //printa igual ao terminal do linux
            System.out.println(args[0] + ": comando não encontrado");
        }




    }



}
