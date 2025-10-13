import java.util.ArrayList;

public class ClienteRepository {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public Cliente adicionar(Cliente cliente) {
        cliente.setId(proximoId++);
        clientes.add(cliente);
        return cliente;
    }

    public ArrayList<Cliente> listar() {
        return this.clientes;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean atualizar(int id, Cliente clienteComNovosDados) {
        Cliente clienteExistente = buscarPorId(id);
        if (clienteExistente != null) {
            clienteExistente.setNome(clienteComNovosDados.getNome());
            clienteExistente.setTelefone(clienteComNovosDados.getTelefone());
            clienteExistente.setEmail(clienteComNovosDados.getEmail());
            return true;
        }
        return false;
    }

    public boolean removerPorId(int id) {
        Cliente clienteParaRemover = buscarPorId(id);
        if (clienteParaRemover != null) {
            return clientes.remove(clienteParaRemover);
        }
        return false;
    }
}
