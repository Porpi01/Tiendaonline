package net.ausiasmarch.tiendaonlineserver.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import net.ausiasmarch.tiendaonlineserver.entity.PedidoEntity;
import net.ausiasmarch.tiendaonlineserver.entity.UserEntity;
import net.ausiasmarch.tiendaonlineserver.exception.ResourceNotFoundException;
import net.ausiasmarch.tiendaonlineserver.repository.PedidoRepository;
import net.ausiasmarch.tiendaonlineserver.repository.UserRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository oPedidoRepository;
    @Autowired
    UserRepository oUserRepository;
     @Autowired
    SessionService oSessionService;

    public PedidoEntity get(Long id) {
        return oPedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido not found"));
    }

    public Long create(PedidoEntity pedidoEntity) {
        oSessionService.onlyAdminsOrUsers();
        pedidoEntity.setId(null);
        if(oSessionService.isUser()){
           pedidoEntity.setUser(oSessionService.getSessionUser());
           return oPedidoRepository.save(pedidoEntity).getId();
        }else{
        return oPedidoRepository.save(pedidoEntity).getId();
        }
    }

    public PedidoEntity update(PedidoEntity pedidoEntity) {

     PedidoEntity oPedidoEntityFromDatabase = this.get(pedidoEntity.getId());
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oPedidoEntityFromDatabase.getUser().getId());
        if (oSessionService.isUser()) {
            pedidoEntity.setUser(oSessionService.getSessionUser());
            return oPedidoRepository.save(pedidoEntity);
        } else {
            return oPedidoRepository.save(pedidoEntity);
        }
    }

    public long obtenerNumeroTotalDePedidos() {
        return oPedidoRepository.count();
    }

    public Long delete(Long id) {
          PedidoEntity oPedidoEntityFromDatabase = this.get(id);
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oPedidoEntityFromDatabase.getUser().getId());
        oPedidoRepository.deleteById(id);
        return id;
    }

    public Page<PedidoEntity> getPage(Pageable oPageable) {
        return oPedidoRepository.findAll(oPageable);
    }

   public Long populate(Integer amount) {

    UserEntity clientePorDefecto = oUserRepository.findById(1L)
            .orElseThrow(() -> new IllegalArgumentException("No se encontró un cliente por defecto con ID 1"));

    for (int i = 0; i < amount; i++) {
        PedidoEntity pedido = new PedidoEntity();

        pedido.setUser(clientePorDefecto);
        pedido.setFecha_pedido("06-11-2023"); 
        pedido.setEstado_pedido(false); 

        oPedidoRepository.save(pedido);
    }

    return amount.longValue();
}

  @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oPedidoRepository.deleteAll();
        oPedidoRepository.resetAutoIncrement();
        oPedidoRepository.flush();
        return oPedidoRepository.count();
    }

}
