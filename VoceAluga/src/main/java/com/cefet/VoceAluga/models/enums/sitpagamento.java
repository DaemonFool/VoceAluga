package com.cefet.VoceAluga.models.enums;

public enum sitpagamento {
    PAGO(1),
    NAO_PAGO(2);

    private int code;

    private sitpagamento(int code){
        this.code = code;
    }
}
