package net.ausiasmarch.tiendaonlineserver.helper;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerationHelper {

    public static LocalDateTime getRandomDate(LocalDateTime fechaPedido) {
        LocalDateTime fechaEntrega;

        do {
            fechaEntrega = fechaPedido.plusDays(ThreadLocalRandom.current().nextLong(2, 15));
        } while (fechaEntrega.isBefore(fechaPedido));

        return fechaEntrega;

    }

}
