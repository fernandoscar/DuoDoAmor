import java.util.ArrayList;

public class ProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public Produto adicionar(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    }

    public ArrayList<Produto> listar() {
        return this.produtos;
    }

    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean atualizar(int id, Produto produtoComNovosDados) {
        Produto produtoExistente = buscarPorId(id);
        if (produtoExistente != null) {
            produtoExistente.setNome(produtoComNovosDados.getNome());
            produtoExistente.setPreco(produtoComNovosDados.getPreco());
            produtoExistente.setQuantidadeEmEstoque(produtoComNovosDados.getQuantidadeEmEstoque());
            return true;
        }
        return false;
    }

    public boolean removerPorId(int id) {
        Produto produtoParaRemover = buscarPorId(id);
        if (produtoParaRemover != null) {
            return produtos.remove(produtoParaRemover);
        }
        return false;
    }
}
