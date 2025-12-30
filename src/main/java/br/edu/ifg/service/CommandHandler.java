package br.edu.ifg.service;

import br.edu.ifg.commands.Command;

import java.util.Arrays;
import java.util.HashMap;

//Esse vai ser o tradutor, oq vai receber o texto bruto e descobre oq tem que ser feito
public class CommandHandler {
    DirectoryManager dirManager;
    FileManager fileManager;
    String[] args;

    HashMap<String, Command> comandos = new HashMap<>();

    public CommandHandler(DirectoryManager dir, FileManager file){
        this.dirManager = dir;
        this.fileManager = file;
    }


    public void execute(String argsEntrada){
        this.args = argsEntrada.trim().split(" ");
        //System.out.println(Arrays.toString(this.args));

        //mano esse isBlank é um isempty maiss inteligente, ele desconsidera os espaços em branco
        if(argsEntrada != null || argsEntrada.isBlank()){
            //agora nesse caso a gente tem que fazer um jeito de identificar o comando
            //se ele não for identificado é só printar ele e dizer comando não encontrado
            Command command = CommandFactory.getComand(this.args[0]);
            System.out.println(command);

        }else{
            //nesse caso no terminal do ubuntu ele só não faz nada msm
            //ele só prita o diretorio atual dnv
        }
    }



}
