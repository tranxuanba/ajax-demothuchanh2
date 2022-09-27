package com.macofba.service;

import com.macofba.model.Smatrphone;
import com.macofba.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneSrevice{
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smatrphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smatrphone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smatrphone save(Smatrphone smatrphone) {
        return smartphoneRepository.save(smatrphone);
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }
}
