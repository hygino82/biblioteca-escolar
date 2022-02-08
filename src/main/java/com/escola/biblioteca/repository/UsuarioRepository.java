package com.escola.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.biblioteca.entity.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //public Usuario findUsuarioByNomeContaining(String nome);
    public Usuario findUsuarioByNomeContainingIgnoreCase(String nome);

    public Usuario getUsuarioById(Long id);
}
