package com.example.GerenciarPessoas.resources;

import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/enderecos")
public class EnderecoResource {
    @Autowired
    private EnderecoService enderecoService;
    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> list=enderecoService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Endereco>findById(@PathVariable Long id){
        Endereco obj =enderecoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
