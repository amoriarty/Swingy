package fr.alegent.Swingy.Models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private String name;
    private Origin origin;

    /**
     * Considered as classes in most RPG, constants defined starter player stats.
     */
    public enum Origin {
        MILQUETOAST, LONE_SURVIVOR, TROUBLE_CHILDHOOD, VIOLENT_PAST,
        PROFESSIONAL, MILITARY_VETERAN, NOBLE_SCION, CRUEL_FATE, WASTE_OF_SKIN;

        /**
         * All origins, indexed.
         */
        public static Origin[] allCases = {
                MILQUETOAST, LONE_SURVIVOR, TROUBLE_CHILDHOOD, VIOLENT_PAST,
                PROFESSIONAL, MILITARY_VETERAN, NOBLE_SCION, CRUEL_FATE, WASTE_OF_SKIN
        };

        /**
         * Human readable origins names.
         */
        public static String[] names = {
                "Milquetoast", "Lone Survivor", "Trouble Childhood", "Violent Past",
                "Professional", "Military Veteran", "Noble Scion", "Cruel Fate", "Waste of Skin"
        };

        /**
         * Descriptions of each origins.
         */
        public static String[] descriptions = {
                "Ordinary, happy upbringing. All attributes average.",
                "Lone survivor of a lost hamlet. High life essence and vigor.",
                "Suffered misfortune in youth. Highly resilient as a result.",
                "Terribly violent past. Rash, but stronger for it.",
                "Born specialist, fit for sleuthing or academia.",
                "Experienced in war. A soldier with strength and skill.",
                "Scion to a respectable line with faith in your pedigree.",
                "Faced terrible hardships, but now confident in your purpose.",
                "You are nothing. Talentless. You shouldn't have been born."
        };
    }

}
