package br.com.serdin.Enum;

public enum Status {

    ATIVO("ATIVO"), INATIVO("INATIVO");
    private String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
