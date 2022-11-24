package controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.List;

import com.google.gson.Gson;

import entity.Servico;
import service.PrestadorService;
import service.ServicoService;

public class ServicoController {
	
	private static ServicoService servicoService = ServicoService.getInstance();
	private static PrestadorService prestadorService = PrestadorService.getInstance();
    private static Gson gson = new Gson();
	
	public static void IniController() {
		// POST adicionar Servico
        post("/prestador/:id", (request, response) -> {
        	
        	if(	!request.queryParams("nome").isBlank() && !request.queryParams("descricao").isBlank() &&
        		!request.queryParams("preco").isBlank())
        	{
        		String nome = request.queryParams("nome");
                String descricao = request.queryParams("descricao");
                float preco = Float.parseFloat(request.queryParams("preco"));
                prestadorService.addServico(request.params(":id"), servicoService.add(nome, descricao, preco));
                response.status(201);
                return "Servico criado";
        	}
        	response.status(500);
        	return "falta de dados";    		
            
        });

        // GET Servico por id
        get("/servico/:id", (request, response) -> {
        	Servico servico = servicoService.findById(request.params(":id"));
            if (servico != null) {
                return gson.toJson(servico);
            } else {
                response.status(404); // 404 Not found
                return "Servico não encontrado";
            }
        });

        // Get todos os Servicos
        get("/servicos", (request, response) -> {
            List<Servico> result = servicoService.findAll();
            if (result.isEmpty()) {
                return "Servico não encontrado";
            } else {
                return gson.toJson(servicoService.findAll());
            }
        });

        // PUT modificar Servico
        put("/servico/:id", (request, response) -> {
            String id = request.params(":id");
            Servico servico = servicoService.findById(id);
            if (servico != null) {
                String name = request.queryParams("name");
                String email = request.queryParams("email");
                servicoService.update(id, name, email);
                return "servico with id " + id + " is updated!";
            } else {
                response.status(404);
                return "Servico não encontrado";
            }
        });

        // DELETE deletar Servico
        delete("/servico/:id", (request, response) -> {
            String id = request.params(":id");
            Servico servico = servicoService.findById(id);
            if (servico != null) {
                servicoService.delete(id);
                return "servico with id " + id + " is deleted!";
            } else {
                response.status(404);
                return "Servico não encontrado";
            }
        });
	}
}
