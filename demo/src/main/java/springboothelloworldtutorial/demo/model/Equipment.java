package springboothelloworldtutorial.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment {

    private long id;
    private int length;
    private int volume;
    private int thickness;

    public Equipment() {

    }

    public Equipment(int length, int volume, int thickness) {
        this.length = length;
        this.volume = volume;
        this.thickness = thickness;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "Length", nullable = false)
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

    @Column(name = "Volume", nullable = false)
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

    @Column(name = "Thickness", nullable = false)
	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
}
