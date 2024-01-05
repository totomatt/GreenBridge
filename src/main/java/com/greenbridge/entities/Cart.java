
package com.greenbridge.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;
    private int quantita;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", prodotto=" + prodotto +
                ", quantita=" + quantita +
                '}';
    }

    public Cart(Cliente cliente, Prodotto prodotto, int quantita) {
        this.cliente = cliente;
        this.prodotto = prodotto;
        this.quantita = quantita;
    }
}