package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.FacilityDto;
import vn.codegym.model.Facility;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    void save(FacilityDto facility);

    List<Facility> findAllFacility();
}
