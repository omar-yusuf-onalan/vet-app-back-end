package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.page.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageService<EntityResponse> {
    public PageResponse<EntityResponse> createPageResponse(int page, int pageSize, Page<EntityResponse> pageOfEntityResponses) {
        PageResponse<EntityResponse> pageResponseOfEntityResponses = new PageResponse<>();

        pageResponseOfEntityResponses.setPageNumber(page);
        pageResponseOfEntityResponses.setPageSize(pageSize);
        pageResponseOfEntityResponses.setTotalElements(pageOfEntityResponses.getTotalElements());
        pageResponseOfEntityResponses.setItems(pageOfEntityResponses.stream().toList());

        return pageResponseOfEntityResponses;
    }
}
