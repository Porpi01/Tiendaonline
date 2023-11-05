package net.ausiasmarch.tiendaonlineserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.tiendaonlineserver.entity.PedidoEntity;


public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{
    
}
