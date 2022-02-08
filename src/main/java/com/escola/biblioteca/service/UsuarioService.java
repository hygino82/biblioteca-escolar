package com.escola.biblioteca.service;

import com.escola.biblioteca.entity.Usuario;
import com.escola.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAllUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario encontrarPorNome(String nome) {
        return this.usuarioRepository.findUsuarioByNomeContainingIgnoreCase(nome);
    }

    public Usuario encontrarPorId(Long id) {
        return this.usuarioRepository.getUsuarioById(id);
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioDB = usuarioRepository.getUsuarioById(id);

        if (Objects.nonNull(usuario.getNome()) && !"".equalsIgnoreCase(usuario.getNome())) {
            usuarioDB.setNome(usuario.getNome());
        }

        if (Objects.nonNull(usuario.getCondicao()) && !"".equalsIgnoreCase(usuario.getCondicao())) {
            usuarioDB.setCondicao(usuario.getCondicao());
        }

        if (Objects.nonNull(usuario.getEmail()) && !"".equalsIgnoreCase(usuario.getEmail())) {
            usuarioDB.setEmail(usuario.getEmail());
        }

        if (Objects.nonNull(usuario.getMunicipio()) && !"".equalsIgnoreCase(usuario.getMunicipio())) {
            usuarioDB.setMunicipio(usuario.getMunicipio());
        }

        if (Objects.nonNull(usuario.getEndereco()) && !"".equalsIgnoreCase(usuario.getEndereco())) {
            usuarioDB.setEndereco(usuario.getEndereco());
        }

        if (Objects.nonNull(usuario.getTelefone()) && !"".equalsIgnoreCase(usuario.getTelefone())) {
            usuarioDB.setTelefone(usuario.getTelefone());
        }

        return usuarioRepository.save(usuarioDB);
    }
}
