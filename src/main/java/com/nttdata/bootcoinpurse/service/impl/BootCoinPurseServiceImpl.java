package com.nttdata.bootcoinpurse.service.impl;

import com.nttdata.bootcoinpurse.entity.BootCoinPurse;
import com.nttdata.bootcoinpurse.repository.BootCoinPurseRepository;
import com.nttdata.bootcoinpurse.service.BootCoinPurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class BootCoinPurseServiceImpl implements BootCoinPurseService {

    @Autowired
    BootCoinPurseRepository bootCoinPurseRepository;

    @Override
    public Flux<BootCoinPurse> findAll() {
        return bootCoinPurseRepository.findAll();
    }

    @Override
    public Mono<BootCoinPurse> save(BootCoinPurse entity) {
        entity.setCreatedAt(new Date());
        entity.setStatus(true);
        entity.setAmount(0.00);
        return bootCoinPurseRepository.save(entity);
    }

    @Override
    public Mono<BootCoinPurse> update(BootCoinPurse entity, String id) {
        System.out.println("Se actualizó purse");
        return  bootCoinPurseRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    entity.setAmount(entity.getAmount()==null ? origin.getAmount() : entity.getAmount());
                    entity.setNumberPurse(entity.getNumberPurse()==null ? origin.getNumberPurse() : entity.getNumberPurse());
                    return bootCoinPurseRepository.save(origin);
                });
    }

    @Override
    public Mono<BootCoinPurse> deleteById(String id) {
        return bootCoinPurseRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setStatus(false);
                    return bootCoinPurseRepository.save(origin);
                });
    }

    @Override
    public Mono<BootCoinPurse> findByNumberPurse(String numberPurse) {
        return bootCoinPurseRepository.findByNumberPurse(numberPurse);
    }
}
