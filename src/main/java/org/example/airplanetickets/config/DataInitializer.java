package org.example.airplanetickets.config;
import org.example.airplanetickets.AbiMeetodid;
import org.example.airplanetickets.model.Lennud;
import org.example.airplanetickets.model.Istekohad;
import org.example.airplanetickets.repository.LennuRepository;
import org.example.airplanetickets.repository.IstmeRepository;
import org.example.airplanetickets.service.LennuService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Component
public class DataInitializer implements ApplicationRunner {
    private final LennuRepository LennuRepository;
    private final IstmeRepository IstmeRepository;
    private final LennuService lennuService;
    public DataInitializer(LennuRepository LennuRepository, IstmeRepository IstmeRepository, LennuService lennuService) {
        this.LennuRepository = LennuRepository;
        this.IstmeRepository = IstmeRepository;
        this.lennuService = lennuService;
    }
    //Meetod, et luua lennud kui pole ühtegi lendu
    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        if(lennuService.getAllLennud().isEmpty()) {
            for (int k = 1; k <= 25 ; k++) {
                Lennud lennud = new Lennud();
                AbiMeetodid linnad = new AbiMeetodid();
                lennud.setHind(linnad.hinnad());
                lennud.setSihtkoht(linnad.linnad());
                lennud.setLennuaeg(linnad.valjumisAjad());
                lennud.setKuupaev(LocalDate.now().plusDays(14));
                LennuRepository.save(lennud);
                for (int i = 1; i <= 6; i++) {
                    for (int j = 1; j <= 7; j++) {
                        Istekohad iste = new Istekohad();
                        String rida = "";
                        boolean aken = false;
                        if (i == 1) {
                            rida = "A";
                            aken = true;
                        } else if (i == 2) rida = "B";
                        else if (i == 3) rida = "C";
                        else if (i == 4) rida = "D";
                        else if (i == 5) rida = "E";
                        else if (i == 6) {
                            rida = "F";
                            aken = true;
                        }
                        iste.setIstme_number(rida + j);
                        iste.setOn_vaba(true);
                        iste.setOn_aknaall((aken && j == 1) || (aken && j == 4) || (aken && j ==7));
                        aken = false;
                        iste.setOn_jalaruum(3 >= j);
                        iste.setOn_valjapaas(i == 3 || i == 4);
                        iste.setOn_vaba(Math.random() > 0.4);
                        iste.setLennud(lennud);
                        IstmeRepository.save(iste);
                    }
                }
            }
        }
    }
}