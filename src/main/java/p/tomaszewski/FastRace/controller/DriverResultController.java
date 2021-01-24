package p.tomaszewski.FastRace.controller;

import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.logic.RaceService;
import p.tomaszewski.FastRace.model.*;
import p.tomaszewski.FastRace.model.projection.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverResultController {
    private final DriverService service;
    private final RaceService raceService;
    private final DriverRaceResultRepository driverRaceResultRepository;
    private final RaceRepository repository;
    private final DriverRepository driverRepository;




    public DriverResultController(DriverService service, RaceService raceService, DriverRaceResultRepository driverRaceResultService, RaceRepository repository, DriverRepository driverRepository) {
        this.service = service;
        this.raceService = raceService;
        this.driverRaceResultRepository = driverRaceResultService;
        this.repository = repository;
        this.driverRepository = driverRepository;
    }

    //Trzeba z tym id

//    @ResponseBody
//    @GetMapping("/{id}" produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<Race> readRaces(@PathVariable int id){
//        return repository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }


//
    @ResponseBody
    @PostMapping("/result")
    public List<DriverResultModel> getDriverResult(@RequestBody Integer driverId){
        System.out.println(driverId);
        Driver driver = new Driver();
        List<DriverResultModel> driverResultModelList = new ArrayList<>();
        driver = driverRepository.findById(driverId).get();
        List<DriverRaceResult> driverRaceResults = driver.getDriverRaceResults();
        for(int i = 0; i<driverRaceResults.size(); i++){
            DriverResultModel driverResultModel = new DriverResultModel();
            driverResultModel.setRaceName(driverRaceResults.get(i).getRace().getName());
            driverResultModel.setScore(driverRaceResults.get(i).getScore());
        }
        return driverResultModelList;
    }

//
//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    String showResultToDriver(Model model){
//        model.getAttribute("result2");
//        var drivers = new DriverResult();
//        drivers.getDriverName();
//        model.addAttribute("result2", drivers);
//        return "result";
//    }
//
//
//
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    String setResult(@Valid @ModelAttribute("result2") DriverResult currency, BindingResult bindingResult, Model model){
//        DriverResult driverResult = new DriverResult();
//        Set<DriverRaceResult> driverRaceResultReadModelList;
//
//        if (bindingResult.hasErrors()) {
//            return "result";
//        }

//        if(!model.getAttribute("result2").equals(null)) {
//            driverResult.setDriver(currency.getDriver());
//            driverResult.setDriverName(service.findById(currency.getDriver()).get().firstName);
//            Driver driver = repository.findById(currency.getDriver()).get();
//            driverRaceResultReadModelList = driver.getDriverRaceResults();
//            driverResult.setRaceResults(driverRaceResultReadModelList);
//            model.addAttribute("resultByDriver", driverResult);
////        }
//
//        return "result";
//    }


    @ModelAttribute("drivers")
    List<DriverReadModel> getDrivers(){
        return service.readAll();
    }

    @ModelAttribute("races")
    List<RaceReadModel> getRaces(){
        return raceService.readAll();
    }

//    @ModelAttribute("results")
//    List<DriverRaceResultReadModel> getResults(){
//        return driverRaceResultService.readAll();
//    }


}
