package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.page.PageRequest;
import com.omaryusufonalan.vetappbackend.dto.page.PageResponse;

public interface GenericCRUD<Entity, EntityRequest, EntityResponse> {
    Entity getById(Long id);

    EntityResponse getResponseById(Long id);

    PageResponse<EntityResponse> getPage(int page, int pageSize);

    EntityResponse create(EntityRequest entityRequest);

    EntityResponse update(Long id, EntityRequest entityRequest);

    void delete(Long id);
}
