package net.ausiasmarch.tiendaonlineserver.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha_pedido;



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha_entrega;
 
  
    private boolean estado_pedido;


    @ManyToOne
    @JoinColumn(name = "id_cliente") 
    private UserEntity user;
    


    @OneToMany(mappedBy = "pedido", fetch = jakarta.persistence.FetchType.LAZY)
    private List<ProductoEntity> productos;

    public PedidoEntity() {
        productos = new java.util.ArrayList<>();
    }

    public PedidoEntity(Long id, LocalDateTime fecha_pedido, LocalDateTime fecha_entrega ,boolean estado_pedido) {
        this.id = id;
        this.fecha_pedido = fecha_pedido;
        this.fecha_entrega = fecha_entrega;
        this.estado_pedido = estado_pedido;
        }

    public PedidoEntity( LocalDateTime fecha_pedido, LocalDateTime fecha_entrega, boolean estado_pedido) {
        this.fecha_pedido = fecha_pedido;
         this.fecha_entrega = fecha_entrega;
        this.estado_pedido = estado_pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
    public boolean getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(boolean estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getProductos() {
        return productos.size();
    }

    
    public LocalDateTime getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDateTime fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }
  public LocalDateTime getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDateTime fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

}
