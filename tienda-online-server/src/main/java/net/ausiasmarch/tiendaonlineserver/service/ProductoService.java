package net.ausiasmarch.tiendaonlineserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.tiendaonlineserver.entity.ProductoEntity;
import net.ausiasmarch.tiendaonlineserver.exception.ResourceNotFoundException;
import net.ausiasmarch.tiendaonlineserver.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository oProductoRepository;

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

    public Long delete(Long id) {
        oProductoRepository.deleteById(id);
        return id;
    }

    public Page<ProductoEntity> getPage(Pageable oPageable) {
        return oProductoRepository.findAll(oPageable);
    }

   
public Long populate(Integer amount) {
    for (int i = 0; i < amount; i++) {
        ProductoEntity producto = new ProductoEntity("name" + i+ i, 0.0f, i); 
        oProductoRepository.save(producto);
    }
    return oProductoRepository.count();
}
}