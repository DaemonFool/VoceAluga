package com.cefet.VoceAluga.models.enums;

import jakarta.persistence.*;

import java.io.Serializable;

public enum funcao {
    ADMIN(1),
    GERENTE(2),
    VENDEDOR(3),
    MECANICO(4);

    private int code;

    private funcao(int code){
        this.code = code;
    }
}
