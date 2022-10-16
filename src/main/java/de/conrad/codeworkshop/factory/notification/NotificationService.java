package de.conrad.codeworkshop.factory.notification;

import de.conrad.codeworkshop.factory.order.api.OrderCreateRequest;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Andreas Hartmann
 */
@Service
public class NotificationService {

    public void notifyCustomer(@NonNull final OrderCreateRequest orderCreateRequest) {
        // Dummy function that would notify the customer that manufacturing is completed.
        try {
            Thread.sleep(500);
        } catch (final InterruptedException interruptedException) {
            System.err.println(interruptedException.getMessage());
            // Do nothing
        }
    }
}
