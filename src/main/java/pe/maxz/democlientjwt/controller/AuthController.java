package pe.maxz.democlientjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import pe.maxz.democlientjwt.entity.Login;
import pe.maxz.democlientjwt.repository.AuthRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @PostMapping( value =  "/", produces = "application/json")
    public ResponseEntity<Object> login(@RequestBody Login login) {
        try {
            var result = authRepository.login(login);
            return ResponseEntity.ok().body(result);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());            
        }
    }

}
