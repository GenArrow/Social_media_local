package socialnetwork.repository.file;

import socialnetwork.domain.Prietenie;
import socialnetwork.domain.Tuple;
import socialnetwork.domain.validators.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PrietenieFileRepository extends AbstractFileRepository<Tuple<Long, Long>, Prietenie> {

    public PrietenieFileRepository(String fileName, Validator<Prietenie> validator) {
        super(fileName, validator);
    }

    @Override
    public Prietenie extractEntity(List<String> attributes) {
        Prietenie prietenie = new Prietenie(Long.parseLong(attributes.get(0)),
                Long.parseLong(attributes.get(1)), LocalDateTime.parse(attributes.get(2), DateTimeFormatter.ISO_DATE_TIME));
        return prietenie;
    }

    @Override
    protected String createEntityAsString(Prietenie entity) {
        String dateTime = entity.getDate().format(DateTimeFormatter.ISO_DATE_TIME);
        return entity.getId().getL() + ";" + entity.getId().getR() + ";" + dateTime;
    }
}
