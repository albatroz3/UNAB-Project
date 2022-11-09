package project.reto345.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.reto345.model.Costume;
import project.reto345.repository.CostumeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll() {
        return costumeRepository.getAll();
    }

    public Optional<Costume> getCostume(int id) {
        return costumeRepository.getCostume(id);
    }

    public Costume save(Costume costume) {
        if (costume.getId() == null) {
            return costumeRepository.save(costume);
        } else {
            Optional<Costume> aux = costumeRepository.getCostume(costume.getId());
            if (aux.isPresent()) {
                return costume;
            } else {
                return costumeRepository.save(costume);
            }
        }
    }

    public Costume update(Costume costume) {
        if (costume.getId() != null) {
            Optional<Costume> c = costumeRepository.getCostume(costume.getId());
            if (c.isPresent()) {
                if (costume.getName() != null) {
                    c.get().setName(costume.getName());
                }
                if (costume.getBrand() != null) {
                    c.get().setBrand(costume.getBrand());
                }
                if (costume.getYear() != null) {
                    c.get().setYear(costume.getYear());
                }
                if (costume.getDescription() != null) {
                    c.get().setDescription(costume.getDescription());
                }
                if (costume.getCategory() != null) {
                    c.get().setCategory(costume.getCategory());
                }
                if (costume.getMessages() != null) {
                    c.get().setMessages(costume.getMessages());
                }
                if (costume.getReservations() != null) {
                    c.get().setReservations(costume.getReservations());
                }
                costumeRepository.save(c.get());
                return c.get();
            } else {
                return costume;
            }
        } else {
            return costume;
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<Costume> c = costumeRepository.getCostume(id);
        if (c.isPresent()) {
            costumeRepository.delete(c.get());
        }
        return flag;
    }
}
