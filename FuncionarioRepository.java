import java.util.ArrayList;

public class FuncionarioRepository {
    // A lista que vai armazenar os funcionários em memória.
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    // Variável para controlar o próximo ID a ser gerado. [cite: 24]
    private int proximoId = 1;

    /**
     * Adiciona um novo funcionário à lista, gerando um ID automático. [cite: 26]
     * @param funcionario O funcionário a ser adicionado (sem ID).
     * @return O funcionário salvo com o ID gerado.
     */
    public Funcionario adicionar(Funcionario funcionario) {
        funcionario.setId(proximoId++); // Define o ID e incrementa para o próximo. [cite: 24]
        funcionarios.add(funcionario);
        return funcionario;
    }

    /**
     * Retorna a lista de todos os funcionários cadastrados. [cite: 27]
     * @return A lista de funcionários.
     */
    public ArrayList<Funcionario> listar() {
        return this.funcionarios;
    }

    /**
     * Busca um funcionário pelo seu ID. [cite: 28]
     * @param id O ID do funcionário a ser buscado.
     * @return O funcionário encontrado ou null se não existir.
     */
    public Funcionario buscarPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null; // Retorna null se não encontrar.
    }

    /**
     * Atualiza os dados de um funcionário existente. [cite: 29]
     * @param id O ID do funcionário a ser atualizado.
     * @param funcionarioComNovosDados Objeto com os novos dados.
     * @return true se o funcionário foi atualizado, false caso contrário.
     */
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

    /**
     * Remove um funcionário da lista pelo ID.
     * @param id O ID do funcionário a ser removido.
     * @return true se o funcionário foi removido, false caso contrário.
     */
    public boolean removerPorId(int id) {
        Funcionario funcionarioParaRemover = buscarPorId(id);
        if (funcionarioParaRemover != null) {
            return funcionarios.remove(funcionarioParaRemover);
        }
        return false;
    }
}
