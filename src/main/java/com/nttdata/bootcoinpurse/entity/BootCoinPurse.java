package com.nttdata.bootcoinpurse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "bootcoin-purse")
public class BootCoinPurse {
    @Id
    private String id;
    private String numberPurse; //Número de cuenta del monedero
    private Double amount; //Monto
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
    private Boolean status;
}
