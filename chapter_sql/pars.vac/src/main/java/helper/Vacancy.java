package helper;

import java.util.Date;
import java.util.Objects;

/**
 * вакансия состоит из описания и даты публикации
 */
public class Vacancy {


    private String description;
    private Date date;

    public Vacancy(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(description, vacancy.description)
                && Objects.equals(date, vacancy.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date);
    }

    @Override
    public String toString() {
        return "Vacancy : \n"
                + "'" + description + "'\n"
                + " date: " + date;
    }
}
