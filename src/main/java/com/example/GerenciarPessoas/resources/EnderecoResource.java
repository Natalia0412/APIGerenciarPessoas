package com.example.GerenciarPessoas.resources;

import com.example.GerenciarPessoas.dto.EnderecoDTO;
import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public  ResponseEntity<EnderecoDTO>insertEndereco(@RequestBody EnderecoDTO obj){
        EnderecoDTO end=enderecoService.insertEndereco(obj);
        return  ResponseEntity.ok().body(end);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO>updateEndereco(@PathVariable Long id, @RequestBody EnderecoDTO obj){
        EnderecoDTO enderecoDTO=enderecoService.update(id,obj);
        return ResponseEntity.ok().body(enderecoDTO);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id){
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }
}


