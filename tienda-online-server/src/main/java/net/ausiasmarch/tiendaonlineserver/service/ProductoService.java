package net.ausiasmarch.tiendaonlineserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
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
    @Autowired
    SessionService oSessionService;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    UserService oUserService;

    public ProductoEntity get(Long id) {
        return oProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Long create(ProductoEntity oProductoEntity) {
        oSessionService.onlyAdmins();
        oProductoEntity.setId(null);
        return oProductoRepository.save(oProductoEntity).getId();
    }

    public ProductoEntity update(ProductoEntity oProductoEntity) {
        oSessionService.onlyAdmins();
        if (oProductoEntity.getId() == null) {
            throw new ResourceNotFoundException("Product id cannot be null for an update");
        }
        return oProductoRepository.save(oProductoEntity);
    }

    public long obtenerNumeroTotalDeProductos() {
        oSessionService.onlyAdmins();

        return oProductoRepository.count();
    }

    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        ProductoEntity oThreadEntityFromDatabase = this.get(id);
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oThreadEntityFromDatabase.getPedido().getId());
        oProductoRepository.deleteById(id);
        return id;
    }

    public Page<ProductoEntity> getPage(Pageable oPageable, Long userId) {
        oSessionService.onlyAdmins();
        return oProductoRepository.findAll(oPageable);
    }

    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
        PedidoEntity pedidoporDefecto = oPedidoRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un pedido por defecto con ID 1"));
        for (int i = 0; i < amount; i++) {
            ProductoEntity producto = new ProductoEntity();
            producto.setPedido(pedidoporDefecto);
            producto.setName("Manzana Golden");
            producto.setCategoria("Fruta");
            producto.setPrize((float) 2.85);
            producto.setStock(48);

            oProductoRepository.save(producto);
        }
        return amount.longValue();
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oProductoRepository.deleteAll();
        oProductoRepository.resetAutoIncrement();
        oProductoRepository.flush();
        return oProductoRepository.count();
    }
}
