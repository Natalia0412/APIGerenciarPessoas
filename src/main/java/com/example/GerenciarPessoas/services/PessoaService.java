package com.example.GerenciarPessoas.services;

import com.example.GerenciarPessoas.dto.EnderecoDTO;
import com.example.GerenciarPessoas.dto.PessoaDTO;
import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;
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
        Pessoa pessoa=new Pessoa();
        pessoa.setNome(obj.getNome());
        pessoa.setDataNascimento(obj.getDataNascimento());
        Pessoa pessoaSaved = pessoaRepository.save(pessoa);
        List<Endereco> enderecoList=obj.getEnderecoList().stream().map(n->{
            Endereco endereco=new Endereco();
            endereco.setCep(n.getCep());
            endereco.setCidade(n.getCidade());
            endereco.setLogradouro(n.getLogradouro());
            endereco.setNumero(n.getNumero());
            endereco.setPessoa(pessoaSaved);
            return endereco;
        }).collect(Collectors.toList());
        List<Endereco> savedEndereco = enderecoRepository.saveAll(enderecoList);
        PessoaDTO pessoaDTO= new PessoaDTO();
        pessoaDTO.setNome(pessoaSaved.getNome());
        pessoaDTO.setDataNascimento(pessoaSaved.getDataNascimento());
       List<EnderecoDTO> enderecoList1= savedEndereco.stream().map(n->{
            EnderecoDTO endereco=new EnderecoDTO();
            endereco.setNumero(n.getNumero());
            endereco.setCidade(n.getCidade());
            endereco.setCep(n.getCep());
            endereco.setLogradouro(n.getLogradouro());
            return endereco;
        }).collect(Collectors.toList());
        pessoaDTO.setEnderecoList(enderecoList1);
        return pessoaDTO;
    }
    /*
    public Pessoa update(Long id, Pessoa obj){
        return pessoaRepository.findById(id).map(p->{
            p.setNome(obj.getNome());
            p.setDataNascimento(obj.getDataNascimento());
            p.setEnderecoList(obj.getEnderecoList());
        })
    }

    private void updateData(Pessoa entity, Pessoa obj) {
        entity.setNome(obj.getNome());
        entity.setDataNascimento((obj.getDataNascimento()));
        entity.setEnderecoList(obj.setEnderecoList(););
    }*/

    public void deletePessoa(Long id){
        pessoaRepository.deleteById(id);
    }

}
