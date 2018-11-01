package br.com.zonework.candidatedevs.structure;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class PaginateAndSortedQuery<E> {
    private TypedQuery<E> content;
    private long totalItem;
    private int currentPage;
    private long totalPage;
    private int maxResultForPage;

    public PaginateAndSortedQuery(TypedQuery<E> content, long totalItem, int maxResultForPage) {
        this.content = content;
        this.totalItem = totalItem;
        this.totalPage = totalItem / maxResultForPage;
        this.maxResultForPage = maxResultForPage;
    }

    public List<E> getCurrentPage(int pageNumber) {
        content.setFirstResult(pageNumber);
        content.setMaxResults(maxResultForPage);
        currentPage++;
        return Collections.unmodifiableList(content.getResultList());
    }
}
