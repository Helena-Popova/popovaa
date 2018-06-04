package controll;

import java.util.Objects;
import java.util.regex.Pattern;

public class Departments implements Comparable<Departments> {
    private String mainD = "";
    private String service = "";
    private String separation = "";

    public Departments(String info) {
        String separator = "\\";
        String[] fill = info.split(Pattern.quote(separator));
        this.mainD = fill[0];
        if (fill.length == 3) {
            this.service = fill[1];
            this.separation = fill[2];
        } else if (fill.length == 2) {
            this.service = fill[1];
        }
    }

    public String getMainD() {
        return mainD;
    }

    public String getService() {
        return service;
    }

    public String getSeparation() {
        return separation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Departments that = (Departments) o;
        return Objects.equals(mainD, that.mainD)
                && Objects.equals(service, that.service)
                && Objects.equals(separation, that.separation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mainD, service, separation);
    }

    @Override
    public String toString() {
        if (this.separation.length() != 0) {
            return mainD + "\\" + service + "\\" + separation;
        } else if (this.service.length() != 0) {
            return mainD + "\\" + service;
        } else {
            return mainD;
        }
    }

    @Override
    public int compareTo(Departments dep) {
        int result = this.mainD.compareTo(dep.getMainD());
        if (result == 0) {
            result = this.service.compareTo(dep.getService());
            if (result == 0) {
                result = this.separation.compareTo(dep.getSeparation());
            }
        }
        return result;
    }

    public boolean infoIsExist() {
        if (this.service.length() != 0 || this.separation.length() != 0) {
            return true;
        }
        return false;
    }


}
