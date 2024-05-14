package org.leder11011.model;

/**
 * data structure for the office resources:
 * - KTW: Krankentransport Wagen
 * - RTW: Rettungstransport Wagen
 * - NEF: Notarzteinsatz Fahrzeug
 * - BTW: Behindertentransport Wagen
 */
public enum Resource {

    //region Enumeration
    KTW(new String[]{"5-85-1", "5-85-2"}),
    RTW(new String[]{"5-83-1"}),
    NEF(new String[]{"5-82-1"}),
    BTW(new String[]{"5-19-1", "5-19-2"}),
    CONTROLCENTER(new String[]{"5-00"});
    //endregion

    //region Constants
    //endregion

    //region Attributs
    private String[] vehicles;
    //endregion

    //region Constructors
    Resource() {}

    Resource(String[] vehicles) {this.vehicles = vehicles;}
    //endregion

    //region Methods

    public String[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(String[] vehicles) {
        this.vehicles = vehicles;
    }


    //endregion

}
