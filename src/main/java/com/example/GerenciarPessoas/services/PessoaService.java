package com.example.GerenciarPessoas.services;

import com.example.GerenciarPessoas.dto.EnderecoDTO;
import com.example.GerenciarPessoas.dto.PessoaDTO;
import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;
import com.example.GerenciarPessoas.maps.EnderecoConvert;
import com.example.GerenciarPessoas.maps.PessoaConvert;
import com.example.GerenciarPessoas.repositories.EnderecoRepository;
import com.example.GerenciarPessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Pessoa> findAll(){
       return  pessoaRepository.findAll();
    }
    public Pessoa findById(Long id){
        Optional <Pessoa> obj=pessoaRepository.findById(id);
        return obj.get();
    }


    public PessoaDTO insertPessoa(PessoaDTO obj){
        Pessoa pessoaSaved = pessoaRepository.save(PessoaConvert.pessoaDTOToPessoa(obj,false));
        List<Endereco>  enderecoList=enderecoRepository.saveAll(EnderecoConvert.enderecoDTOToEndereco(obj.getEnderecoList(),pessoaSaved));
        PessoaDTO p = PessoaConvert.pessoaToPessoaDTO(pessoaSaved, false);
        List<EnderecoDTO> end = EnderecoConvert.enderecoToEnderecoDTO(enderecoList);
        p.setEnderecoList(end);
        return p;
    }
/*
    public Pessoa update(Long id, Pessoa obj){
        return pessoaRepository.findById(id).map(p->{
            p.setNome(obj.getNome());
            p.setDataNascimento(obj.getDataNascimento());
            p.setEnderecoList(obj.getEnderecoList());
            return pessoaRepository.save(p);
        })
    }

    private void updateData(Pessoa entity, Pessoa obj) {
        entity.setNome(obj.getNome());
        entity.setDataNascimento((obj.getDataNascimento()));
        entity.setEnderecoList(obj.setEnderecoList(););
    }
*/
    public void deletePessoa(Long id){
        pessoaRepository.deleteById(id);
    }

}
