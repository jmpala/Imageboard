package com.github.jmpala.Imageboard.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<DTO, ID> {

    public List<DTO> findAll();

    public Optional<DTO> findById(ID id);

    public DTO save(DTO e);

    void delete(DTO e);

    void deleteById(ID id);
}
