/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.adv.rosangelabadoco.gestao.escritorio.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author mauri
 */
public class A_Receber {
    private Long id;
    private Cliente cliente;
    private Parceiro parceiro;
    private Usuario usuario;
    private String nomeProcesso;
    private String numProcesso;
    private BigDecimal valorTotal;
    private BigDecimal valorPago;
    private LocalDateTime dataPagamento;

    public A_Receber() {
    }

    public A_Receber(Long id, Cliente cliente, Parceiro parceiro, Usuario usuario, String nomeProcesso, String numProcesso, BigDecimal valorTotal, BigDecimal valorPago, LocalDateTime dataPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.parceiro = parceiro;
        this.usuario = usuario;
        this.nomeProcesso = nomeProcesso;
        this.numProcesso = numProcesso;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public String getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    
    
}
