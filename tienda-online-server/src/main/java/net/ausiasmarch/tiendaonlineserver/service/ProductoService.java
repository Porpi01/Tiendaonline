package net.ausiasmarch.tiendaonlineserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.tiendaonlineserver.entity.PedidoEntity;
import net.ausiasmarch.tiendaonlineserver.entity.ProductoEntity;
import net.ausiasmarch.tiendaonlineserver.exception.ResourceNotFoundException;
import net.ausiasmarch.tiendaonlineserver.repository.PedidoRepository;
import net.ausiasmarch.tiendaonlineserver.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository oProductoRepository;
     @Autowired
    PedidoRepository oPedidoRepository;

    public ProductoEntity get(Long id) {
        return oProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Long create(ProductoEntity oProductoEntity) {
        oProductoEntity.setId(null);
        return oProductoRepository.save(oProductoEntity).getId();
    }

    public ProductoEntity update(ProductoEntity oProductoEntity) {
        if (oProductoEntity.getId() == null) {
            throw new ResourceNotFoundException("Product id cannot be null for an update");
        }
        return oProductoRepository.save(oProductoEntity);
    }

    public long obtenerNumeroTotalDeProductos() {
        return oProductoRepository.count();
    }

    public Long delete(Long id) {
        oProductoRepository.deleteById(id);
        return id;
    }

    public Page<ProductoEntity> getPage(Pageable oPageable) {
        return oProductoRepository.findAll(oPageable);
    }

   
public Long populate(Integer amount) {
    PedidoEntity pedidoporDefecto = oPedidoRepository.findById(1L)
            .orElseThrow(() -> new IllegalArgumentException("No se encontró un pedido por defecto con ID 1"));
    for (int i = 0; i < amount; i++) {
        ProductoEntity producto = new ProductoEntity();
         producto.setPedido(pedidoporDefecto);
         producto.setName("Manzana Golden");
        
         producto.setPrize((float) 2.85);
         producto.setStock(48);
      

        oProductoRepository.save(producto);
    }
    return amount.longValue();
}
}

  