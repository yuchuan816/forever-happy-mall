package com.foreverhappy.mall.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PageInfo<E> implements Serializable {
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_MIN_PAGE_SIZE = 1;
    public static final int DEFAULT_MAX_PAGE_SIZE = 500;
    private int pageSize;
    private int currentPage;
    private int prePage;
    private int nextPage;
    private int totalPage;
    private int totalCount;
    private List<E> result;

    public PageInfo() {
        this.currentPage = DEFAULT_MIN_PAGE_SIZE;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public PageInfo(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        if (pageSize > DEFAULT_MAX_PAGE_SIZE) {
            this.pageSize = DEFAULT_MAX_PAGE_SIZE;
        }
    }

    public static <E> PageInfo<E> build(int currentPage, int pageSize, int totalCount, List<E> result) {
        PageInfo<E> pageInfo = new PageInfo<>(currentPage, pageSize);
        pageInfo.setTotalCount(totalCount);
        pageInfo.setResult(result);
        pageInfo.setTotalCount(totalCount);
        return pageInfo;
    }

    public static <E> PageInfo<E> build(int currentPage, int pageSize, int totalCount, int totalPage, List<E> result) {
        PageInfo<E> pageInfo = new PageInfo<>(currentPage, pageSize);
        pageInfo.setTotalCount(totalCount);
        pageInfo.setResult(result);
        currentPage = Math.min(currentPage, totalPage);
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setNextPage(currentPage < totalPage ? currentPage + 1 : currentPage);
        pageInfo.setPrePage(currentPage > 1 ? currentPage-1 : currentPage);
        pageInfo.setTotalCount(totalCount);
        pageInfo.setTotalPage(totalPage);
        return pageInfo;
    }

    public static int secureCurrPage(Integer currentPage) {
        return currentPage <= 0 ? 1 : currentPage;
    }

    public static int securePageSize(Integer pageSize) {
        pageSize = (pageSize == null || pageSize < 0) ? DEFAULT_PAGE_SIZE : pageSize;
        pageSize = pageSize > DEFAULT_MAX_PAGE_SIZE ? DEFAULT_MAX_PAGE_SIZE : pageSize;
        return pageSize;
    }
}
