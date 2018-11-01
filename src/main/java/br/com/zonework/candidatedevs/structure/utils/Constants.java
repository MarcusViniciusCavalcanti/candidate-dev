package br.com.zonework.candidatedevs.structure.utils;

public enum Constants {
    CREDENTIALS("credentials"),
    USERNAME("username"),
    PASSWORD("password");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String asString() {
        return this.value;
    }
}
