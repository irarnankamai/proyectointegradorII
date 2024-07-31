package ec.edu.ups.demoJakarta.views;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoJakarta.business.GestionClientes;
import ec.edu.ups.demoJakarta.model.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named("clientes")
@RequestScoped
public class VistaClientes implements Serializable {
	
	@Inject
	private GestionClientes gClientes;
	
	
	
	private Cliente persona = new Cliente();
	
	private List<Cliente> listado;
	
	@PostConstruct
	public void init() {
		listado = gClientes.getClientes();
	}
	
	
	public List<Cliente> getListado() {
		return listado;
	}
	public void setListado(List<Cliente> listado) {
		this.listado = listado;
	}
	public Cliente getPersona() {
		return persona;
	}
	public void setPersona(Cliente persona) {
		this.persona = persona;
	}

	public String guardar() {
		System.out.println( this.persona);
		
		
		try {
			gClientes.createCliente(persona);
			return "listadoclientes?faces-redirect=true";
			}catch (Exception e) {
				e.printStackTrace();
			    return "error";
			}
		
	}
	  
    public String retroceder() {
        // Redirigir a la página contactos.xhtml
        return "contactos.xhtml?faces-redirect=true";
    }

}
