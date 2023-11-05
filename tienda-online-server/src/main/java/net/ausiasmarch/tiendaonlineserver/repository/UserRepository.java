package net.ausiasmarch.tiendaonlineserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.tiendaonlineserver.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
}
