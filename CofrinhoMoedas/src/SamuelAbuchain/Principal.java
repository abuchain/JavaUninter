package SamuelAbuchain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

abstract class Moeda {
    private double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract String getDescricao();
}

class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String getDescricao() {
        return "Dólar";
    }
}

class Euro extends Moeda {
    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String getDescricao() {
        return "Euro";
    }
}

class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }

    @Override
    public String getDescricao() {
        return "Real";
    }
}

class Cofrinho {
    private List<Moeda> moedas;

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada ao cofrinho: " + moeda.getDescricao());
    }

    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < moedas.size()) {
            Moeda moedaRemovida = moedas.remove(indice);
            System.out.println("Moeda removida do cofrinho: " + moedaRemovida.getDescricao());
        } else {
            System.out.println("Índice inválido. Moeda não removida.");
        }
    }

    public List<Moeda> listarMoedas() {
        return moedas;
    }

    public double calcularValorTotalEmReal() {
        double valorTotal = 0;
        for (Moeda moeda : moedas) {
            if (moeda instanceof Real) {
                valorTotal += moeda.getValor();
            } else if (moeda instanceof Dolar) {
                valorTotal += moeda.getValor() * 5; // Conversão de dólar para real (valor fictício)
            } else if (moeda instanceof Euro) {
                valorTotal += moeda.getValor() * 6; // Conversão de euro para real (valor fictício)
            }
        }
        return valorTotal;
    }
}

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static Cofrinho cofrinho = new Cofrinho();

    public static void main(String[] args) {
        int opcao;
        System.out.println(" ");
        System.out.println("----- Cofrinho de Moeda - Samuel Luiz Abuchain -----");
        System.out.println(" ");

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    listarMoedas();
                    break;
                case 2:
                    adicionarMoeda();
                    break;
                case 3:
                    removerMoeda();
                    break;
                case 4:
                    listarMoedas();
                    break;
                case 5:
                    double valorTotalEmReal = cofrinho.calcularValorTotalEmReal();
                    System.out.println("Valor total no cofrinho em Real: " + valorTotalEmReal);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Listar moedas");
        System.out.println("2. Adicionar moeda");
        System.out.println("3. Remover moeda");
        System.out.println("4. Listagem de moedas");
        System.out.println("5. Total convertido em Reais");
        System.out.println("0. Sair");
    }

    private static int lerOpcao() {
        int opcao = -1;
        boolean opcaoValida = false;

        while (!opcaoValida) {
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                opcaoValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
            }
        }

        scanner.nextLine(); // Limpar o buffer

        return opcao;
    }

    private static void listarMoedas() {
        List<Moeda> moedas = cofrinho.listarMoedas();

        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
            System.out.println("Moedas no cofrinho:");
            int i = 0;
            for (Moeda moeda : moedas) {
                System.out.println(i + ": " + moeda.getDescricao() + " - Valor: " + moeda.getValor());
                i++;
            }
        }
    }

    private static void adicionarMoeda() {
        double valor = lerValor();
        int tipo = lerTipoMoeda();

        Moeda moeda = criarMoeda(valor, tipo);

        if (moeda != null) {
            cofrinho.adicionarMoeda(moeda);
        } else {
            System.out.println("Tipo de moeda inválido. Moeda não adicionada.");
        }
    }

    private static void removerMoeda() {
        List<Moeda> moedas = cofrinho.listarMoedas();
        listarMoedas();

        int indice = lerIndiceMoeda(moedas.size());

        cofrinho.removerMoeda(indice);
    }

    private static double lerValor() {
        double valor = 0;
        boolean valorValido = false;

        while (!valorValido) {
            System.out.print("Informe o valor da moeda: ");

            try {
                valor = scanner.nextDouble();
                valorValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Tente novamente.");
                scanner.nextLine();
            }
        }

        scanner.nextLine(); // Limpar o buffer

        return valor;
    }

    private static int lerTipoMoeda() {
        int tipo = 0;
        boolean tipoValido = false;

        while (!tipoValido) {
            System.out.print("Informe o tipo de moeda (1 - Dólar, 2 - Euro, 3 - Real): ");

            try {
                tipo = scanner.nextInt();
                tipoValido = (tipo >= 1 && tipo <= 3);
            } catch (InputMismatchException e) {
                System.out.println("Tipo inválido. Tente novamente.");
                scanner.nextLine();
            }
        }

        scanner.nextLine(); // Limpar o buffer

        return tipo;
    }

    private static Moeda criarMoeda(double valor, int tipo) {
        switch (tipo) {
            case 1:
                return new Dolar(valor);
            case 2:
                return new Euro(valor);
            case 3:
                return new Real(valor);
            default:
                return null;
        }
    }

    private static int lerIndiceMoeda(int tamanhoLista) {
        int indice = -1;
        boolean indiceValido = false;

        while (!indiceValido) {
            System.out.print("Informe o índice da moeda a ser removida: ");

            try {
                indice = scanner.nextInt();
                indiceValido = (indice >= 0 && indice < tamanhoLista);
            } catch (InputMismatchException e) {
                System.out.println("Índice inválido. Tente novamente.");
                scanner.nextLine();
            }
        }

        scanner.nextLine(); // Limpar o buffer

        return indice;
    }
}

