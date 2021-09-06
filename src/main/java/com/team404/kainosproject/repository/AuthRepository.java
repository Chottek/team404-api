package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.AuthModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<AuthModel, Integer> {

  @Query("SELECT t FROM AuthModel t WHERE mail=?1")
  Optional<AuthModel> getByMail(String mail);

}
