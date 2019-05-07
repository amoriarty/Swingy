package fr.alegent.Swingy.Services;

public abstract class ResourceService<T> {
    public final T[] elements;

    ResourceService(String resource, Class<? extends T[]> asClass) {
        elements = JSONService.shared.get(resource, asClass);
    }
}
