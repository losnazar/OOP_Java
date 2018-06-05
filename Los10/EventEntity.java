package Labs_OOP.Los10;

        import java.io.Serializable;
        import java.util.ArrayList;

public class EventEntity implements Serializable {
    private String date,start_time,place, info,name;
    private int duration;
    private ArrayList<String> participants;

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    public String getInfo() {
        return info;
    }

    public String getPlace() {
        return place;
    }

    public String getStart_time() {
        return start_time;
    }
}
