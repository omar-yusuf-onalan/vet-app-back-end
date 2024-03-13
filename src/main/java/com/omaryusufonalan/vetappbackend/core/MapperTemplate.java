package com.omaryusufonalan.vetappbackend.core;

import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

public interface MapperTemplate<Entity extends EntityTemplate, Request, Response> {
    @Named("requestToEntity")
    Entity requestToEntity(Request request);

    @Named("responseToEntity")
    Entity responseToEntity(Response response);

    @Named("entityToRequest")
    Request entityToRequest(Entity entity);

    @Named("entityToResponse")
    Response entityToResponse(Entity entity);

    @Named("entityToListResponse")
    List<Response> entityToListResponse(List<Entity> entity);

    void update(@MappingTarget Entity targetEntity, Request updatingRequest);
}
