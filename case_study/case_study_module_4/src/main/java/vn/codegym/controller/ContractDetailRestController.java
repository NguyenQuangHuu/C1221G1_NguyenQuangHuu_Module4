package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.ContractDetailDto;
import vn.codegym.service.IContractDetailService;

@RestController
@RequestMapping("/contract-detail")
public class ContractDetailRestController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody ContractDetailDto contractDetailDto){
        this.iContractDetailService.save(contractDetailDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
