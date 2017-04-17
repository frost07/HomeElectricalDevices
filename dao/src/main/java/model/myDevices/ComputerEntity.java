package model.myDevices;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by frost on 15.04.2017.
 */
@Entity
@Table(name = "computer", schema = "employees", catalog = "")
public class ComputerEntity {
    private String type;
    private String name;
    private String size;
    private String color;
    private Integer power;
    private Integer sizeHdd;
    private Integer state;

    @Basic
    @Column(name = "type", nullable = true, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "size", nullable = true, length = 100)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "color", nullable = true, length = 100)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "power", nullable = true)
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Basic
    @Column(name = "sizeHDD", nullable = true)
    public Integer getSizeHdd() {
        return sizeHdd;
    }

    public void setSizeHdd(Integer sizeHdd) {
        this.sizeHdd = sizeHdd;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerEntity that = (ComputerEntity) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (power != null ? !power.equals(that.power) : that.power != null) return false;
        if (sizeHdd != null ? !sizeHdd.equals(that.sizeHdd) : that.sizeHdd != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (sizeHdd != null ? sizeHdd.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
