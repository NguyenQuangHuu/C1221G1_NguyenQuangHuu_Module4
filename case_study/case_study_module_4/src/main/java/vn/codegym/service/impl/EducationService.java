package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Education;
import vn.codegym.repository.IEducationRepository;
import vn.codegym.service.IEducationService;

import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository iEducationRepository;

    @Override
    public List<Education> findAll() {
        return this.iEducationRepository.findAll();
    }
}
