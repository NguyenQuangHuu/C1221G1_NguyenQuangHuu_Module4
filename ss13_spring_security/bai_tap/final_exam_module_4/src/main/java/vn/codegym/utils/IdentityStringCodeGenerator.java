package vn.codegym.utils;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class IdentityStringCodeGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
            prefix = params.getProperty("prefix");
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String queryString = String.format("select %s from %s",session.getEntityPersister(object.getClass().getName(),object)
        .getIdentifierPropertyName(),object.getClass().getSimpleName());

        List<Long> number = new ArrayList<>();
        number.add(0L);
        Query query = session.createQuery(queryString);
        for (Object o : query.list()){
            number.add(Long.parseLong(((String) o).replace(prefix+ "-","")));

        }
        Long max = Collections.max(number);
        return  prefix + "-"+String.format("%04d",(max+1));
    }
}
