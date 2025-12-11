import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

public class ConversorMoedas {

    private static final Scanner sc = new Scanner(System.in);
    private static final Gson gson = new Gson();

    // Moedas exibidas como destino
    private static final String[] TARGETS = {"USD", "BRL", "EUR", "AUD", "GBP", "ARS", "COP"};

    public static void main(String[] args) {

        while (true) {
            int opcao = exibirMenu();

            if (opcao == 0) {
                System.out.println("Encerrando o conversor. Até mais!");
                break;
            }

            String moedaBase = mapearMoeda(opcao);
            if (moedaBase == null) continue;

            double valor = lerValor(moedaBase);
            if (valor < 0) continue;

            processarConversao(moedaBase, valor);
        }

        sc.close();
    }

    // ------------------------- MENU -------------------------

    private static int exibirMenu() {
        System.out.println("\n*** Conversor de Moedas ***");
        System.out.println("Escolha a moeda base para conversão:");
        System.out.println("1 - USD (Dólar Americano)");
        System.out.println("2 - EUR (Euro)");
        System.out.println("3 - BRL (Real Brasileiro)");
        System.out.println("4 - GBP (Libra Esterlina)");
        System.out.println("5 - ARS (Peso Argentino)");
        System.out.println("6 - COP (Peso Colombiano)");
        System.out.println("0 - SAIR");
        System.out.print("Digite a opção: ");

        try {
            int opcao = sc.nextInt();
            sc.nextLine();
            return opcao;
        } catch (Exception e) {
            System.out.println("Entrada inválida! Digite um número.");
            sc.nextLine();
            return -1;
        }
    }

    // ------------------------- MAPEAR MOEDA -------------------------

    private static String mapearMoeda(int opcao) {
        return switch (opcao) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "BRL";
            case 4 -> "GBP";
            case 5 -> "ARS";
            case 6 -> "COP";
            default -> {
                System.out.println("Opção inválida!");
                yield null;
            }
        };
    }

    // ------------------------- LER VALOR -------------------------

    private static double lerValor(String moedaBase) {
        System.out.print("Digite o valor em " + moedaBase + ": ");

        try {
            double valor = sc.nextDouble();
            sc.nextLine();
            return valor;
        } catch (Exception e) {
            System.out.println("Valor inválido.");
            sc.nextLine();
            return -1;
        }
    }

    // ------------------------- PROCESSAR CONVERSÃO -------------------------

    private static void processarConversao(String moedaBase, double valor) {

        String json = ApiClient.buscarDados(moedaBase);
        if (json == null) {
            System.out.println("Erro ao buscar dados da API.");
            return;
        }

        ExchangeResponse dados = gson.fromJson(json, ExchangeResponse.class);

        if (!"success".equals(dados.getResult())) {
            System.out.println("A API retornou erro.");
            return;
        }

        Map<String, Double> taxas = dados.getConversionRates();
        double taxaBase = taxas.get(moedaBase);

        System.out.println("\nResultado da Conversão:");

        for (String target : TARGETS) {

            if (!taxas.containsKey(target)) continue;

            double taxaTarget = taxas.get(target);
            double convertido = (valor / taxaBase) * taxaTarget;

            System.out.printf("%s %.2f = %s %.2f%n",
                    moedaBase, valor, target, convertido);
        }
    }
}
