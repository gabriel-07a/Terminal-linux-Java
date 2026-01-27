package br.edu.ifg.service;

import br.edu.ifg.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    //essa classe basicamente cria os objetos

    private static Map<String, Command> nomeComando = new HashMap<>();

    static{
        //a string do coamando é a chave e o objeto é o valor
        nomeComando.put("cat", new CatCommand());
        nomeComando.put("cd", new CdCommand());
        nomeComando.put("echo", new EchoCommand());
        nomeComando.put("exit", new ExitCommand());
        nomeComando.put("history", new HistoryCommand());
        nomeComando.put("ls", new LsCommand());
        nomeComando.put("mkdir", new MkdirCommand());  ;
        nomeComando.put("pwd", new PwdCommand());
        nomeComando.put("rm", new RmCommand());
        nomeComando.put("touch", new TouchCommand());

    }

    public static Command getComand(String comands){

        //o get, que é da classe Map, vai retonar um valor (que nesse caso é o objeto)
        //com base na chave (que nesse casso é a string em si)
        return nomeComando.get(comands.toLowerCase());
    }

}
