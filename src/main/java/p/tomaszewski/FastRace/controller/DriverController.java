package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
    private static final Logger logger= LoggerFactory.getLogger(DriverController.class);
    private final DriverRepository repository;
    private final DriverService service;

    public DriverController(final DriverRepository repository, DriverService service) {
        this.repository = repository;
        this.service = service;
    }

//    @GetMapping("/addDriver")
//    String getDriverPage(Model model){
//        var driverToEdit = new Driver();
//        model.addAttribute("driver", driverToEdit);
//        return "addDriver";
//    }
//
//    @PostMapping("/addDriver")
//    String addDriver(@Valid
//                      @ModelAttribute("driver") DriverWriteModel current,
//                      BindingResult bindingResult,
//                      Model model){
//        if(bindingResult.hasErrors()){
//            return "addDriver";
//        }
//        service.createDriver(current);
//        model.addAttribute("driver", new DriverWriteModel());
//        return "addDriver";
//    }
//
//    @GetMapping("/deleteDriver")
//    public String deleteDriverGet(Model model){
//        model.addAttribute("drivers", repository.findAll());
//        return "deleteDriver";
//    }
//
    @DeleteMapping(value = "/delete/{driverId}")
    public void deleteDriver(@PathVariable("driverId") Integer driverId){
        if(driverId != null) {

            Driver driver = repository.findById(driverId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + driverId));
            repository.deleteById(driver.getId());
        }
    }
//






    @ResponseBody
    @PostMapping("/drivers")
    ResponseEntity<Driver> creatDriver(@RequestBody @Valid Driver toCreate){
        Driver result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @RequestMapping("/drivers")
    public List<Driver> getDrivers(){
        logger.warn("Exposing all tasks");
        return repository.findAll();
    }

//    @ResponseBody
//    @GetMapping("/{id}")
//        ResponseEntity<Driver> readDriver(@PathVariable int id){
//        return repository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//        }
//
//    @ResponseBody
//    @PutMapping("/{id}")
//    ResponseEntity<?> updateDriver(@PathVariable int id, @RequestBody @Valid Driver toUpdate){ //PathVariable = id z sciezki
//        if(!repository.existsById(id)){
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
//    public ResponseEntity<?> toggleDriver(@PathVariable int id){ //PathVariable = id z sciezki
//        if(!repository.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        repository.findById(id)
//                .ifPresent(driver -> driver.setCar("Brabus"));
//        return ResponseEntity.noContent().build();
//    }
}
