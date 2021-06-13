package com.github.jmpala.Imageboard.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<ENTITY extends BaseEntity, ID> {

    public List<ENTITY> findAll();

    public Optional<ENTITY> findById(ID id);

    public ENTITY save(ENTITY e);

    void delete(ENTITY e);

    void deleteById(ID id);
}
