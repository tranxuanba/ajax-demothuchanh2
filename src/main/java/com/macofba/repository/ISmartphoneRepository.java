package com.macofba.repository;

import com.macofba.model.Smatrphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smatrphone, Long> {

}
