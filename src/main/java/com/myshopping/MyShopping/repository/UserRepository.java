package com.myshopping.MyShopping.repository;

import com.myshopping.MyShopping.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
//jpa will handel logic for db operation
@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID> {

}
