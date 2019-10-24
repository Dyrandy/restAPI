package com.rest.repository;

import com.rest.domain.User;
import com.rest.domain.projection.UserOnlyContatinName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(excerptProjection = UserOnlyContatinName.class)
public interface UserRepository extends JpaRepository<User, Long>{

}