package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Position;
import vn.codegym.repository.IPositionRepository;
import vn.codegym.service.IPositionService;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return this.iPositionRepository.findAll();
    }
}
