package com.cefet.VoceAluga.models;


import com.cefet.VoceAluga.models.enums.pagamento;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import com.cefet.VoceAluga.models.enums.sitpagamento;

@Entity
@Table(name = "rentals")
public class rental implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name= "idcliente")
    private client idcliente;
    @ManyToOne
    @JoinColumn(name= "idatendimento")
    private employee idatendimento;
    @ManyToOne
    @JoinColumn(name= "idveiculo")
    private vehicle idveiculo;
    @ManyToOne
    @JoinColumn(name= "filial")
    private franchise filial;
    private Instant dtinicio;
    private Integer duracao;
    private pagamento Pagamento;
    private sitpagamento sitpagamento;

    public rental(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public client getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(client idcliente) {
        this.idcliente = idcliente;
    }

    public employee getIdatendimento() {
        return idatendimento;
    }

    public void setIdatendimento(employee idatendimento) {
        this.idatendimento = idatendimento;
    }

    public vehicle getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(vehicle idveiculo) {
        this.idveiculo = idveiculo;
    }

    public franchise getFilial() {
        return filial;
    }

    public void setFilial(franchise filial) {
        this.filial = filial;
    }
    public Instant getDtinicio() {
        return dtinicio;
    }
    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public pagamento getPagamento() {
        return Pagamento;
    }

    public void setPagamento(pagamento pagamento) {
        Pagamento = pagamento;
    }

    public sitpagamento getSitpagamento() {
        return sitpagamento;
    }

    public void setSitpagamento(sitpagamento sitpagamento) {
        this.sitpagamento = sitpagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        rental rental = (rental) o;
        return Objects.equals(id, rental.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
