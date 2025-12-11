import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ApiClient {

    public static String buscarDados(String baseCurrency) {
        try {
            String apiKey = ConfigReader.getApiKey(); // lê sua API Key
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

            // Cria o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria a requisição (GET)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Envia a requisição e recebe a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Retorna o corpo da resposta (o texto JSON)
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Teste simples
    public static void main(String[] args) {
        String resposta = buscarDados("USD");
        System.out.println(resposta);
    }
}
