package ec.edu.ups.demoJakarta.business;

import java.util.List;

import ec.edu.ups.demoJakarta.dao.*;
import ec.edu.ups.demoJakarta.model.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	@Inject
	private ClienteDAO daoCliente;  

	@Inject
	private UsuarioDAO daoUsuario;
	
	@PostConstruct
	public void init() {
		
	}
}
