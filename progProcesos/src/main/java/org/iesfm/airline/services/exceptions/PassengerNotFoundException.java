package org.iesfm.airline.services.exceptions;

public class PassengerNotFoundException extends Exception {


       private final String nif;

        public PassengerNotFoundException(String nif) {
            super();
            this.nif = nif;
        }

        public String getNif() {
            return nif;
        }

}

