package com.nttdata.bootcoinpurse.controller;

import com.netflix.discovery.converters.Auto;
import com.nttdata.bootcoinpurse.entity.BootCoinPurse;
import com.nttdata.bootcoinpurse.service.BootCoinPurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bootcoin-purse")
public class BootCoinPurseController {

    @Autowired
    BootCoinPurseService bootCoinPurseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootCoinPurse> getBootCoinPurse(){
        return bootCoinPurseService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BootCoinPurse> saveBootCoinPurse(@RequestBody BootCoinPurse bootCoinPurse){
        return bootCoinPurseService.save(bootCoinPurse);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurse> updateBootCoinPurse(@RequestBody BootCoinPurse bootCoinPurse, @PathVariable String id){
        return bootCoinPurseService.update(bootCoinPurse, id);
    }


    @GetMapping("/purse/{numberPurse}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurse> getBootCoinPurseByNumberPurse(@PathVariable String numberPurse){
        return bootCoinPurseService.findByNumberPurse(numberPurse);
    }
}