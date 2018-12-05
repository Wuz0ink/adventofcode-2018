package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardEvents implements Comparable<GuardEvents> {

    private Date dateTime;
    private String guardEvent;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuardEvent() {
        return guardEvent;
    }

    public void setGuardEvent(String guardEvent) {
        this.guardEvent = guardEvent;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return "[" + format.format(getDateTime()) + "] " + getGuardEvent();
    }

    @Override
    public int compareTo(GuardEvents o) {
        return getDateTime().compareTo(o.getDateTime());
    }
}
