package vn.codegym.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.FacilityDto;
import vn.codegym.model.Facility;
import vn.codegym.repository.IFacilityRepository;
import vn.codegym.service.IFacilityService;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return this.iFacilityRepository.findAll(pageable);
    }

    @Override
    public void save(FacilityDto facilityDto) {

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facility.setArea(Double.parseDouble(facilityDto.getArea()));
        facility.setCost(Double.parseDouble(facilityDto.getCost()));
        facility.setFloors(Integer.parseInt(facilityDto.getFloors()));
        facility.setMaxPeople(Integer.parseInt(facilityDto.getMaxPeople()));
        facility.setPoolArea(Double.parseDouble(facilityDto.getPoolArea()));
        this.iFacilityRepository.save(facility);
    }

    @Override
    public List<Facility> findAllFacility() {
        return this.iFacilityRepository.findAll();
    }
}
