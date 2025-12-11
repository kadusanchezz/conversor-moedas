import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getApiKey() {
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                System.out.println("DEBUG: config.properties não encontrado (getResourceAsStream retornou null).");
                return null;
            }

            Properties p = new Properties();
            p.load(in);
            return p.getProperty("api.key");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // método auxiliar de teste
    public static void main(String[] args) {
        System.out.println("API key lida: " + getApiKey());
    }
}
