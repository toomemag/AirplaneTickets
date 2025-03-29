package org.example.airplanetickets.service;
import org.example.airplanetickets.model.Lennud;
import org.example.airplanetickets.repository.LennuRepository;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LennuService {
    private final LennuRepository lennuRepository;

    public LennuService(LennuRepository lennuRepository) {
        this.lennuRepository = lennuRepository;
    }
    public List<Lennud> getAllLennud() {
        return lennuRepository.findAll();
    }
    public List<Lennud> getFilteredLennudByStringTime(LocalDate kuupaev, String lennuaeg, String sihtkoht) {
        return lennuRepository.findAll().stream()
                .filter(lennud -> (kuupaev == null || lennud.getKuupäev().equals(kuupaev)) &&
                        ((lennuaeg == null || lennuaeg.isEmpty()) || lennud.getLennuaeg().toString().equals(lennuaeg)) &&
                        (sihtkoht == null || sihtkoht.isEmpty() || lennud.getSihtkoht().equalsIgnoreCase(sihtkoht)))
                .collect(Collectors.toList());
    }
    public Set<String> getUniqueSihtkohad() {
        return lennuRepository.findAll().stream().map(Lennud::getSihtkoht).collect(Collectors.toSet());
    }
    public Set<Time> getUniqueLennuajad() {
        return lennuRepository.findAll().stream().map(Lennud::getLennuaeg).collect(Collectors.toSet());
    }
    public Set<LocalDate> getUniqueKuupaev() {
        return lennuRepository.findAll().stream().map(Lennud::getKuupäev).collect(Collectors.toSet());
    }
    public Optional<Lennud> getLennudById(Integer id) {
        return lennuRepository.findById(Long.valueOf(id));
    }
}
