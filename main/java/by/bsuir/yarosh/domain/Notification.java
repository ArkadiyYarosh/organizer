package by.bsuir.yarosh.domain;

import javax.persistence.*;
import java.sql.*;

/**
 * Created by Lemm on 16.05.2015.
 */
@Entity
@Table(name = "tbl_notification", schema = "", catalog = "edi_schema")
public class Notification {
    private Integer notificationId;
    private Timestamp dateToNotify;

    @Id
    @Column(name = "NotificationId")
    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    @Basic
    @Column(name = "DateToNotify")
    public Timestamp getDateToNotify() {
        return dateToNotify;
    }

    public void setDateToNotify(Timestamp dateToNotify) {
        this.dateToNotify = dateToNotify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (dateToNotify != null ? !dateToNotify.equals(that.dateToNotify) : that.dateToNotify != null) return false;
        if (notificationId != null ? !notificationId.equals(that.notificationId) : that.notificationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = notificationId != null ? notificationId.hashCode() : 0;
        result = 31 * result + (dateToNotify != null ? dateToNotify.hashCode() : 0);
        return result;
    }
}
