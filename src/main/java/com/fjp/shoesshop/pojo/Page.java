package com.fjp.shoesshop.pojo;



/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/27 19:20
 */
@SuppressWarnings("all")
public class Page<T> {
    //页码
    private Integer pageIndex;
    //每一页显示的数据
    private Integer pageSize;
    //数据总的行数
    private Integer totalCounts;
    //总页数
    private Integer totalPages;
    //起始行数
    private Integer startRows;

    public Page(Integer pageIndex) {
        this(pageIndex,6);
    }

    public Page(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.setStartRows((pageIndex-1)*pageSize);
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
        this.setTotalPages(totalCounts%pageSize ==0?totalCounts / pageSize: totalCounts/pageSize+1);
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getStartRows() {
        return startRows;
    }

    public void setStartRows(Integer startRows) {
        this.startRows = startRows;
    }
}
