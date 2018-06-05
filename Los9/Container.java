package Labs_OOP.Los9;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

    public class Container<Type> implements Serializable, Iterable<Type>, Collection<Type> {

        private Type[] m = (Type[]) new Object[1];

        private int size;

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.size() == 0;
        }

        @Override
        public boolean contains(final Object o) {
            for (int i = 0; i < size; i++) {
                if (m[i].equals(o)) return true;
            }
            return false;
        }

        @Override
        public Iterator<Type> iterator() {
            return new ElementsIterator();
        }

        @Override
        public Object[] toArray() {
            final Type[] newM = (Type[]) new Object[this.size()];
            System.arraycopy(m, 0, newM, 0, this.size());
            return newM;
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
            return (T1[]) this.toArray();
        }

        @Override
        public boolean add(final Type type) {
            if (m.length == size) {
                final Type[] oldM = m;
                m = (Type[]) new Object[this.size() * 2];
                System.arraycopy(oldM, 0, m, 0, oldM.length);
            }
            m[size++] = type;
            return true;
        }

        @Override
        public boolean remove(final Object o) {
            for (int i = 0; i < size(); i++) {
                if (m[i].equals(o)) {
                    this.remove(i);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(final Collection<?> c) {
            for (final Object item : c) {
                if (!this.contains(item)) return false;
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends Type> c) {
            return false;
        }

        @Override
        public boolean removeAll(final Collection<?> c) {
            return true;
        }

        @Override
        public boolean retainAll(final Collection<?> c) {
            return true;
        }

        @Override
        public void clear() {
            m = (Type[]) new Object[1];
            size = 0;
        }

        private void remove(final int index) {

        }

        private class ElementsIterator implements Iterator<Type> {

            private int currentIndex;

            private int last = -1;

            @Override
            public boolean hasNext() {
                return Container.this.size() > currentIndex;
            }

            @Override
            public Type next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                last = currentIndex;
                return Container.this.m[currentIndex++];
            }

            public void remove() {
                if (last == -1) {
                    throw new IllegalStateException();
                }
                Container.this.remove(last);
                currentIndex--;
                last = -1;
            }
        }

    }
