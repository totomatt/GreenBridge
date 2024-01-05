package com.greenbridge.controllers;

import com.greenbridge.entities.Cart;
import com.greenbridge.entities.Cliente;
import com.greenbridge.entities.List_Cart;
import com.greenbridge.entities.Prodotto;
import com.greenbridge.services.CartService;
import com.greenbridge.services.ClienteService;
import com.greenbridge.services.ProdottoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carrello")
public class CartController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ClienteService clienteService;
    //aggiungere un prodotto al carrello
    @PostMapping("/aggiungiCart")
    int aggiungiCart(@RequestParam Long prodotto_id,@RequestParam int quantita, HttpSession session) {
        Prodotto prodotto = prodottoService.getById(prodotto_id);
        List_Cart list_cart = (List_Cart) session.getAttribute("list_cart");
        if(list_cart.isPresent(prodotto_id))
            return 0;

        list_cart.addCart(prodotto,quantita);
        return 1;

    }
//AGGIUNGERE DA  QUI
        @PostMapping("/edit_prodotto")
    int edit_prodotto(@RequestParam Long prodotto_id,@RequestParam String edit, HttpSession session){
            List_Cart list_cart = (List_Cart) session.getAttribute("list_cart");
            int quantita= list_cart.edit_quantita(prodotto_id, edit);
            System.out.println("la quantita aggiornata è " + quantita);
            return quantita;
        }







}
