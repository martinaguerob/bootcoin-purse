package com.nttdata.bootcoinpurse.service;

import com.nttdata.bootcoinpurse.entity.BootCoinPurse;
import reactor.core.publisher.Mono;

public interface BootCoinPurseService extends CrudService <BootCoinPurse, String> {

    Mono<BootCoinPurse> findByNumberPurse(String numberPurse);
}
