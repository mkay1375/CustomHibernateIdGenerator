package ir.mkay.customidgenerator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.TableGenerator;

import java.io.Serializable;

public class CustomIdGenerator extends TableGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        if (obj instanceof Identifiable identifiable && identifiable.getId() != null) {
            return identifiable.getId();
        } else {
            return super.generate(session, obj);
        }
    }
}
