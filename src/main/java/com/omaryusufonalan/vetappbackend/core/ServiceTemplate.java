package com.omaryusufonalan.vetappbackend.core;

import java.util.List;

public interface ServiceTemplate<Entity extends EntityTemplate, Request, Response> {
    List<Response> getAll();
    Entity getById(Long id);
    Response getResponseById(Long id);
    Response create(Request request);
    Response update(Long id, Request request);
    void deleteById(Long id);
}
