package by.bsuir.yarosh.domain;

import javax.persistence.*;
import java.io.*;

/**
 * Created by Lemm on 16.05.2015.
 */
public class SubscribesPK implements Serializable {
    private Integer primUserId;
    private Integer subsUserId;

    @Column(name = "PrimUserId")
    @Id
    public Integer getPrimUserId() {
        return primUserId;
    }

    public void setPrimUserId(Integer primUserId) {
        this.primUserId = primUserId;
    }

    @Column(name = "SubsUserId")
    @Id
    public Integer getSubsUserId() {
        return subsUserId;
    }

    public void setSubsUserId(Integer subsUserId) {
        this.subsUserId = subsUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscribesPK that = (SubscribesPK) o;

        if (primUserId != null ? !primUserId.equals(that.primUserId) : that.primUserId != null) return false;
        if (subsUserId != null ? !subsUserId.equals(that.subsUserId) : that.subsUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = primUserId != null ? primUserId.hashCode() : 0;
        result = 31 * result + (subsUserId != null ? subsUserId.hashCode() : 0);
        return result;
    }
}
