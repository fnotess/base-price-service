package com.sysco.rps.service;

import com.sysco.rps.dto.CustomerPrice;
import com.sysco.rps.dto.CustomerPriceRequest;
import com.sysco.rps.dto.Product;
import com.sysco.rps.repository.refpricing.CustomerPriceRepository;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sanjaya Amarasinghe
 * @copyright (C) 2020, Sysco Corporation
 * @doc
 * @end Created : 18. Jun 2020 16:00
 */

@Service
public class CustomerPriceService {

    @Autowired
    private CustomerPriceRepository repository;

    public Mono<CustomerPrice> pricesByOpCo(CustomerPriceRequest request, Integer requestedSupcsPerQuery) {

        int supcsPerQuery = (requestedSupcsPerQuery == null) ? request.getProducts().size() : requestedSupcsPerQuery;

        List<List<String>> supcsPartitions = ListUtils.partition(request.getProducts(), supcsPerQuery);
        Map<String, Product> productMap = new HashMap<>();

        return Flux.fromIterable(supcsPartitions)
              .flatMap(supcPartition -> repository.getPricesByOpCo(request, supcPartition))
              .map(p -> {
                  String supc = p.getSupc();
                  Product existingProduct = productMap.get(supc);

                  if (existingProduct == null || (existingProduct.getPriceExportDate() < p.getPriceExportDate())) {
                      productMap.put(supc, p);
                  }

                  return p;
              })
              .collectList()
              .flatMap(v ->
                    Mono.just(new CustomerPrice(request, new ArrayList<>(productMap.values())))
              );

    }
}
