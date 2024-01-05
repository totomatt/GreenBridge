package com.greenbridge.services;

import com.greenbridge.entities.Cart;
import com.greenbridge.entities.Cliente;
import com.greenbridge.repositories.CartRepository;
import com.greenbridge.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    public List<Cart> getByClientId(Integer cliente_id){
        List<Cart> cart= cartRepository.findByClienteId(cliente_id);
        if(cart.isEmpty()){
            return null;
        }
        return cart;

    }
    public void save(Cart cart){
        if(cart!=null)
            cartRepository.save(cart);
    }
}
