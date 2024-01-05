package com.greenbridge.services;

import com.greenbridge.entities.Prodotto;
import com.greenbridge.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;
    public Prodotto getById(Long id){
        Optional<Prodotto> prodotto= prodottoRepository.findById(id);
        if(prodotto.isEmpty()){
            return null;
        }
        return prodotto.get();

    }
}
