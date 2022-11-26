package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import entity.Servico;

public final class ServicoService extends Service {
	
	private static ServicoService uniqueInstance;
	public static HashMap<String,Servico> users = new HashMap<String,Servico>();
	private static AtomicInteger count = new AtomicInteger(0);

	@SuppressWarnings("unchecked")
	private ServicoService() {
		if(loadData("/servicos.top") != null) {
			users = (HashMap<String, Servico>) loadData("/servicos.top");
			count = new AtomicInteger(users.size());
		}
	}

	public static synchronized ServicoService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new ServicoService();

		return uniqueInstance;
	}
    
    public Servico findById(String id) {
        return users.get(id);
    }

    public int add(String user_id,String name, String descricao, float preco) {
        int currentId = count.incrementAndGet();
        Servico user = new Servico(Integer.valueOf(user_id),currentId, name, descricao, preco);
        users.put(String.valueOf(currentId), user);
        saveData(users,"/servicos.top");
        return currentId;
    }
    
    public void addFeedback(String servico,String rate, String descricao, String id) {
        Servico user = users.get(servico);
        user.addFeedback(rate, descricao, id);
        saveData(users,"/servicos.top");
    }
    
    public void resetFeedback(String servico) {
    	Servico user = users.get(servico);
    	user.resetFeedback();
    }

    public Servico update(String id, String name, String senha) {

    	Servico user = users.get(id);
        if (name != null) {
            user.setNome(name);
        }

        users.put(id, user);
        
        saveData(users,"/servicos.top");
        return user;

    }

    public void delete(String id) {
        users.remove(id);
        saveData(users,"/servicos.top");
    }

    public List<Servico> findAll() {
        return new ArrayList<Servico>(users.values());
    }

}
