package net.ausiasmarch.tiendaonlineserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.tiendaonlineserver.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    Page<PedidoEntity> findByUserId(Long id, Pageable pageable);

    @Query(value = "SELECT p.*,count(pr.id) FROM pedido p, producto pr WHERE p.id = pr.id_pedido GROUP BY p.id ORDER BY COUNT(pr.id) desc", nativeQuery = true)
    Page<PedidoEntity> findPedidosByProductosNumberDesc(Pageable pageable);

    @Query(value = "SELECT p.*,count(pr.id) FROM pedido p, producto pr WHERE p.id = pr.id_pedido and p.id_cliente=$1 GROUP BY p.id ORDER BY COUNT(pr.id) desc", nativeQuery = true)
    Page<PedidoEntity> findThreadsByRepliesNumberDescFilterByUserId(Long userId, Pageable pageable);

    @Modifying
    @Query(value = "ALTER TABLE pedido AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();

}
