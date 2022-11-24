package controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.List;

import com.google.gson.Gson;

import entity.Usuario;
import service.UsuarioService;

public class UsuarioController {
	
	private static UsuarioService usuarioService = UsuarioService.getInstance();
    private static Gson gson = new Gson();
	
	public static void IniController() {
		// POST adicionar usuario
        post("/usuario", (request, response) -> {
        	
        	if(	!request.queryParams("nome").isBlank() && !request.queryParams("senha").isBlank() &&
        		!request.queryParams("CPF").isBlank() && !request.queryParams("email").isBlank()) 
        	{
        		String nome = request.queryParams("nome");
                String senha = request.queryParams("senha");
                String CPF = request.queryParams("CPF");
                String email = request.queryParams("email");
                usuarioService.add(nome, senha, CPF, email);
                response.status(201);
                return "Usuario criado";
        	}
        	response.status(500);
        	return "falta de dados";    		
            
        });

        // GET usuario por id
        get("/usuario/:id", (request, response) -> {
        	Usuario usuario = usuarioService.findById(request.params(":id"));
            if (usuario != null) {
                return gson.toJson(usuario);
            } else {
                response.status(404); // 404 Not found
                return "Usuario não encontrado";
            }
        });

        // Get todos os usuarios
        get("/usuarios", (request, response) -> {
            List<Usuario> result = usuarioService.findAll();
            if (result.isEmpty()) {
                return "Usuario não encontrado";
            } else {
                return gson.toJson(usuarioService.findAll());
            }
        });

        // PUT modificar usuario
        put("/usuario/:id", (request, response) -> {
            String id = request.params(":id");
            Usuario usuario = usuarioService.findById(id);
            if (usuario != null) {
                String name = request.queryParams("name");
                String email = request.queryParams("email");
                usuarioService.update(id, name, email);
                return "usuario with id " + id + " is updated!";
            } else {
                response.status(404);
                return "Usuario não encontrado";
            }
        });

        // DELETE deletar usuario
        delete("/usuario/:id", (request, response) -> {
            String id = request.params(":id");
            Usuario usuario = usuarioService.findById(id);
            if (usuario != null) {
                usuarioService.delete(id);
                return "usuario with id " + id + " is deleted!";
            } else {
                response.status(404);
                return "Usuario não encontrado";
            }
        });
	}
}
