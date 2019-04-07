package app.cache;


import app.data.DbCardRepository;
import app.model.CardEntity;
import com.google.common.cache.CacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class CardCacheLoader extends CacheLoader<Long, CardEntity> {

    private DbCardRepository databaseRepository;

    @Autowired
    public CardCacheLoader(DbCardRepository databaseRepository) {
        super();
        this.databaseRepository = databaseRepository;
    }

    @Override
    public CardEntity load(Long aLong) throws Exception {
        return getById(aLong);
    }

    private CardEntity getById(Long id) throws EntityNotFoundException {
        Optional<CardEntity> card = this.databaseRepository.findById(id);
        if (!card.isPresent()) {
            throw new EntityNotFoundException(String.format("Card with id=%d does not exist. Are you sure you have got correct id?", id));
        } else {
            return card.get();
        }
    }
}
