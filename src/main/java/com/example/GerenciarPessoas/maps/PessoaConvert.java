package com.example.GerenciarPessoas.maps;

import com.example.GerenciarPessoas.dto.PessoaDTO;
import com.example.GerenciarPessoas.entities.Pessoa;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaConvert {


    public static PessoaDTO pessoaToPessoaDTO(Pessoa pessoa){
        PessoaDTO pessoa1= new PessoaDTO();
        pessoa1.setId(pessoa.getId());
        pessoa1.setNome(pessoa.getNome());
        pessoa1.setDataNascimento(pessoa.getDataNascimento());

        return pessoa1;
    }

    public static List<PessoaDTO> pessoaToPessoaDTO(List<Pessoa> pessoa){

        return pessoa.stream().map((n)->pessoaToPessoaDTO(n)).collect(Collectors.toList());
    }

    public static Pessoa pessoaDTOToPessoa(PessoaDTO pessoa){
        Pessoa pessoa1= new Pessoa();
        pessoa1.setNome(pessoa.getNome());
        pessoa1.setDataNascimento(pessoa.getDataNascimento());

        return pessoa1;
    }
    public static List<Pessoa> pessoaDTOToPessoa( List<PessoaDTO> pessoa){

        return pessoa.stream().map((n)->pessoaDTOToPessoa(n)).collect(Collectors.toList());
    }

}
