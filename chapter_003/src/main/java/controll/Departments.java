package controll;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class Departments implements Comparable<Departments> {
    private String mainD = "";
    private String[] serviceInfo;

    public Departments(String info) {
        String separator = "\\";
        String[] services = info.split(Pattern.quote(separator));
        this.mainD = services[0];
        serviceInfo = new String[services.length - 1];
        System.arraycopy(services, 1, serviceInfo, 0, serviceInfo.length);
    }

    public String getMainD() {
        return mainD;
    }

    public String[] getServiceInfo() {
        return serviceInfo;
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
                && Arrays.equals(serviceInfo, that.serviceInfo);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(mainD);
        result = 31 * result + Arrays.hashCode(serviceInfo);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(mainD);
        if (serviceInfo.length != 0) {
            for (String s : serviceInfo) {
                result.append("\\").append(s);
            }

        }
        return result.toString();
    }

    @Override
    public int compareTo(Departments dep) {
        int result = this.mainD.compareTo(dep.getMainD());
        if (result == 0) {
            for (int i = 0; i < serviceInfo.length; i++) {
                result = this.serviceInfo[i].compareTo(dep.getServiceInfo()[i]);
                if (result != 0) {
                    break;
                }
            }
        }
        return result;
    }

    public boolean infoIsExist() {
        if (serviceInfo.length != 0) {
            return true;
        }
        return false;
    }


}
