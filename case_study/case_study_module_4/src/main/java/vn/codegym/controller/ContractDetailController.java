package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.ContractDetailDto;
import vn.codegym.model.AttachService;
import vn.codegym.model.Contract;
import vn.codegym.service.IAttachServiceService;
import vn.codegym.service.IContractDetailService;
import vn.codegym.service.IContractService;

import java.util.List;

@Controller
@RequestMapping("contracts-detail")
public class ContractDetailController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachServiceService iAttachServiceService;

    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute("contracts")
    public List<Contract> listContract(){
        return this.iContractService.allContract();
    }

    @ModelAttribute("attachService")
    public List<AttachService> listAttachService(){
        return this.iAttachServiceService.allAttachService();
    }

    @GetMapping("/create")
    public String createContractForm(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        return "contracts/detail-contract/new";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute @Validated ContractDetailDto contractDetailDto, BindingResult bindingResult){
        new ContractDetailDto().validate(contractDetailDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/contracts/detail-contract/new";
        }

        this.contractDetailService.save(contractDetailDto);
        return "redirect:/contracts-detail/create";
    }

    @ExceptionHandler(Exception.class)
    public String error(){
        return "404-page";
    }
}
