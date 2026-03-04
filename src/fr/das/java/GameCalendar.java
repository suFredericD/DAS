package fr.das.java;

import java.time.*;

public class GameCalendar {

    protected int imperiumGameStartYear;
    protected int imperiumCurrentYear;
    protected LocalDateTime earthGameStartYear;

    public GameCalendar() {
        final int startYear = 2026;
        final int startMonth = 3;
        final int starDay = 4;
        final int startHour = 16;
        final int startMinute = 18;

        this.imperiumGameStartYear = 10209;
        this.earthGameStartYear = LocalDateTime.of(startYear, startMonth, starDay, startHour, startMinute);
        this.imperiumCurrentYear = this.imperiumGameStartYear
                + (LocalDateTime.now().getYear() - this.earthGameStartYear.getYear());
    }

    // ===================================================================
    // ====================================================== GETTERS
    // ===================================================================
    public int getImperiumGameStartYear() {
        return imperiumGameStartYear;
    }

    public int getImperiumCurrentYear() {
        return imperiumCurrentYear;
    }

    public LocalDateTime getEarthGameStartYear() {
        return earthGameStartYear;
    }
}