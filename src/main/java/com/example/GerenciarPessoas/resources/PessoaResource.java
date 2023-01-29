package com.example.GerenciarPessoas.resources;

import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;
import com.example.GerenciarPessoas.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/pessoas")
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;
    @GetMapping
    public ResponseEntity<List<Pessoa>>findAll(){
        List<Pessoa> list=pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa>findById(@PathVariable Long id){
        Pessoa obj=pessoaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
