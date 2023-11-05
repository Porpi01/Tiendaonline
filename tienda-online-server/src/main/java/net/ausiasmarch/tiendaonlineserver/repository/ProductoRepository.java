package net.ausiasmarch.tiendaonlineserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.tiendaonlineserver.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    
}
