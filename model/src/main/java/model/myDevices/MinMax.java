package model.myDevices;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by frost on 26.04.2017.
 */
@Entity
@Table(name = "minmax", schema = "employees", catalog = "")
public class MinMax {

    private int min;
    private int max;

    public MinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public MinMax() {
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
