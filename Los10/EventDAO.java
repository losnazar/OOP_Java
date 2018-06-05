package Labs_OOP.Los10;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

    public class EventDAO implements Externalizable{
        private ArrayList<EventEntity> container;
        EventEntity event;
        public EventDAO(){

        }
        public void setEventContainer(ArrayList<EventEntity> eventContainer){
/*        name = event.getName();
        date = event.getDate();
        start_time = event.getStart_time();
        place = event.getPlace();
        info = event.getPlace();
        duration = event.getDuration();
        participants = event.getParticipants();
        this.event.setName(name);
        this.event.setDate(date);
        this.event.setStart_time(start_time);
        this.event.setPlace(place);
*/
            this.container = eventContainer;
        }


        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            /*out.writeObject(name);
            out.writeObject(place);
            out.writeObject(date);
            out.writeInt(duration);
            out.writeObject(info);
            out.writeObject(start_time);*/
            out.writeObject(container);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        /*this.name = (String)in.readObject();
        this.place = (String)in.readObject();
        this.date = (String)in.readObject();
        this.duration = in.readInt();
        this.info = (String)in.readObject();
        this.start_time = (String)in.readObject();*/
            this.container = (ArrayList<EventEntity>)in.readObject();
        }

        public ArrayList<EventEntity> getContainer() {
            return container;
        }
    }

