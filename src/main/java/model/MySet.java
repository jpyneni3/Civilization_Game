package model;
import java.util.Random;

class MySet<E> implements SimpleSet<E> {
    private Random r = new Random();
    private E[] set;
    private int arrayLen;
    private static final int INITIAL_ARRAY_LENGTH = 0;

    @SuppressWarnings("unchecked")
    public MySet() {
        set = (E[]) new Object[INITIAL_ARRAY_LENGTH];
        arrayLen = set.length;

    }
    public int getArrayLen() {
        return arrayLen;
    }
    public void setArrayLen(int e) {
        arrayLen = e;
    }
    public boolean contains(E e) {
        for (int i = 0; i < arrayLen; i++) {
            if (e.equals(set[i])) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        }
        int newLength = arrayLen + 1;
        E[] newSet = (E[]) new Object[newLength];
        for (int i = 0; i < arrayLen; i++) {
            newSet[i] = set[i];
        }
        newSet[arrayLen] = e;
        set = newSet;
        arrayLen++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E remove(E e) throws ElementDoesNotExistException {
        if (!this.contains(e)) {
            throw new ElementDoesNotExistException("This does not exist", e);
        } else {
            int indexOfE = 0; /**although it initiliazed to 0,
          *first part ensures not empty
          *next part sets correct index
          */
            for (int i = 0; i < arrayLen; i++) {
                if (e == set[i]) {
                    indexOfE = i;
                }
            }
            int newLength = arrayLen - 1; //minus because remove method
            E[] newSet = (E[]) new Object[newLength];
            for (int i = 0; i < indexOfE; i++) {
                newSet[i] = set[i];
            }
            for (int i = indexOfE; i < newLength; i++) {
                newSet[i] = set[i + 1];
            }
            E p = set[indexOfE];
            set = newSet;
            arrayLen--;
            return p;
        }
    }

    @SuppressWarnings("unchecked")
    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        int passedArrayLength = e.length;
        for (int i = 0; i < passedArrayLength; i++) {
            if (!this.contains(e[i])) {
                throw new
                ElementDoesNotExistException("This does not exist", e[i]);
            }
        }
        E[] p = (E[]) new Object[passedArrayLength];
        for (int i = 0; i < passedArrayLength; i++) {
            p[i] = this.remove(e[i]);
        }
        return p;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        E[] newSet = (E[]) new Object[INITIAL_ARRAY_LENGTH];
        set = newSet;
        setArrayLen(0);
    }
    public int size() {
        return getArrayLen();
    }
    public boolean isEmpty() {
        return (this.size() < 1);
    }
    public E getRandomElement() throws ElementDoesNotExistException {
        if (this.isEmpty()) {
            throw new ElementDoesNotExistException("Set is empty");
        }
        int rand = r.nextInt(this.size());
        return set[rand];
    }
    public E[] toArray() {
        return set;
    }
    @Override
    public String toString() {
        String s = "Your set contains: ";
        for (int i = 0; i < this.size(); i++) {
            s += set[i] + " ";
        }
        return s;
    }
}
