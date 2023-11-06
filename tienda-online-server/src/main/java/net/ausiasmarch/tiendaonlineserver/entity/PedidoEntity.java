package net.ausiasmarch.tiendaonlineserver.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 255)
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "El formato de fecha debe ser 'dd-MM-yyyy'")
    private String fecha_pedido;

 
    private boolean estado_pedido;


    @ManyToOne
    @JoinColumn(name = "id_cliente") 
    private UserEntity user;
    


    @OneToMany(mappedBy = "pedido", fetch = jakarta.persistence.FetchType.LAZY)
    private List<ProductoEntity> productos;

    public PedidoEntity() {
        productos = new java.util.ArrayList<>();
    }

    public PedidoEntity(Long id, String fecha_pedido, boolean estado_pedido) {
        this.id = id;
        this.fecha_pedido = fecha_pedido;
        this.estado_pedido = estado_pedido;
        }

    public PedidoEntity(String fecha_pedido, boolean estado_pedido) {
        this.fecha_pedido = fecha_pedido;
        this.estado_pedido = estado_pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
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

}
