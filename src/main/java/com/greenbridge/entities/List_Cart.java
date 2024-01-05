package com.greenbridge.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter

public class List_Cart {
    private Cliente cliente;
    List<Cart> list_cart;

    public List_Cart(Cliente cliente, List<Cart> list_cart) {
        this.cliente = cliente;
        this.list_cart = list_cart;
    }
    public void addCart(Prodotto prodotto, int quantita){
        Cart itemCart= new Cart(cliente,prodotto,quantita);
        list_cart.add(itemCart);

    }
    public boolean isPresent(Long prodotto_id){
        for (Cart itemCart : list_cart) {
            if (itemCart.getProdotto().getId() == prodotto_id) {
                return true;
            }

        }
    return false;
    }

    public int edit_quantita(Long prodotto_id, String edit) {
        int quantita = 0;
        for (Cart itemCart : list_cart) {

            if (itemCart.getProdotto().getId() == prodotto_id) {
                if (edit.equals("add")) {
                    quantita = itemCart.getQuantita() + 1;
                    if(quantita<=itemCart.getProdotto().getQuantita()) {
                        itemCart.setQuantita(quantita);
                    }
                } else {
                    quantita = itemCart.getQuantita() - 1;
                    if(quantita>=1)
                        itemCart.setQuantita(quantita);
                }

            }

        }
        return quantita;
    }

    @Override
    public String toString() {
        return "List_Cart{" +
                "cliente=" + cliente +
                ", list_cart=" + list_cart +
                '}';
    }
}
