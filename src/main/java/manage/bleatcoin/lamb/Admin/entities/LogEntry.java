package manage.bleatcoin.lamb.Admin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class LogEntry {
    @Id
    private String date;
    private String action;
    private String info;

    public LogEntry() { }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry l = (LogEntry) o;
        return Objects.equals(getDate(), l.getDate()) &&
                Objects.equals(getAction(), l.getAction()) &&
                Objects.equals(getInfo(), l.getInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getAction(), getInfo());
    }

    @Override
    public String toString() {
        return "LogEntry {" +
                "id, date='" + date + '\'' +
                ", action='" + action + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
