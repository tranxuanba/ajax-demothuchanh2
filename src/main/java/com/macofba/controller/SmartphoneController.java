package com.macofba.controller;

import com.macofba.model.Smatrphone;
import com.macofba.service.ISmartphoneSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneSrevice smartphoneSrevice;
    @PostMapping
    public ResponseEntity<Smatrphone> createSmartphone(@RequestBody Smatrphone smatrphone){
        return new ResponseEntity<>(smartphoneSrevice.save(smatrphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(){
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<Smatrphone> smatrphones = smartphoneSrevice.findAll();
        modelAndView.addObject("smartphones", smatrphones);
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Smatrphone>> allPhones() {
        return new ResponseEntity<>(smartphoneSrevice.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smatrphone> deleteSmartphone(@PathVariable Long id){
        Optional<Smatrphone> smatrphoneOptional = smartphoneSrevice.findById(id);
        if (!smatrphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneSrevice.remove(id);
        return new ResponseEntity<>(smatrphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
