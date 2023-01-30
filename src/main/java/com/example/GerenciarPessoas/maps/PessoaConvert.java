package com.example.GerenciarPessoas.maps;

import com.example.GerenciarPessoas.dto.EnderecoDTO;
import com.example.GerenciarPessoas.dto.PessoaDTO;
import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaConvert {


    public static PessoaDTO pessoaToPessoaDTO(Pessoa pessoa, boolean withAdress){
        PessoaDTO pessoa1= new PessoaDTO();
        pessoa1.setNome(pessoa.getNome());
        pessoa1.setDataNascimento(pessoa.getDataNascimento());
        if(withAdress){
            pessoa1.setEnderecoList(EnderecoConvert.enderecoToEnderecoDTO(pessoa.getEnderecoList()));
        }
        return pessoa1;
    }

    public static List<PessoaDTO> pessoaToPessoaDTO(List<Pessoa> pessoa, boolean withAdress){
        if(withAdress){
            return pessoa.stream().map((n)->pessoaToPessoaDTO(n,true)).collect(Collectors.toList());
        }
      return pessoa.stream().map((n)->pessoaToPessoaDTO(n,false)).collect(Collectors.toList());
    }

    public static Pessoa pessoaDTOToPessoa(PessoaDTO pessoa, boolean withAdress){
        Pessoa pessoa1= new Pessoa();
        pessoa1.setNome(pessoa.getNome());
        pessoa1.setDataNascimento(pessoa.getDataNascimento());
        if(withAdress){
            pessoa1.setEnderecoList(EnderecoConvert.enderecoDTOToEndereco(pessoa.getEnderecoList(), null));
        }
        return pessoa1;
    }
    public static List<Pessoa> pessoaDTOToPessoa( List<PessoaDTO> pessoa, boolean withAdress){
        if(withAdress){
            return pessoa.stream().map((n)->pessoaDTOToPessoa(n,true)).collect(Collectors.toList());
        }
        return pessoa.stream().map((n)->pessoaDTOToPessoa(n,false)).collect(Collectors.toList());
    }

}
