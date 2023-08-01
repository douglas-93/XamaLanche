package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loja")
public class LojaResource {

    @Autowired private LojaService lojaService;

    @GetMapping()
    public List<Loja> findAll(){
        return lojaService.findAll();
    }
}
