package ec.edu.ups.demoJakarta.business;

import java.util.List;

import ec.edu.ups.demoJakarta.dao.ClienteDAO;
import ec.edu.ups.demoJakarta.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {
    
    @Inject
    private ClienteDAO daoCliente;
    
    public Cliente getCliente(String cedula) throws Exception {
        if (cedula.length() != 10) {
            throw new Exception("Cedula incorrecta");
        }
        Cliente cliente = daoCliente.read(cedula);
        if (cliente == null) {
            throw new Exception("Cedula no existe");
        }
        return cliente;
    }
    
    public List<Cliente> getClientes() {
        return daoCliente.getAll();
    }
    
    public void createCliente(Cliente cliente) throws Exception {
        if (cliente.getCedula().length() != 10) {
            throw new Exception("Cedula incorrecta");
        }
        daoCliente.insert(cliente);
    }
    
    public void actualizarCliente(Cliente cliente) throws Exception {
        if (cliente.getCedula().length() != 10) {
            throw new Exception("Cedula incorrecta");
        }
        daoCliente.update(cliente);
    }
    
    public void borrarCliente(String cedula) throws Exception {
        Cliente cliente = daoCliente.read(cedula);
        if (cliente == null) {
            throw new Exception("Cliente no existe");
        }
        daoCliente.delete(cedula);
    }

    public Cliente getClienteByUserId(int userId) throws Exception {
        Cliente cliente = daoCliente.findByUserId(userId);
        if (cliente == null) {
            throw new Exception("Usuario no existe");
        }
        return cliente;
    }
}
