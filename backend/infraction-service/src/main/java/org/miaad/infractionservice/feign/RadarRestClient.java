package org.miaad.infractionservice.feign;

import org.miaad.infractionservice.models.Radar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RADAR-SERVICE")
public interface RadarRestClient {
    @GetMapping("api/radar/radars/{id}")
    Radar getByRadarById(@PathVariable(name = "id") Long id);
}
