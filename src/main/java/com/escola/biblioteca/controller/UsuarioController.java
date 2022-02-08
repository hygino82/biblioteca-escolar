package com.escola.biblioteca.controller;

import com.escola.biblioteca.entity.Usuario;
import com.escola.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public List<Usuario> findAllUsuarios() {
        return this.usuarioService.findAllUsuarios();
    }

    @GetMapping("/nome/{nome}")
    public Usuario encontrarPorNome(@PathVariable("nome") String nome) {
        return this.usuarioService.encontrarPorNome(nome);
    }

    @GetMapping("/{id}")
    public Usuario encontrarPorId(@PathVariable("id") Long id) {
        return this.usuarioService.encontrarPorId(id);
    }

    @PostMapping("/salvar")
    public Usuario salvarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/editar/{id}")
    public Usuario atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }
}
