import java.util.Map;

public class ExchangeResponse {
    private String result;
    private Map<String, Double> conversion_rates;

    public String getResult() {
        return result;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}
