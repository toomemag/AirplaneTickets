package org.example.airplanetickets.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.airplanetickets.model.Lennud;
import org.example.airplanetickets.service.LennuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
public class LennuController {
    private static final Logger logger = LoggerFactory.getLogger(LennuController.class);

    private final LennuService lennuService;

    public LennuController(LennuService lennuService) {
        this.lennuService = lennuService;
    }

    @GetMapping("/lennud")
    public String showFlights(
            @RequestParam(required = false) LocalDate kuupaev,
            @RequestParam(required = false) String lennuaeg,
            @RequestParam(required = false) String sihtkoht,
            Model model) {

        logger.info("kuupaev from form: {}", kuupaev);
        logger.info("sihtkoht from form: {}", sihtkoht);
        logger.info("lennuaeg from form: {}", lennuaeg);

        List<Lennud> filteredFlights = lennuService.getFilteredLennudByStringTime(kuupaev, lennuaeg, sihtkoht);
        Set<String> uniqueSihtkohad = lennuService.getUniqueSihtkohad();
        Set<Time> uniqueLennuajad = lennuService.getUniqueLennuajad();
        Set<LocalDate> uniqueKuupäevad = lennuService.getUniqueKuupaev();
        model.addAttribute("lennudList", filteredFlights);
        model.addAttribute("sihtkohad", uniqueSihtkohad);
        model.addAttribute("lennuajad", uniqueLennuajad);
        model.addAttribute("kuupaevad", uniqueKuupäevad);
        model.addAttribute("kuupaev", kuupaev);
        model.addAttribute("lennuaeg", lennuaeg);
        model.addAttribute("sihtkoht", sihtkoht);

        return "lennud";
    }
}