package br.com.serdin.Enum;

public enum TipoUsuario {
    ADMIN("ADMIN");

    private String desc;

    TipoUsuario(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
