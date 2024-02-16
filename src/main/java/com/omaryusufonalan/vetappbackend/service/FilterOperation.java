package com.omaryusufonalan.vetappbackend.service;

public interface FilterOperation<Entity, EntityResponse> {
    Entity filterByName(String name);

    EntityResponse filterResponseByName(String name);
}
