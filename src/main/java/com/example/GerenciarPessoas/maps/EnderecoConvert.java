package com.example.GerenciarPessoas.maps;

import com.example.GerenciarPessoas.dto.EnderecoDTO;
import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EnderecoConvert {

    public static EnderecoDTO enderecoToEnderecoDTO(Endereco endereco){
        EnderecoDTO  endereco1=new EnderecoDTO();
        endereco1.setId(endereco.getId());
        endereco1.setNumero(endereco.getNumero());
        endereco1.setCidade(endereco.getCidade());
        endereco1.setCep(endereco.getCep());
        endereco1.setLogradouro(endereco.getLogradouro());
        endereco1.setEnderecoEnum(endereco.getEnderecoEnum());
        return endereco1;
    }


    public static List<EnderecoDTO> enderecoToEnderecoDTO(List<Endereco> endereco){
        return endereco.stream().map(EnderecoConvert::enderecoToEnderecoDTO).collect(Collectors.toList());
    }
/*
    private static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        return enderecoDTOToEndereco(enderecoDTO, null);
    }
*/
    public static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO){
        Endereco  endereco2=new Endereco();
        endereco2.setNumero(enderecoDTO.getNumero());
        endereco2.setCidade(enderecoDTO.getCidade());
        endereco2.setCep(enderecoDTO.getCep());
        endereco2.setLogradouro(enderecoDTO.getLogradouro());
        endereco2.setEnderecoEnum(enderecoDTO.getEnderecoEnum());

  /*     if(!Objects.isNull(pessoa)){
           endereco2.setPessoa(pessoa);
       }*/
        return endereco2;
    }

    public static List<Endereco>  enderecoDTOToEndereco(List<EnderecoDTO> enderecoDTO){
        /*if(!Objects.isNull(pessoa)){
            return enderecoDTO.stream().map(n->enderecoDTOToEndereco(n)).collect(Collectors.toList());
        }*/
        return enderecoDTO.stream().map(EnderecoConvert::enderecoDTOToEndereco).collect(Collectors.toList());

    }


}
