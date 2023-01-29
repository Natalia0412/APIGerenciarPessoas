package com.example.GerenciarPessoas.services;

import com.example.GerenciarPessoas.entities.Pessoa;
import com.example.GerenciarPessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    public List<Pessoa> findAll(){
       return  pessoaRepository.findAll();
    }
    public Pessoa findById(Long id){
        Optional <Pessoa> obj=pessoaRepository.findById(id);
        return obj.get();
    }
    public Pessoa insertPessoa(Pessoa obj){
        return pessoaRepository.save(obj);
    }
    public void deletePessoa(Long id){
        pessoaRepository.deleteById(id);
    }
}
