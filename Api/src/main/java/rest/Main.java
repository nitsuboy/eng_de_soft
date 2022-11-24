package rest;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.after;

import controller.PrestadorController;
import controller.ServicoController;
import controller.UsuarioController;
import spark.Filter;

public class Main {


    public static void main(String[] args) {

        // Start embedded server at this port
        port(8080);
        
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });


        // Main Page, welcome
        get("/", (request, response) -> "ativo e funcionando");
        
        // Controller Usuario 
        UsuarioController.IniController();
        
        // Controller prestador
        PrestadorController.IniController();
        
        // Controller servico
        ServicoController.IniController();
          
    }
}