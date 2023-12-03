package com.cefet.VoceAluga.models.enums;

public enum sitpagamento {
    PAGO(1),
    NAO_PAGO(2);

    private int code;

    private sitpagamento(int code){
        this.code = code;
    }

    public int getcode(){
        return code;
    }

    public static sitpagamento valueOf(int code) {
        for (sitpagamento value : sitpagamento.values()) {
            if (value.getcode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código inválido!");

    }
}
