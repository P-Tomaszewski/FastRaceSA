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
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;
import p.tomaszewski.FastRace.model.DriverResult;
import p.tomaszewski.FastRace.model.projection.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    public HomeController() {
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    String showResultToDriver(Model model){
        return "home";
    }
}
