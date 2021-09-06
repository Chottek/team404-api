package com.team404.kainosproject.service;

import com.team404.kainosproject.model.AuthModel;
import com.team404.kainosproject.repository.AuthRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final AuthRepository repository;
  private final PasswordEncoder encoder;

  @Autowired
  public AuthService(AuthRepository repository, PasswordEncoder encoder) {
    this.repository = repository;
    this.encoder = encoder;
  }

  public boolean saveModel(AuthModel model){
    model.setPass(encoder.encode(model.getPass()));
    repository.save(model);
    return existsByMail(model.getMail());
  }

  private boolean existsByMail(String mail){
    return repository.getByMail(mail).isPresent();
  }

  public Optional<AuthModel> getModelByObject(AuthModel model){
    Optional<AuthModel> dbModel = repository.getByMail(model.getMail());
    if(dbModel.isPresent()){
      if(encoder.matches(model.getPass(), dbModel.get().getPass())){
        return dbModel;
      }else{
        return Optional.empty();
      }
    }else{
      return Optional.empty();
    }
  }



}
