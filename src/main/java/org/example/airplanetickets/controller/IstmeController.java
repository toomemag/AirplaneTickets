package org.example.airplanetickets.controller;
import org.example.airplanetickets.model.Istekohad;
import org.example.airplanetickets.model.Lennud;
import org.example.airplanetickets.service.IstmeService;
import org.example.airplanetickets.service.LennuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/lennud/{lennud_id}/istekohad")
public class IstmeController {
    private final IstmeService istmeService;
    private final LennuService lennuService;

    public IstmeController(IstmeService istmeService, LennuService lennuService) {
        this.istmeService = istmeService;
        this.lennuService = lennuService;
    }

    @GetMapping
    public String showIstmed(@PathVariable Integer lennud_id, Model model) {
        List<Istekohad> istekohad = istmeService.getIstmedBylennud_id(lennud_id);
        Map<String, Istekohad> istmeMap = new HashMap<>();
        for (Istekohad iste : istekohad) {
            istmeMap.put(iste.getIstme_number(), iste);
        }

        Optional<Lennud> lendOptional = lennuService.getLennudById(lennud_id);
        if (lendOptional.isPresent()) {
            Lennud lend = lendOptional.get();
            model.addAttribute("lend", lend);
        } else {
            model.addAttribute("error", "Lendu ei leitud.");
            return "error";
        }
        model.addAttribute("istmed", istmeMap);
        return "istekohad";
    }
}