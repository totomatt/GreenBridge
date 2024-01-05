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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class ExampleController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CartService cartService;



    @GetMapping("prodotto/{id}")
    //@ResponseBody
    String getProdotto(Model model,@PathVariable Long id){

           Prodotto prodotto = prodottoService.getById(id);
           model.addAttribute("prodotto", prodotto);
            return "pages/user/prodotto";
    }

    @GetMapping("carrello")
        //@ResponseBody
    String getCarrello(Model model, HttpSession session){
        List_Cart list_cart = (List_Cart)session.getAttribute("list_cart");
        model.addAttribute("cart",list_cart.getList_cart());
        return "pages/user/carrello";

    }


    @GetMapping("/")
    @ResponseBody
    List_Cart getCart( HttpSession session){

            List <Cart> lista = cartService.getByClientId(1);
            Cliente cliente = clienteService.getById(1);
            List_Cart list_cart = new List_Cart(cliente,lista);
            session.setAttribute("list_cart", list_cart);
            return list_cart;
    }


}
