package producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import producingwebservice.dto.GetCountryRequest;
import producingwebservice.dto.GetCountryResponse;


@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
//
//	Чтобы исправить следующую ошибку:
//
//<faultstring xml:lang="en">unexpected element (uri:"http://spring.io/guides/gs-producing-web-service", local:"getCountryRequest"). Expected elements are &lt;{}getCountryRequest></faultstring>
//	используйте решение, предоставленное Сергеем Усачевым, в классе GetCountryRequest измените следующее:
//
//	@XmlRootElement(namespace="http://spring.io/guides/gs-producing-web-service", name="getCountryRequest") public class GetCountryRequest {
//		Но тогда вы получите вторую ошибку:
//
//<faultstring xml:lang="en">The country's name must not be null</faultstring>
//		Чтобы исправить это, в том же классе измените следующее:
//
//		@XmlElement(namespace="http://spring.io/guides/gs-producing-web-service", required = true)
//		Тогда вы готовы протестировать сервис с помощью пользовательского интерфейса SOAP WSDL по этому адресу:
//
//		http://localhost:8080/ws/countries.wsdl
}
