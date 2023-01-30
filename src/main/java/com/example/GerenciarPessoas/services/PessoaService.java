package com.example.GerenciarPessoas.services;

import com.example.GerenciarPessoas.dto.PessoaDTO;
import com.example.GerenciarPessoas.entities.Pessoa;
import com.example.GerenciarPessoas.maps.PessoaConvert;
import com.example.GerenciarPessoas.repositories.EnderecoRepository;
import com.example.GerenciarPessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<PessoaDTO> findAll(){
        return PessoaConvert.pessoaToPessoaDTO(pessoaRepository.findAll());
        //return  pessoaRepository.findAll();
    }

    public PessoaDTO findById(Long id){

        Optional<Pessoa> pessoaOptional=pessoaRepository.findById(id);
        if(!pessoaOptional.isPresent()){
            throw new RuntimeException("Pessoa não foi encontrada!");
        }

        return PessoaConvert.pessoaToPessoaDTO(pessoaOptional.get());

    }


    public PessoaDTO insertPessoa(PessoaDTO obj){
        Pessoa pessoaSaved = pessoaRepository.save(PessoaConvert.pessoaDTOToPessoa(obj));
        //List<Endereco>  enderecoList=enderecoRepository.saveAll(EnderecoConvert.enderecoDTOToEndereco(obj.getEnderecos(),pessoaSaved));
        PessoaDTO p = PessoaConvert.pessoaToPessoaDTO(pessoaSaved);
        // List<EnderecoDTO> end = EnderecoConvert.enderecoToEnderecoDTO(enderecoList);
        //p.setEnderecos(end);
        return p;
    }

    public PessoaDTO update(Long id, PessoaDTO obj){
        boolean existsById = pessoaRepository.existsById(id);
        if(existsById){
            Pessoa pessoa = PessoaConvert.pessoaDTOToPessoa(obj);
            pessoa.setId(id);
            return PessoaConvert.pessoaToPessoaDTO(pessoaRepository.save(pessoa));
        }else{
            throw  new RuntimeException("Pessoa não encontrada");
        }
    }


    public void deletePessoa(Long id){
        pessoaRepository.deleteById(id);
    }

}
