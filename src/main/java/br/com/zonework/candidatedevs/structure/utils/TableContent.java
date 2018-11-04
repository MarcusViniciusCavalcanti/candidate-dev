package br.com.zonework.candidatedevs.structure.utils;


import br.com.zonework.candidatedevs.structure.JPA.ObjectPersistence;

import java.util.List;

public class TableContent<E extends ObjectPersistence> {
    private List<String> headers;
    private List<E> content;


    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public void setContent(List<E> content) {
        this.content = content;
    }

    public List<E> getContent() {
        return content;
    }
}
