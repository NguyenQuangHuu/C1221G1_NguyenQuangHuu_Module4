package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.dto.ICustomerDto;
import vn.codegym.model.Contract;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value="select cu.id customerId , cu.name customerName,f.name facilityName,f.id facilityId,co.start_date startDate,co.end_date endDate,\n" +
            "group_concat(ats.name) attachServices \n" +
            "from customer cu inner join contract co on cu.id = co.customer\n" +
            "left join contract_detail cod on co.id = cod.contract_id\n" +
            "left join facility f on f.id = co.facility\n" +
            "left join attach_service ats on cod.attach_service_id = ats.id\n" +
            "where co.start_date <= current_date and co.end_date >=  current_date group by co.id",
            countQuery="select cu.id customerId , cu.name customerName,f.name facilityName,f.id facilityId,co.start_date startDate,co.end_date endDate,\n" +
                    "group_concat(ats.name) attachServices \n" +
                    "from customer cu inner join contract co on cu.id = co.customer\n" +
                    "left join contract_detail cod on co.id = cod.contract_id\n" +
                    "left join facility f on f.id = co.facility\n" +
                    "left join attach_service ats on cod.attach_service_id = ats.id\n" +
                    "where co.start_date <= current_date and co.end_date >=  current_date group by co.id",nativeQuery=true)
    Page<ICustomerDto> takeEffectContract(Pageable pageable);
}
