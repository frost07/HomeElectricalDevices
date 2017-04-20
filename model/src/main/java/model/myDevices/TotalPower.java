package model.myDevices;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by frost on 19.04.2017.
 */
@Entity
@Table(name = "result", schema = "employees", catalog = "")
public class TotalPower {

    private int value;
    private String id;

    public TotalPower(int value, String id) {
        this.value = value;
        this.id = id;
    }

    public TotalPower() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
