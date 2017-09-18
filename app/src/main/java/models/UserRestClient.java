package models;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.*;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;
import entities.User;

/**
 * Created by leandrodlm on 08/08/17.
 */

public class UserRestClient {

    private String BASE_URL = "http://192.168.15.248:8080/WebColaboradores/webresources/br.com.bhsoftworks.webcolaboradores.model.colaborador";
    private RestTemplate restTemplate = new RestTemplate();

    public User getUser (int id) {
        try {

            return restTemplate.getForObject(BASE_URL + "/" + id, User.class);

        } catch (Exception e) {
            return null;
        }
    }


    public List<User> getAll () {
        try {

            return restTemplate.exchange(
                    BASE_URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<User>>() {
                    }).getBody();

        } catch (Exception e) {
            return null;
        }
    }
}
