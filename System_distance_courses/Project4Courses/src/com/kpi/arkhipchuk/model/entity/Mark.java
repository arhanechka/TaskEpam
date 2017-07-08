package com.kpi.arkhipchuk.model.entity;

/**
 * Created by Anya on 07.06.2017.
 */
public enum Mark {
    A, B, C, D, E, F;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                '}';
    }
}
