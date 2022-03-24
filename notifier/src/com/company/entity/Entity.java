package com.company.entity;

public abstract class Entity {
    private Boolean isDeleted;

    public Entity(Boolean isDeleted) {
        this.isDeleted = isDeleted != null ? isDeleted : false;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "isDeleted=" + isDeleted +
                '}';
    }
}
