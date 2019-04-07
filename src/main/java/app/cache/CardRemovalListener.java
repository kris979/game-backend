package app.cache;

import app.model.CardEntity;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.springframework.stereotype.Component;

@Component
public class CardRemovalListener implements RemovalListener<Long, CardEntity> {

    @Override
    public void onRemoval(RemovalNotification<Long, CardEntity> removalNotification) {
        System.out.println(removalNotification.getValue() + " was removed from cache.");
    }
}
