package com.example.GerenciarPessoas.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;
import com.example.GerenciarPessoas.repositories.EnderecoRepository;
import com.example.GerenciarPessoas.repositories.PessoaRepository;
/*
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Pessoa p1 = new Pessoa(null, "Natália", LocalDate.parse("04/12/1996", fmt1), null);
        Pessoa p2 = new Pessoa(null, "João", LocalDate.parse("27/05/1999", fmt1), null);
        pessoaRepository.saveAll(Arrays.asList(p1, p2));

        Endereco ed1 = new Endereco(null, "Rua eduardo", "02217-000", "222A", "São Paulo", p1);
        Endereco ed2 = new Endereco(null, "Rua teste", "02217-000", "222B", "São Paulo", p2);
        Endereco ed3 = new Endereco(null, "Rua teste", "02217-000", "222c", "São Paulo", p1);
        enderecoRepository.saveAll(Arrays.asList(ed1,ed2,ed3));

    }
}
// p.addEndereco("Rua eduardo","02217-000","222A","São Paulo")
*/