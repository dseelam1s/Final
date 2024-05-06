package com.example.florafauna;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlantSpeciesInfo {
    private List<String> speciesNames;
    private HashMap<String, PlantInfo> speciesInfoMap;

    public PlantSpeciesInfo() {
        speciesNames = new ArrayList<>();
        speciesNames.add("Rose");
        speciesNames.add("Sunflower");
        speciesNames.add("Oak");
        speciesNames.add("Cactus");

        speciesInfoMap = new HashMap<>();
        speciesInfoMap.put("Rose", new PlantInfo("Garden", "Least Concern", "Deciduous"));
        speciesInfoMap.put("Sunflower", new PlantInfo("Fields", "Not Evaluated", "Annual"));
        speciesInfoMap.put("Oak", new PlantInfo("Forests", "Least Concern", "Deciduous"));
        speciesInfoMap.put("Cactus", new PlantInfo("Deserts", "Least Concern", "Perennial"));
    }

    public List<String> getSpeciesNames() {
        return speciesNames;
    }

    public PlantInfo getPlantInfo(String speciesName) {
        return speciesInfoMap.get(speciesName);
    }

    public static class PlantInfo {
        private String habitat;
        private String conservationStatus;
        private String behavior;

        public PlantInfo(String habitat, String conservationStatus, String behavior) {
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
