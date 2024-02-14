package com.omaryusufonalan.vetappbackend.service;

public interface GenericCRUD<Entity, EntityRequest, EntityResponse> {
    Entity getById(Long id);

    EntityResponse getResponseById(Long id);

    EntityResponse create(EntityRequest entityRequest);

    EntityResponse update(Long id, EntityRequest entityRequest);

    void delete(Long id);
}
