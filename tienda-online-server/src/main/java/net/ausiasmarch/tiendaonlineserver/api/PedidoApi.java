package net.ausiasmarch.tiendaonlineserver.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.tiendaonlineserver.entity.PedidoEntity;
import net.ausiasmarch.tiendaonlineserver.helper.DataGenerationHelper;
import net.ausiasmarch.tiendaonlineserver.service.PedidoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pedido")
public class PedidoApi {
    @Autowired
    PedidoService oPedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPedidoService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody PedidoEntity oPedidoEntity) {

        oPedidoEntity.setFecha_pedido(LocalDateTime.now());
        LocalDateTime fechaEntrega = DataGenerationHelper.getRandomDate(oPedidoEntity.getFecha_pedido());
        oPedidoEntity.setFecha_entrega(fechaEntrega);
        Long idPedidoCreado = oPedidoService.create(oPedidoEntity);
        return ResponseEntity.ok(idPedidoCreado);
    }

    @PutMapping("")
    public ResponseEntity<PedidoEntity> update(@RequestBody PedidoEntity oPedidoEntity) {
        return ResponseEntity.ok(oPedidoService.update(oPedidoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPedidoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<PedidoEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oPedidoService.getPage(oPageable));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oPedidoService.populate(amount));
    }

    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(oPedidoService.empty());
    }

}
