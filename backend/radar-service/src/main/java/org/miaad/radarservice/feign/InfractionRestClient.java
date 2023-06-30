package org.miaad.radarservice.feign;

import org.miaad.radarservice.model.Infraction;
import org.miaad.radarservice.model.NewData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "INFRACTION-SERVICE")
public interface InfractionRestClient {

    @PostMapping("/api/infraction/NewInfraction")
    Infraction saveInfraction(@RequestBody NewData newData);
}
