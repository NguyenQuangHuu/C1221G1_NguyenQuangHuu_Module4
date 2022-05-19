package vn.codegym.service;

import vn.codegym.model.Phone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Phone> findAll();

    Optional<Phone> findById(Long id);

    Phone save(Phone smartPhone);

    void remove(Long id);
}
