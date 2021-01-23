package p.tomaszewski.FastRace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;
import p.tomaszewski.FastRace.model.DriverRepository;
import p.tomaszewski.FastRace.model.projection.DriverScoreReadModel;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TopController {
    private final DriverService service;
    private final DriverRaceResultRepository repository;
    private final DriverRepository driverRepository;
    public TopController(DriverService service, DriverRaceResultRepository repository, DriverRepository driverRepository) {
        this.service = service;
        this.repository = repository;
        this.driverRepository = driverRepository;
    }


//    @GetMapping
//    String getTopDrivers(Model model){
//        var drivers = new Driver();
//        model.addAttribute("driver2", drivers);
//        return "top";
//    }

//    @ResponseBody
//    @GetMapping("/top")
//    ResponseEntity<List<DriverRaceResult>> readAllDriverRaceResult() {
////        logger.warn("Exposing all tasks");
//        return ResponseEntity.ok(repository.findAll());
//    }

    @ResponseBody
    @GetMapping("/top")
    public List<DriverScoreReadModel> readAllDriverRaceResult() {
        List<DriverScoreReadModel> driverScoreReadModelList = new ArrayList<>();
        List<Driver> drivers = driverRepository.findAll();
        for (int i= 1; i<drivers.size(); i++){
            DriverScoreReadModel driverScoreReadModel = new DriverScoreReadModel();
            if(repository.getScoreSumByDriverId(drivers.get(i).getId()) != null) {
                driverScoreReadModel.setFirstName(drivers.get(i).firstName);
                driverScoreReadModel.setLastName(drivers.get(i).getLastName());
                driverScoreReadModel.setTeam(drivers.get(i).getTeam());
                driverScoreReadModel.setCar(drivers.get(i).getCar());
                driverScoreReadModel.setScore(repository.getScoreSumByDriverId(drivers.get(i).getId()));
                driverScoreReadModelList.add(driverScoreReadModel);
            }
        }
        driverScoreReadModelList.sort(Comparator.comparingInt(DriverScoreReadModel::getScore).reversed());
        return driverScoreReadModelList.subList(0,3);
    }

//        list.sort(Comparator.comparingInt(DriverReadModel::getDriverRaceResultsScoreSum).reversed());


//    @ModelAttribute("drivers")
//    List<DriverReadModel> getDrivers(){
//        List<DriverReadModel> list = service.readAll();
//        list.sort(Comparator.comparingInt(DriverReadModel::getDriverRaceResultsScoreSum).reversed());
//        return list;
//    }

//    @ModelAttribute("drivers")
//    List<DriverReadModel> showDrivers(){
//        List<DriverReadModel> list = service.readAll();
//        list.sort(Comparator.comparingInt(DriverReadModel::getDriverRaceResultsScoreSum).reversed());
//        return list;
//    }



}
