package com.example.GerenciarPessoas.maps;

import com.example.GerenciarPessoas.dto.EnderecoDTO;
import com.example.GerenciarPessoas.entities.Endereco;

import java.util.List;
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

    public static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO){
        Endereco  endereco2=new Endereco();
        endereco2.setNumero(enderecoDTO.getNumero());
        endereco2.setCidade(enderecoDTO.getCidade());
        endereco2.setCep(enderecoDTO.getCep());
        endereco2.setLogradouro(enderecoDTO.getLogradouro());
        endereco2.setEnderecoEnum(enderecoDTO.getEnderecoEnum());

        return endereco2;
    }

    public static List<Endereco>  enderecoDTOToEndereco(List<EnderecoDTO> enderecoDTO){

        return enderecoDTO.stream().map(EnderecoConvert::enderecoDTOToEndereco).collect(Collectors.toList());

    }


}
