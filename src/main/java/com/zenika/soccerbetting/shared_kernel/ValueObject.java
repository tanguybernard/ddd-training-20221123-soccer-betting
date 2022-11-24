package com.zenika.soccerbetting.shared_kernel;

public class ValueObject<T> {

    public T value;

    protected ValueObject(T value) {

        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        var o = (ValueObject) obj;
        return this.value == o.value;

    }
}
