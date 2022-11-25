package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import entity.Usuario;

public final class UsuarioService extends Service {
	
	private static UsuarioService uniqueInstance;
	public static HashMap<String,Usuario> users = new HashMap<String,Usuario>();
	private static AtomicInteger count = new AtomicInteger(0);

	@SuppressWarnings("unchecked")
	private UsuarioService() {
		if(loadData("/usuarios.top") != null) {
			users = (HashMap<String, Usuario>) loadData("/usuarios.top");
			count = new AtomicInteger(users.size());
		}
	}

	public static synchronized UsuarioService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new UsuarioService();

		return uniqueInstance;
	}
    
    public Usuario findById(String id) {
        return users.get(id);
    }
    
    public Usuario findByEmail(String Email) {
    	
    	for (Entry<String, Usuario> entry : users.entrySet()) {
            if (entry.getValue().getEmail().equals(Email)) {
                return users.get(entry.getKey());
            }
        }
    	return null;
        
    }

    public Usuario add(String name, String senha, String CPF, String email) {
        int currentId = count.incrementAndGet();
        Usuario user = new Usuario(currentId, name, senha, CPF, senha);
        users.put(String.valueOf(currentId), user);
        saveData(users,"/usuarios.top");
        return user;
    }

    public Usuario update(String id, String name, String senha) {

    	Usuario user = users.get(id);
        if (name != null) {
            user.setNome(name);
        }

        if (senha != null) {
            user.setSenha(senha);
        }
        users.put(id, user);
        
        saveData(users,"/usuarios.top");
        return user;

    }

    public void delete(String id) {
        users.remove(id);
        saveData(users,"/usuarios.top");
    }

    public List<Usuario> findAll() {
        return new ArrayList<Usuario>(users.values());
    }

}
