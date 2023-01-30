package com.example.GerenciarPessoas.resources;

import com.example.GerenciarPessoas.dto.PessoaDTO;
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
    public ResponseEntity<List<PessoaDTO>>findAll(){
        List<PessoaDTO> listPessoaDTO=pessoaService.findAll();
        return ResponseEntity.ok().body( listPessoaDTO);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO>findById(@PathVariable Long id){
        PessoaDTO obj=pessoaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public  PessoaDTO  insert(@RequestBody PessoaDTO pdto){
        return pessoaService.insertPessoa(pdto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <PessoaDTO> updatePessoa(@PathVariable Long id,@RequestBody  PessoaDTO obj){
        PessoaDTO pessoaDTO = pessoaService.update(id, obj);
        return  ResponseEntity.ok().body(pessoaDTO);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>deletePessoa(@PathVariable Long id){
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

}
