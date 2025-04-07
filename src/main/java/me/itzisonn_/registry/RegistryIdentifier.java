package me.itzisonn_.registry;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Identifier used by registries
 *
 * @see Registry
 * @see RegistryEntry
 */
@Getter
@EqualsAndHashCode
public class RegistryIdentifier {
    public static final String IDENTIFIER_REGEX = "[a-zA-Z_][a-zA-Z0-9_]*";
    private static final Pattern PATTERN = Pattern.compile("(.+):(.+)");

    /**
     * Identifier's namespace
     */
    private final String namespace;
    /**
     * Identifier's id
     */
    private final String id;

    private RegistryIdentifier(String namespace, String id) throws NullPointerException, IllegalArgumentException {
        if (namespace == null) throw new NullPointerException("Namespace can't be null");
        if (id == null) throw new NullPointerException("Id can't be null");

        if (!namespace.matches(IDENTIFIER_REGEX)) throw new IllegalArgumentException("Invalid namespace");
        if (!id.matches(IDENTIFIER_REGEX)) throw new IllegalArgumentException("Invalid id");

        this.namespace = namespace;
        this.id = id;
    }

    /**
     * Creates new RegistryIdentifier
     *
     * @param namespace Identifier's namespace that matches {@link RegistryIdentifier#IDENTIFIER_REGEX}
     * @param id Identifier's id that matches {@link RegistryIdentifier#IDENTIFIER_REGEX}
     * @return New RegistryIdentifier
     *
     * @throws NullPointerException If either namespace or id is null
     * @throws IllegalArgumentException If either namespace or id doesn't match {@link RegistryIdentifier#IDENTIFIER_REGEX}
     */
    public static RegistryIdentifier of(String namespace, String id) throws NullPointerException, IllegalArgumentException {
        return new RegistryIdentifier(namespace, id);
    }

    /**
     * Creates new RegistryIdentifier
     *
     * @param identifier Identifier in format 'namespace:id' where both namespace and id match {@link RegistryIdentifier#IDENTIFIER_REGEX}
     * @return New RegistryIdentifier
     *
     * @throws NullPointerException If given identifier is null
     * @throws IllegalArgumentException If given identifier isn't in required format
     */
    public static RegistryIdentifier of(String identifier) throws NullPointerException, IllegalArgumentException {
        if (identifier == null) throw new NullPointerException("Identifier can't be null");

        Matcher matcher = PATTERN.matcher(identifier);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid identifier '" + identifier + "'");
        }

        return new RegistryIdentifier(matcher.group(1), matcher.group(2));
    }

    /**
     * Gives string in format 'namespace:id'
     *
     * @return String representation of this RegistryIdentifier
     */
    @Override
    public String toString() {
        return namespace + ":" + id;
    }
}