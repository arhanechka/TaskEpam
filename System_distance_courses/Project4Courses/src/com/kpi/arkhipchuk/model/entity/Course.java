package com.kpi.arkhipchuk.model.entity;

/**
 * Created by Anya on 07.06.2017.
 */
public class Course {
    private int id;
    private String name;
    private int status;

    public Course() {
    }

    public Course(int id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (status != course.status) return false;
        return name.equals(course.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public static class Builder {
        Course instance = new Course();

        public Builder setId(int id, boolean isNull) {
            if (!isNull) {
                instance.setId(id);
            } else {
                instance.setId(0);
            }
            return this;
        }

        public Builder setName(String name) {
            instance.setName(name);
            return this;
        }

        public Builder setStatus(int status) {
            instance.setStatus(status);
            return this;
        }

        public Course build() {
            return instance;
        }
    }
}
