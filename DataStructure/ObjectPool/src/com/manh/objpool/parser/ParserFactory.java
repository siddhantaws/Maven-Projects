package com.manh.objpool.parser;

import com.manh.pool.BasePooledObjectFactory;
import com.manh.pool.PooledObject;
import com.manh.pool.impl.DefaultPooledObject;

/**
 * Factory to create parser object(s).
 * 
 * @author abhishek
 *
 * @param <E>
 * @param <T>
 */
public class ParserFactory<E, T> extends BasePooledObjectFactory<Parser<E, T>> {
    @Override
    public Parser<E, T> create() throws Exception {
        return new XmlParser<E, T>();
    }
    @Override
    public PooledObject<Parser<E, T>> wrap(Parser<E, T> parser) {
        return new DefaultPooledObject<Parser<E,T>>(parser);
    }
    @Override
    public void passivateObject(PooledObject<Parser<E, T>> parser) throws Exception {
        parser.getObject().reset();
    }
    @Override
    public boolean validateObject(PooledObject<Parser<E, T>> parser) {
        return parser.getObject().isValid();
    }
}
