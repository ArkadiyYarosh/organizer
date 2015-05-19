package by.bsuir.yarosh.domain;

import javax.persistence.*;

/**
 * Created by Lemm on 16.05.2015.
 */
@Entity
@Table(name = "tbl_subscribes", schema = "", catalog = "edi_schema")
@IdClass(SubscribesPK.class)
public class Subscribes {
    private Integer primUserId;
    private Integer subsUserId;
    private Boolean isSubmitted;

    @Id
    @Column(name = "PrimUserId")
    public Integer getPrimUserId() {
        return primUserId;
    }

    public void setPrimUserId(Integer primUserId) {
        this.primUserId = primUserId;
    }

    @Id
    @Column(name = "SubsUserId")
    public Integer getSubsUserId() {
        return subsUserId;
    }

    public void setSubsUserId(Integer subsUserId) {
        this.subsUserId = subsUserId;
    }

    @Basic
    @Column(name = "IsSubmitted")
    public Boolean getIsSubmitted() {
        return isSubmitted;
    }

    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscribes that = (Subscribes) o;

        if (isSubmitted != null ? !isSubmitted.equals(that.isSubmitted) : that.isSubmitted != null) return false;
        if (primUserId != null ? !primUserId.equals(that.primUserId) : that.primUserId != null) return false;
        if (subsUserId != null ? !subsUserId.equals(that.subsUserId) : that.subsUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = primUserId != null ? primUserId.hashCode() : 0;
        result = 31 * result + (subsUserId != null ? subsUserId.hashCode() : 0);
        result = 31 * result + (isSubmitted != null ? isSubmitted.hashCode() : 0);
        return result;
    }
}
