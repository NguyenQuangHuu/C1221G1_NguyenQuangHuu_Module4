package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.model.AttachService;

public interface IAttachServiceRepository extends JpaRepository<AttachService,Integer> {
    
}
