package net.ausiasmarch.tiendaonlineserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.tiendaonlineserver.entity.PedidoEntity;

import net.ausiasmarch.tiendaonlineserver.exception.ResourceNotFoundException;
import net.ausiasmarch.tiendaonlineserver.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository oPedidoRepository;

    public PedidoEntity get(Long id) {
        return oPedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido not found"));
    }

    public Long create(PedidoEntity pedidoEntity) {
        pedidoEntity.setId(null);
        return oPedidoRepository.save(pedidoEntity).getId();
    }

    public PedidoEntity update(PedidoEntity pedidoEntity) {
        return oPedidoRepository.save(pedidoEntity);
    }

    public Long delete(Long id) {
        oPedidoRepository.deleteById(id);
        return id;
    }

    public Page<PedidoEntity> getPage(Pageable oPageable) {
        return oPedidoRepository.findAll(oPageable);
    }

    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            oPedidoRepository.save(new PedidoEntity("fecha_pedido" + i, "estado_pedido" + i));
        }
        return oPedidoRepository.count();
    }
}
