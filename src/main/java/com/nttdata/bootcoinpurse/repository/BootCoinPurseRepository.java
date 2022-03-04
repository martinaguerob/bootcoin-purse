package com.nttdata.bootcoinpurse.repository;

import com.nttdata.bootcoinpurse.entity.BootCoinPurse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BootCoinPurseRepository extends ReactiveMongoRepository<BootCoinPurse, String> {

    Mono<BootCoinPurse> findByNumberPurse(String numberPurse);
}
