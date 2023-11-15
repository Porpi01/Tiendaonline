package net.ausiasmarch.tiendaonlineserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.tiendaonlineserver.entity.PedidoEntity;


public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{


  

       @Modifying
    @Query(value = "ALTER TABLE thread AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
    
}
