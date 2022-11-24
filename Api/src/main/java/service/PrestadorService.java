package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import entity.Prestador;

public final class PrestadorService extends Service {
	
	private static PrestadorService uniqueInstance;
	public static HashMap<String,Prestador> users = new HashMap<String,Prestador>();
	private static AtomicInteger count = new AtomicInteger(0);

	@SuppressWarnings("unchecked")
	private PrestadorService() {
		if(loadData("/prestadores.top") != null) {
			users = (HashMap<String, Prestador>) loadData("/prestadores.top");
			count = new AtomicInteger(users.size());
		}
	}

	public static synchronized PrestadorService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new PrestadorService();

		return uniqueInstance;
	}
    
    public Prestador findById(String id) {
        return users.get(id);
    }

    public Prestador add(String name, String senha, String CPF, String email) {
        int currentId = count.incrementAndGet();
        Prestador user = new Prestador(currentId, name, senha, CPF, email);
        users.put(String.valueOf(currentId), user);
        saveData(users,"/prestadores.top");
        return user;
    }
    
    public void addServico(String prestadorId,int servicoId) {
    	Prestador user = users.get(prestadorId);
    	user.addServico(String.valueOf(servicoId));
        saveData(users,"/prestadores.top");
    }

    public Prestador update(String id, String name, String senha) {

    	Prestador user = users.get(id);
        if (name != null) {
            user.setNome(name);
        }

        if (senha != null) {
            user.setSenha(senha);
        }
        users.put(id, user);
        
        saveData(users,"/prestadores.top");
        return user;

    }

    public void delete(String id) {
        users.remove(id);
        saveData(users,"/prestadores.top");
    }

    public List<Prestador> findAll() {
        return new ArrayList<Prestador>(users.values());
    }

}
