package com.example.GerenciarPessoas.services;

import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id) {
        Optional<Endereco> opt=enderecoRepository.findById(id);
        return opt.get();
    }
    public Endereco insertEndereco(Endereco obj){
       return enderecoRepository.save(obj);
    }
}
