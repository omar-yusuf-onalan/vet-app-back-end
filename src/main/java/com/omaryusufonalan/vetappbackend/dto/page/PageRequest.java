package com.omaryusufonalan.vetappbackend.dto.page;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PageRequest {
    private int page;
    private int pageSize;
}
