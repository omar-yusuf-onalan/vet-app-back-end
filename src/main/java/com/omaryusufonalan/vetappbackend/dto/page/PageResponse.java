package com.omaryusufonalan.vetappbackend.dto.page;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PageResponse<T> {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private List<T> items;
}
