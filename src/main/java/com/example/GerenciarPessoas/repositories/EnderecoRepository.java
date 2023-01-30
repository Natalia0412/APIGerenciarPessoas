package com.example.GerenciarPessoas.repositories;

import com.example.GerenciarPessoas.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

//Optional<Endereco> findByIdAndPostId(Long id,long pessoa_id);
}
