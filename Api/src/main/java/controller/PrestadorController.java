package controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.List;

import com.google.gson.Gson;

import entity.Prestador;
import service.PrestadorService;

public class PrestadorController {
	
	private static PrestadorService userService = PrestadorService.getInstance();
    private static Gson gson = new Gson();
	
	public static void IniController() {
		// POST adicionar Prestador
        post("/prestador", (request, response) -> {
        	
        	if(	!request.queryParams("nome").isBlank() && !request.queryParams("senha").isBlank() &&
        		!request.queryParams("CPF").isBlank() && !request.queryParams("email").isBlank()) 
        	{
        		String nome = request.queryParams("nome");
                String senha = request.queryParams("senha");
                String CPF = request.queryParams("CPF");
                String email = request.queryParams("email");
                userService.add(nome, senha, CPF, email);
                response.status(201);
                return "Prestador criado";
        	}
        	response.status(500);
        	return "falta de dados";    		
            
        });
        
        // GET Prestador por id
        get("/prestador/:id", (request, response) -> {
        	Prestador user = userService.findById(request.params(":id"));
            if (user != null) {
                return gson.toJson(user);
            } else {
                response.status(404); // 404 Not found
                return "Prestador não encontrado";
            }
        });

        // Get todos os Prestadors
        get("/prestadores", (request, response) -> {
            List<Prestador> result = userService.findAll();
            if (result.isEmpty()) {
                return "Prestador não encontrado";
            } else {
                return gson.toJson(userService.findAll());
            }
        });

        // PUT modificar Prestador
        put("/prestador/:id", (request, response) -> {
            String id = request.params(":id");
            Prestador user = userService.findById(id);
            if (user != null) {
                String name = request.queryParams("name");
                String email = request.queryParams("email");
                userService.update(id, name, email);
                return "user with id " + id + " is updated!";
            } else {
                response.status(404);
                return "Prestador não encontrado";
            }
        });

        // DELETE deletar Prestador
        delete("/prestador/:id", (request, response) -> {
            String id = request.params(":id");
            Prestador user = userService.findById(id);
            if (user != null) {
                userService.delete(id);
                return "user with id " + id + " is deleted!";
            } else {
                response.status(404);
                return "Prestador não encontrado";
            }
        });
	}
}
