package com.siso;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARD_PLANET,
        MOON,
        COMET,
        ASTEROID
    }


    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }



    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite){
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    /// OVERRIDING EQUALS SO IT FITS OUR HashSet
    @Override
    public final boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
            }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }




    //KEY CLASS FOR MAP KEY VALUE !
    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType){
            this.bodyType = bodyType;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())){
                return (this.bodyType == key.getBodyType());
            }
            return false;


        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }

}
