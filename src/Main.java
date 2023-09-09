import modulos.CartaoDeCredito;
import modulos.Produto;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Digite o limite do cartão:");
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(leitor.nextDouble());

        while (opcao != 1) {

            System.out.println("Digite a descricao do produto:");
            String descricao = leitor.next();

            System.out.println("Digite o valor do produto:");
            Double valor = leitor.nextDouble();

            boolean produtoCriado = cartaoDeCredito.insereProduto(new Produto(descricao, valor));

            if (produtoCriado) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para continuar ou 1 para sair:");
                opcao = leitor.nextInt();
            } else {
                System.out.println("Saldo insuficiente.");
                System.out.println("Saindo da aplicação.");
                break;
            }
        }
        System.out.println(cartaoDeCredito.getListaDeProdutos());

        Collections.sort(cartaoDeCredito.getListaDeProdutos());


        System.out.println("*************************");
        System.out.println("Compras realizadas: \n");
        for (Produto produto : cartaoDeCredito.getListaDeProdutos()) {
            System.out.println(produto.getDescricao() + " - " + produto.getValor());
        }
        System.out.println("\n*************************");
    }
}