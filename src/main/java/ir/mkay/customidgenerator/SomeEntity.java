package ir.mkay.customidgenerator;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SomeEntity implements Identifiable<Integer> {

    @Id
    @GenericGenerator(name = "custom_id_generator", strategy = "ir.mkay.customidgenerator.CustomIdGenerator")
    @GeneratedValue(generator = "custom_id_generator")
    private Integer id;

    private String someField;

}
