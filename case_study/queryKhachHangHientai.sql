SELECT * FROM case_study_module_4.customer;

select cu.id customerId , cu.name customerName,f.name facilityName,f.id facilityId,co.start_date startDate,co.end_date endDate,
group_concat(ats.name) attachServices 
from customer cu inner join contract co on cu.id = co.customer
left join contract_detail cod on co.id = cod.contract_id
left join facility f on f.id = co.facility
left join attach_service ats on cod.attach_service_id = ats.id
where co.start_date <= current_date and co.end_date >=  current_date group by co.id;