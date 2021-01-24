package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.enums.Surface;
import p.tomaszewski.FastRace.logic.RaceService;
import p.tomaszewski.FastRace.model.Race;
import p.tomaszewski.FastRace.model.RaceRepository;
import p.tomaszewski.FastRace.model.projection.DriverWriteModel;
import p.tomaszewski.FastRace.model.projection.RaceWriteModel;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RaceController {
    private static final Logger logger= LoggerFactory.getLogger(DriverController.class);
    private final RaceRepository repository;
    private final RaceService service;


    public RaceController(final RaceRepository repository, RaceService service) {
        this.repository = repository;
        this.service = service;
    }

//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    String showRaces(Model model){
//        model.addAttribute("race", new RaceWriteModel());
//        return "addRace";
//    }
//
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    String addRace(@Valid
//                   @ModelAttribute("race") RaceWriteModel current,
//                   BindingResult bindingResult,
//                   Model model){
//        if(bindingResult.hasErrors()){
//            return "addRace";
//        }
//        service.createRace(current);
//        model.addAttribute("race", new RaceWriteModel());
//        return "addRace";
//    }
//
    @ResponseBody
    @PostMapping("/races")
    ResponseEntity<Race> createRace(@RequestBody @Valid Race toCreate){
        Race result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping("/races")
    ResponseEntity<List<Race>> readAllRaces(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }



//
//    @ResponseBody
//    @PutMapping("/{id}")
//    ResponseEntity<?> updateRace(@PathVariable int id, @RequestBody @Valid Race toUpdate){ //PathVariable = id z sciezki
//        if(!repository.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        toUpdate.setId(id);
//        repository.save(toUpdate);
//        return ResponseEntity.noContent().build();
//    }

//    @Transactional
//    @ResponseBody
//    @PatchMapping("/{id}") //zmiana
//    public ResponseEntity<?> toggleDriver(@PathVariable int id){ //PathVariable = id z sciezki
//        if(!repository.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        repository.findById(id)
//                .ifPresent(driver -> driver.setSurface(Surface.ASPHALT));
//        return ResponseEntity.noContent().build();
//    }
}
