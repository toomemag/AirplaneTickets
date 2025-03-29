package org.example.airplanetickets.service;
import org.example.airplanetickets.model.Istekohad;
import org.example.airplanetickets.repository.IstmeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IstmeService {
    private final IstmeRepository istmeRepository;

    public IstmeService(IstmeRepository seatRepository) {
        this.istmeRepository = seatRepository;
    }
    public List<Istekohad> getIstmedBylennud_id(Integer lennud_id) {
        return istmeRepository.findBylennud_id(lennud_id);
    }
}
