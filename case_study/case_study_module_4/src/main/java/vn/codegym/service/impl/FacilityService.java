package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Facility;
import vn.codegym.repository.IFacilityRepository;
import vn.codegym.service.IFacilityService;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return this.iFacilityRepository.findAll(pageable);
    }

    @Override
    public void save(Facility facility) {
        this.iFacilityRepository.save(facility);
    }
}
