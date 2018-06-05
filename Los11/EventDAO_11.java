package Labs_OOP.Los11;

import Labs_OOP.Los10.EventEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

    public class EventDAO_11 implements Externalizable {
        private EventContainer<EventEntity> container;
        EventEntity event;
        public void setEventContainer(EventContainer<EventEntity> eventContainer){
            this.container = eventContainer;
        }


        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(container);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.container = (EventContainer<EventEntity>)in.readObject();
        }

        public EventContainer<EventEntity> getContainer() {
            return container;
        }
    }

