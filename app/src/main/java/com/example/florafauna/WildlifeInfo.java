package com.example.florafauna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WildlifeInfo {
    private List<String> speciesNames;
    private HashMap<String, WildInfo> speciesInfoMap;

    public WildlifeInfo() {
        speciesNames = new ArrayList<>();
        speciesNames.add("Tiger");
        speciesNames.add("Polar Bear");
        speciesNames.add("Elephant");
        speciesNames.add("Penguin");

        speciesInfoMap = new HashMap<>();
        speciesInfoMap.put("Tiger", new WildInfo("Dense forests", "Endangered", "Solitary and territorial"));
        speciesInfoMap.put("Polar Bear", new WildInfo("islands", "Vulnerable", "excellent swimmers and hunters"));
        speciesInfoMap.put("Elephant", new WildInfo("Savannahs", "Vulnerable to Endangered", "herbivores"));
        speciesInfoMap.put("Penguin", new WildInfo("subantarctic islands", "Least Concern to Vulnerable", "colonial breeders"));
    }

    public List<String> getSpeciesNames() {
        return speciesNames;
    }

    public WildInfo getPlantInfo(String speciesName) {
        return speciesInfoMap.get(speciesName);
    }

    public static class WildInfo {
        private String habitat;
        private String conservationStatus;
        private String behavior;

        public WildInfo(String habitat, String conservationStatus, String behavior) {
            this.habitat = habitat;
            this.conservationStatus = conservationStatus;
            this.behavior = behavior;
        }

        public String getHabitat() {
            return habitat;
        }

        public String getConservationStatus() {
            return conservationStatus;
        }

        public String getBehavior() {
            return behavior;
        }
    }
}
