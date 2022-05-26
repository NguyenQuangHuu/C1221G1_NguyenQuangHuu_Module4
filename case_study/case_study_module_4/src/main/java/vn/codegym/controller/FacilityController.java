package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.dto.FacilityDto;
import vn.codegym.model.Facility;
import vn.codegym.model.FacilityType;
import vn.codegym.model.RentType;
import vn.codegym.service.IFacilityService;
import vn.codegym.service.IFacilityTypeService;
import vn.codegym.service.IRentTypeService;

import java.util.List;

@Controller
@RequestMapping("service")
public class FacilityController {

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("rentTypes")
    public List<RentType> listRentType(){
        return this.iRentTypeService.findAll();
    }

    @ModelAttribute("facilityTypes")
    public List<FacilityType> listFacilityType(){
        return this.iFacilityTypeService.findAll();
    }

    @GetMapping("")
    public String facilityGetAll(Model model, Pageable pageable){
        Page<Facility> facilityPage = this.iFacilityService.findAll(pageable);
        model.addAttribute("facilityPage",facilityPage);
        return "/services/list";
    }

    @GetMapping("/new")
    public String newFacilityForm(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        return "/services/new";
    }

    @PostMapping("/new")
    public String newFacility(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult){
        new FacilityDto().validate(facilityDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/services/new";
        }
        this.iFacilityService.save(facilityDto);
        return "redirect:/service/";
    }
}
