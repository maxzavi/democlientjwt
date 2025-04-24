package pe.maxz.democlientjwt.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import pe.maxz.democlientjwt.entity.Login;
import pe.maxz.democlientjwt.entity.TokenValid;


@Repository
public class AuthRepository {
    @Value("${sca.url}")
    private String url;

    private final String codSis = "TEST";
    RestClient restClient = RestClient.create();

    public String login(Login login) {
        String uri=url + "api/v1/login/"+ codSis;
        return restClient.post()
                .uri(uri)
                .body(login)
                .retrieve().body(String.class);
    }

    public String isValid(String token, int codOption) {
        if (token == null || token.isEmpty()) throw new HttpClientErrorException(HttpStatusCode.valueOf(403), "Token is required", "Token is required".getBytes(), null);
        String uri=url + "api/v1/login/token";
        String access_token = token.substring(7);
        TokenValid tokenValid = new TokenValid(access_token, codOption);
        return restClient.post()
                .uri(uri)
                .body(tokenValid)
                .retrieve().body(String.class);
    }
    
}
