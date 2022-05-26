package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.AttachService;
import vn.codegym.repository.IAttachServiceRepository;
import vn.codegym.service.IAttachServiceService;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> allAttachService() {
        return this.iAttachServiceRepository.findAll();
    }
}
