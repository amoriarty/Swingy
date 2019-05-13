package fr.alegent.Swingy.Models;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Save {
    public final String name;
    public final Player player;

    public String toString() {
        return name;
    }

}
