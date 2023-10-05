package com.squad15.exmed.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Indicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIndicacao;

    @ManyToOne
    @JoinColumn(name = "usuario_indicador_id")
    private Usuario usuarioIndicador;

    @ManyToOne
    @JoinColumn(name = "usuario_indicado_id")
    private Usuario usuarioIndicado;

    @Column(name = "codigo_indicacao")
    private String codigoIndicacao;

    public void setCodigoIndicacao(String codigoIndicacao) {
        this.codigoIndicacao = codigoIndicacao;
    }
}

