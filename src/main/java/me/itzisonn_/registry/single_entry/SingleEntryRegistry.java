package me.itzisonn_.registry.single_entry;

import me.itzisonn_.registry.Registry;
import me.itzisonn_.registry.RegistryEntry;

/**
 * Registry with only one possible entry
 *
 * @param <T> Entry's type
 */
public interface SingleEntryRegistry<T> extends Registry<T> {
    /**
     * @return Registered entry
     */
    RegistryEntry<T> getEntry();

    /**
     * @return Has registered entry
     */
    default boolean hasEntry() {
        return getEntry() != null;
    }
}
