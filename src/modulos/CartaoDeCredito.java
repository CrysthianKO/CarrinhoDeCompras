package modulos;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private double limite;
    private double saldo;
    private List<Produto> listaDeProdutos;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeProdutos = new ArrayList<>();
    }

    public boolean insereProduto(Produto produto) {
        if (this.saldo > produto.getValor()) {
            this.saldo -= produto.getValor();
            this.listaDeProdutos.add(produto);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }
}
