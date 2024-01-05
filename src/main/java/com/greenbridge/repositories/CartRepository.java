package com.greenbridge.repositories;

import com.greenbridge.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
                List<Cart> findByClienteId(Integer id );

        }
