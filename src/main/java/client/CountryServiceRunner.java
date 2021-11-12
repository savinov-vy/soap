package client;

public class CountryServiceRunner {

    public static void main(String[] args) {

        CountriesPortService service = new CountriesPortService();
        CountriesPort port = service.getPort(CountriesPort.class);
        GetCountryRequest request = new GetCountryRequest();
        request.setName("Spain");
        System.out.println(port.getCountry(request));

    }
}
