package com.example.GerenciarPessoas.dto;

import com.example.GerenciarPessoas.entities.enums.EnderecoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoDTO {
    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private EnderecoEnum enderecoEnum;

    private Long pessoaId;




}
