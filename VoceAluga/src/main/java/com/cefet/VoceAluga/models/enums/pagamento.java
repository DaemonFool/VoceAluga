package com.cefet.VoceAluga.models.enums;

public enum pagamento {
    CREDITO(1),
    DEBITO(2),
    PIX(3),
    DINHEIRO(4);

    private int code;

    private pagamento(int code){
        this.code = code;
    }

    public int getcode(){
        return code;
    }

    public static pagamento valueOf(int code) {
        for (pagamento value : pagamento.values()) {
            if (value.getcode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código inválido!");

    }
}
