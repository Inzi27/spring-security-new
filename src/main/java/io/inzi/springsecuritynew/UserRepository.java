package io.inzi.springsecuritynew;

import io.inzi.springsecuritynew.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserName(String username);
}
