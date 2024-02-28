package com.omaryusufonalan.vetappbackend.service.interfaces;

import com.omaryusufonalan.vetappbackend.dto.page.PageResponse;

public interface GenericCRUD<Entity, EntityRequest, EntityResponse> {
    Entity getById(Long id);

    EntityResponse getResponseById(Long id);

    PageResponse<EntityResponse> getPageResponse(int page, int pageSize);

    EntityResponse create(EntityRequest entityRequest);

    EntityResponse update(Long id, EntityRequest entityRequest);

    void delete(Long id);
}