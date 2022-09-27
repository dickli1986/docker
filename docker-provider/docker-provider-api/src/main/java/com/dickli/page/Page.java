package com.dickli.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
    private List<T> data;
    private Boolean hasNext;
    private Boolean hasPre;

    public Boolean getHasNext() {
        if (Objects.nonNull(page) && Objects.nonNull(pageSize) && Objects.nonNull(totalCount)) {
            if (page == 0) {
                page = 1;
            }
            if (pageSize == 0) {
                pageSize = 10;
            }
            return page * pageSize < totalCount;
        } else {
            return false;
        }
    }

    public Boolean getHasPre() {
        return page > 1;
    }
}
