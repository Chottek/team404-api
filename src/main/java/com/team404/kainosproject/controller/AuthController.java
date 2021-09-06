package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.AuthModel;
import com.team404.kainosproject.service.AuthService;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

  private final AuthService service;

  @Autowired
  public AuthController(AuthService service) {
    this.service = service;
  }


  //@PostMapping("/saveUser")
  @PostConstruct
  public ResponseEntity<?> saveUser(){
    AuthModel model = new AuthModel("admin@kainos.com", "admin", true);
    if(service.getModelByObject(model).isPresent()){
      return ResponseEntity.ok().build();
    }

    if(service.saveModel(model)){
      return ResponseEntity.ok().build();
    }else{
      return ResponseEntity.badRequest().build();
    }
  }


  @PostMapping("/auth")
  public ResponseEntity<?> authUser(@RequestBody AuthModel authModel){
    LOG.info("Got a request with [{}] mail",authModel.getMail());
    Optional<AuthModel> model = service.getModelByObject(authModel);
    return model.isPresent() ? ResponseEntity.ok().body("op: " + model.get().isOp())
        : ResponseEntity.notFound().build();
  }

}
