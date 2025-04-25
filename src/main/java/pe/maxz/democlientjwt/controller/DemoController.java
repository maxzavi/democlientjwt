package pe.maxz.democlientjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import io.swagger.v3.oas.annotations.tags.Tag;
import pe.maxz.democlientjwt.repository.AuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController
@RequestMapping("/api/demo")
@Tag(name = "Demo", description = "Demo JWT API")

public class DemoController {
    @Autowired
    private AuthRepository authRepository;
    @GetMapping("/")
    public ResponseEntity<Object> getDemo(@RequestHeader(value = "Authorization", required = false) String token){
        int codOption=   1;
        try {
            authRepository.isValid(token, codOption);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(403).body(e.getResponseBodyAsString());
        }
        return ResponseEntity.ok( "get data oK");

    }
    @PostMapping("/")
    public ResponseEntity<Object> write(@RequestHeader(value = "Authorization", required = false) String token){
        int codOption=   2;
        try {
            authRepository.isValid(token, codOption);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(403).body(e.getResponseBodyAsString());
        }
        return ResponseEntity.ok( "write data oK");
    }
}
