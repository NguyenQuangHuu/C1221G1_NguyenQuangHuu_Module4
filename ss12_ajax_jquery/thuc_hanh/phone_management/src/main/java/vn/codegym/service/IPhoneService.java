package vn.codegym.service;

import vn.codegym.model.Phone;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {
    List<Phone> findAll();

    Optional<Phone> findById(Long id);

    Phone save(Phone smartPhone);

    void remove(Long id);
}
