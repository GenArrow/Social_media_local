package socialnetwork.service;

import socialnetwork.domain.Mesaj;
import socialnetwork.repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MesajService {
    private final Repository<Long, Mesaj> repo;

    public MesajService(Repository<Long, Mesaj> repo) {
        this.repo = repo;
    }

    public void addMesaj(Mesaj mesaj) {
        repo.save(mesaj);
    }

    public void removeMesaj(Long id) {
        repo.delete(id);

    }

    public void updateMesaj(Mesaj mesaj) {
        repo.update(mesaj);
    }

    public Mesaj findOne(Long id) {
        return repo.findOne(id);
    }

    public Iterable<Mesaj> getAll() {
        return repo.findAll();
    }

    public List<String> Conversation_History(Long id1, Long id2) {
        List<String> detalii_mesaj = new ArrayList<>();
        List<Mesaj> listaMesaje = StreamSupport.stream(repo.findAll().spliterator(), false).filter(mesaj -> ((Objects.equals(mesaj.getSender().getId(), id1) && Objects.equals(mesaj.getRecieveri().get(0).getId(), id2))
        || (Objects.equals(mesaj.getSender().getId(), id2) && Objects.equals(mesaj.getRecieveri().get(0).getId(), id1)))).sorted(Comparator.comparing(Mesaj::getData)).collect(Collectors.toList());

        for(Mesaj mesaj : listaMesaje)
        {
            detalii_mesaj.add("From: " + mesaj.getSender().getNume() + " to " + mesaj.getRecieveri().get(0).getNume() + "  Saying: " + '"' + mesaj.getMesaj() + '"');
        }
        return detalii_mesaj;
    }
}
