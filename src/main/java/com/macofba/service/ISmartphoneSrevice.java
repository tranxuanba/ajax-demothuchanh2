package com.macofba.service;

import com.macofba.model.Smatrphone;

import java.util.Optional;

public interface ISmartphoneSrevice {
    Iterable<Smatrphone> findAll();
    Optional<Smatrphone> findById(Long id);
    Smatrphone save(Smatrphone smatrphone);
    void remove(Long id);
}
