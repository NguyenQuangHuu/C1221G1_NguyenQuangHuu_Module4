package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Facility;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    void save(Facility facility);
}
