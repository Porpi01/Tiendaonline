
package net.ausiasmarch.tiendaonlineserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.ausiasmarch.tiendaonlineserver.entity.ProductoEntity;
import net.ausiasmarch.tiendaonlineserver.service.ProductoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/producto")
public class ProductoApi {

    @Autowired
    private ProductoService oProductoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oProductoService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody ProductoEntity oProductoEntity) {
        return ResponseEntity.ok(oProductoService.create(oProductoEntity));
    }

    @PutMapping("")
    public ResponseEntity<ProductoEntity> update(@RequestBody ProductoEntity oProductoEntity) {
        return ResponseEntity.ok(oProductoService.update(oProductoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oProductoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<ProductoEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oProductoService.getPage(oPageable));
    }

      @GetMapping("/total")
    public ResponseEntity<Long> obtenerNumeroTotalDeProductos() {
        long totalProductosEnStock = oProductoService.obtenerNumeroTotalDeProductos();
        return new ResponseEntity<>(totalProductosEnStock, HttpStatus.OK);
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oProductoService.populate(amount));
    }
}