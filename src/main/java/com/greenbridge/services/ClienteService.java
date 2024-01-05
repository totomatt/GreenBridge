package com.greenbridge.services;

import com.greenbridge.entities.Cliente;
import com.greenbridge.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente getById(Integer id){
        Optional<Cliente> cliente= clienteRepository.findById(id);
        if(cliente.isEmpty()){
            return null;
        }
        return cliente.get();

    }
}
