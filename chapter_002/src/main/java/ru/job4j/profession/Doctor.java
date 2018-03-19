package ru.job4j.profession;

import ru.job4j.profession.instruments.Diagnose;
import ru.job4j.profession.user.Pacient;

/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */
public class Doctor extends Profession {

    private String diagnosticPacient;

    public Doctor() {

    }

    public Doctor(String work, String forename) {
        this.position = work;
        this.name = forename;
    }

    public Diagnose heal(Pacient pacient) {
        Diagnose diagnostic = new Diagnose();
        diagnostic.isDisease(pacient.getDesiase());
        this.diagnosticPacient = diagnostic.getPrescribe();
        return diagnostic;
    }

    public String getDiagnosticPacient() {
        return this.diagnosticPacient;
    }
}
