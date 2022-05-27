package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.ContractDto;
import vn.codegym.dto.FacilityDto;
import vn.codegym.dto.ICustomerDto;
import vn.codegym.model.*;
import vn.codegym.service.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachServiceService iAttachServiceService;

    @ModelAttribute("employees")
    public List<Employee> findAllEmployee(){
        return this.iEmployeeService.findAllEmployee();
    }

    @ModelAttribute("customers")
    public List<Customer> findAllCustomer(){
        return this.iCustomerService.findAllCustomer();
    }

    @ModelAttribute("facilities")
    public List<Facility> findAllFacility(){
        return this.iFacilityService.findAllFacility();
    }

    @GetMapping("")
    public String listContract(Model model,@PageableDefault(value=4) Pageable pageable){
        Page<Contract> contractPage = this.iContractService.findAll(pageable);
        model.addAttribute("contracts",contractPage);
        return "/contracts/list";
    }

    @GetMapping("/new")
    public String newContractForm(Model model){
        ContractDto contractDto = new ContractDto();
        contractDto.setStartDate(LocalDate.now().toString());
        model.addAttribute("contractDto",contractDto);
        return "/contracts/new";
    }

    @PostMapping("/new")
    public String newContract(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "contracts/new";
        }
        this.iContractService.add(contractDto);
        return "redirect:/contracts/";
    }

//    @GetMapping("/using-service")
//    public String customerUsingService(Model model){
//        List<Contract> contracts = this.iContractService.takeEffectContracts();
//        List<ContractDto> contractDtoList = this.iContractService.copyList(contracts);
//        List<ContractDetail> contractDetails = this.iContractDetailService.findAll();
//
//        Map<ContractDto,String> contractStringMap = new HashMap<>();
//        for (ContractDto con: contractDtoList
//             ) {
//            if(!contractStringMap.containsKey(con)){
//                String text = "";
//                for (int i = 0; i < contractDetails.size() ; i++) {
//                    if(contractDetails.get(i).getContractId().getId() == con.getId()){
//                        if(!text.contains(contractDetails.get(i).getAttachService().getName())){
//                            text += contractDetails.get(i).getAttachService().getName()+",";
//                        }
//                    };
//                }
//                contractStringMap.put(con,text);
//            }
//        }
//
//        model.addAttribute("concatStringMap",contractStringMap);
//        return "/contracts/customer-using-service";
//    }

    @GetMapping("/take-effect")
    public String takeEffectService(@PageableDefault(value=2) Pageable pageable,Model model){
        Page<ICustomerDto> customersTakeEffectService = this.iContractService.takeEffectService(pageable);
        model.addAttribute("customersTakeEffectService",customersTakeEffectService);
        return "/contracts/customer-using-service";
    }

    @ExceptionHandler(Exception.class)
    public String error(){
        return "404-page";
    }
}
