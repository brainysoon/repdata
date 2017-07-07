package cn.brainysoon.repdata.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by brainy on 17-7-5.
 */
@Entity
@Table(name = "rep", schema = "repdata", catalog = "")
public class RepEntity {
    private String id;
    private String name;
    private String label;
    private String info;
    private int size;
    private String link;
    private String extension;
    private int open;
    private Timestamp updateTime;
    private int mark;
    private int slead;

    private String userId;

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    @Basic
    @Column(name = "userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "size")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "open")
    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "mark")
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "slead")
    public int getSlead() {
        return slead;
    }

    public void setSlead(int slead) {
        this.slead = slead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepEntity repEntity = (RepEntity) o;

        if (size != repEntity.size) return false;
        if (open != repEntity.open) return false;
        if (mark != repEntity.mark) return false;
        if (slead != repEntity.slead) return false;
        if (id != null ? !id.equals(repEntity.id) : repEntity.id != null) return false;
        if (name != null ? !name.equals(repEntity.name) : repEntity.name != null) return false;
        if (label != null ? !label.equals(repEntity.label) : repEntity.label != null) return false;
        if (info != null ? !info.equals(repEntity.info) : repEntity.info != null) return false;
        if (link != null ? !link.equals(repEntity.link) : repEntity.link != null) return false;
        if (extension != null ? !extension.equals(repEntity.extension) : repEntity.extension != null) return false;
        if (updateTime != null ? !updateTime.equals(repEntity.updateTime) : repEntity.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + open;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + mark;
        result = 31 * result + slead;
        return result;
    }
}
