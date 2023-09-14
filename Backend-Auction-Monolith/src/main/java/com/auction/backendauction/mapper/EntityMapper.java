package com.auction.backendauction.mapper;

import java.util.List;

public interface EntityMapper <Entity,DTO>{

    public Entity toEntity(DTO dto);

    public DTO toDTO(Entity entity);

}
