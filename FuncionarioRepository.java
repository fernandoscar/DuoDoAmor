import java.util.ArrayList;

public class FuncionarioRepository {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private int proximoId = 1;

    public Funcionario adicionar(Funcionario funcionario) {
        funcionario.setId(proximoId++);
        funcionarios.add(funcionario);
        return funcionario;
    }

    public ArrayList<Funcionario> listar() {
        return this.funcionarios;
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public boolean atualizar(int id, Funcionario funcionarioComNovosDados) {
        Funcionario funcionarioExistente = buscarPorId(id);
        if (funcionarioExistente != null) {
            funcionarioExistente.setNome(funcionarioComNovosDados.getNome());
            funcionarioExistente.setSalario(funcionarioComNovosDados.getSalario());
            funcionarioExistente.setMatricula(funcionarioComNovosDados.getMatricula());
            return true;
        }
        return false;
    }

    public boolean removerPorId(int id) {
        Funcionario funcionarioParaRemover = buscarPorId(id);
        if (funcionarioParaRemover != null) {
            return funcionarios.remove(funcionarioParaRemover);
        }
        return false;
    }
}

