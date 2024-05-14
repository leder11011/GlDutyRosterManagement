package org.leder11011.model;

import java.util.Comparator;

/**
 * Sorting feature for DutyRosterEntries.
 * method compare returns int:
 * -1: a before b
 * 0: a same as b
 * 1: a after b
 */
public class DateComparator implements Comparator<DutyRosterEntry> {
    //region Constants
    //endregion

    //region Attributs
    //endregion

    //region Constructors
    public DateComparator() {
    }
    //endregion

    //region Methods
    @Override
    public int compare(DutyRosterEntry a, DutyRosterEntry b) {
        return a.getDate().compareTo(b.getDate());
    }


//    endregion


}
