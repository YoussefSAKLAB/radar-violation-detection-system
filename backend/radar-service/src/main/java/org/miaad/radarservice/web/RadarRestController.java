package org.miaad.radarservice.web;

import org.miaad.radarservice.entites.Radar;

import org.miaad.radarservice.model.NewData;
import org.miaad.radarservice.repositories.RadarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.miaad.radarservice.feign.InfractionRestClient;
import java.util.List;

@RestController
@RestResource
@RequestMapping("/api/radar")
@Component
public class RadarRestController {
    private RadarRepository radarRepository;

    private InfractionRestClient infractionRestClient;

    public RadarRestController(RadarRepository radarRepository, InfractionRestClient infractionRestClient) {
        this.radarRepository = radarRepository;
        this.infractionRestClient = infractionRestClient;
    }

    // Operations in Radars

    // - Get all radars


    @GetMapping("/pageRadar")
    public Page<Radar> getPageRadar(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return radarRepository.findAll(pageable);
    }

    @GetMapping("/pageRadarName/{keyword}")
    public Page<Radar> getRadarsByName(@PathVariable String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (keyword.equals(null)) return radarRepository.findAll(pageable);
        return radarRepository.findByNameContains(keyword, pageable);
    }
    @GetMapping("/radars")
    public List<Radar> getRadars(){
        return radarRepository.findAll();
    }

    @GetMapping("/count")
    public Long getRadarsCount() {
        return radarRepository.count();
    }

    @GetMapping("/radars/{id}")
    public Radar getRadarById(@PathVariable Long id){
        return radarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Radar %s not found !", id)));
    }
    @PostMapping("/radars")
    public Radar saveRadar(@RequestBody Radar radar){
        return radarRepository.save(radar);
    }
    @PutMapping("/radars/{id}")
    public Radar updateRadar(@PathVariable Long id,@RequestBody Radar radar){
        Radar r = radarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Radar with this id :%s is not found !", id)));
        if (radar.getName() != null) r.setName(radar.getName());
        if (radar.getStatus() != null) r.setStatus(radar.getStatus());
        if (radar.getMaxSpeed() != null) r.setMaxSpeed(radar.getMaxSpeed());
        if (radar.getLongitude() != null) r.setLongitude(radar.getLongitude());
        if(radar.getLatitude()!=null) r.setLatitude(radar.getLatitude());
        return radarRepository.save(r);
    }
    @DeleteMapping("/radars/id")
    public void deleteRadar(@PathVariable Long id){
        radarRepository.deleteById(id);
    }
    /*NewData newData = NewData.builder()
            .radarId(3L)
            .rn("A6606")
            .build();*/
    @PostMapping("/newInfraction")
    public void newInfraction(@RequestBody NewData newData){
        infractionRestClient.saveInfraction(newData);
    }

}
