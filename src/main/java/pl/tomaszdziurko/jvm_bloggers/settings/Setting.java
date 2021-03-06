package pl.tomaszdziurko.jvm_bloggers.settings;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "setting")
@Data
@NoArgsConstructor
public class Setting implements Serializable {

    @Id
    @GeneratedValue(generator = "SETTING_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SETTING_SEQ", sequenceName = "SETTING_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "value", nullable = false, length = 2500)
    private String value;

    public Setting(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
