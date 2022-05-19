package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Phone;
import vn.codegym.repository.IPhoneRepository;
import vn.codegym.service.IPhoneService;

import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository iPhoneRepository;
    @Override
    public Iterable<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return iPhoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone smartPhone) {
        return iPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        this.iPhoneRepository.deleteById(id);
    }
}
