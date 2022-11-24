package com.zenika.soccerbetting.shared_kernel;

public class ValueObjectId<T> {

    public T id;

    protected ValueObjectId(T id) {

        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        var o = (ValueObjectId) obj;
        return this.id == o.id;

    }
}
