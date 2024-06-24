/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.adv.rosangelabadoco.gestao.escritorio.model;

/**
 *
 * @author mauri
 */
public class Cliente {
    private Long id;
    private String nome;
    private Parceiro parceiro;
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(Long id, String nome, Parceiro parceiro, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.parceiro = parceiro;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
