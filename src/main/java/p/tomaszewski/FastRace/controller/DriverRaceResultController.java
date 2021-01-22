package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.logic.DriverRaceResultService;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.logic.RaceService;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;
import p.tomaszewski.FastRace.model.projection.DriverRaceResultWriteModel;
import p.tomaszewski.FastRace.model.projection.DriverReadModel;
import p.tomaszewski.FastRace.model.projection.RaceReadModel;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverRaceResultController {
    private static final Logger logger = LoggerFactory.getLogger(DriverRaceResultController.class);
    private final DriverRaceResultRepository repository;
    private final DriverRaceResultService service;
    private final RaceService raceService;
    private final DriverService driverService;


    public DriverRaceResultController(final DriverRaceResultRepository repository,
                                      DriverRaceResultService service,
                                      RaceService raceService, DriverService driverService) {
        this.repository = repository;
        this.service = service;
        this.raceService = raceService;
        this.driverService = driverService;
    }


//    @GetMapping("/addScore")
//    String showScorePage(Model model){
//        var driverRaceResult = new DriverRaceResult();
//        model.addAttribute("driverraceresult", driverRaceResult);
//        return "addScore";
//    }
//
//    @PostMapping("/addScore")
//    String addScore(@Valid
//                   @ModelAttribute("driverraceresult") DriverRaceResultWriteModel current,
//                   BindingResult bindingResult,
//                   Model model) {
//        if (bindingResult.hasErrors()) {
//            return "addScore";
//        }
//
//        /*
//        Zamiana pobranego numeru Id na obiekt mu odpowiadający
//        RaceId -> Race
//        DriverId -> Driver
//         */
//        if(!repository.checkValueExists(current.getRace(), current.getDriver())) {
//            current.setRaceObject(raceService.findById(current.getRace()).get());
//            current.setDriverObject(driverService.findById(current.getDriver()).get());
//            service.createDriverRaceResultService(current);
//            model.addAttribute("driverraceresult", new DriverRaceResultWriteModel());
//            return "redirect:/addScore";
//        } else {
//            return "/addScore";
//        }
//    }

//    @PatchMapping("/{id}") //zmiana
//    public ResponseEntity<?> toggleDriver(@PathVariable int id){ //PathVariable = id z sciezki
//        if(!repository.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
////        repository.findById(id)
////                .ifPresent(driver -> driver.setCar("Brabus"));
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    String showRaces(Model model){
//        model.addAttribute("result", new DriverRaceResultWriteModel());
//        return "addScore";
//    }

    @ResponseBody
    @PostMapping("/addScore")
    ResponseEntity<DriverRaceResult> createDriverRaceResult(@RequestBody @Valid DriverRaceResult toCreate) {
        DriverRaceResult result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
//
    @ResponseBody
    @GetMapping("/addScore")
    ResponseEntity<List<DriverRaceResult>> readAllDriverRaceResult() {
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }
//    @ResponseBody
//    @GetMapping("/{id}")
//    ResponseEntity<DriverRaceResult> readDriverRaceResult(@PathVariable int id) {
//        return repository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @ResponseBody
//    @PutMapping("/{id}")
//    ResponseEntity<?> updateDriverRaceResult(@PathVariable int id, @RequestBody @Valid DriverRaceResult toUpdate) { //PathVariable = id z sciezki
//        if (!repository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        toUpdate.setId(id);
//        repository.save(toUpdate);
//        return ResponseEntity.noContent().build();
//    }
//
//    @ResponseBody
//    @Transactional
//    @PatchMapping("/{id}") //zmiana
//    public ResponseEntity<?> toggleDriverRaceResult(@PathVariable int id) { //PathVariable = id z sciezki
//        if (!repository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        repository.findById(id)
//                .ifPresent(driverRaceResult -> driverRaceResult.setScore(5));
//        return ResponseEntity.noContent().build();
//    }

    @ModelAttribute("races")
    List<RaceReadModel> getRaces(){
        return raceService.readAll();
    }

    @ModelAttribute("drivers")
    List<DriverReadModel> getDrivers(){
        return driverService.readAll();
    }
}
