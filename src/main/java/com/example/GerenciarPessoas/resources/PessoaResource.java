package com.example.GerenciarPessoas.resources;

import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;
import com.example.GerenciarPessoas.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping()
    public ResponseEntity<Pessoa>insertPessoa(@RequestBody  Pessoa obj){
        obj=pessoaService.insertPessoa(obj);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>deletePessoa(@PathVariable Long id){
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }
}
