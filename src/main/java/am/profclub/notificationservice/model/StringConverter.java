package am.profclub.notificationservice.model;


import org.bson.Document;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import com.mongodb.DBObject;

public class StringConverter extends MappingMongoConverter {

    public StringConverter(
            MongoDbFactory mongoDbFactory,
            MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext) {
        super(new DefaultDbRefResolver(mongoDbFactory), mappingContext);
    }

    @Override
    public void write(Object source, DBObject dbObject) {
        if (source instanceof byte[]) {
            dbObject.put("text", new String((byte[])source));
        } else {
            dbObject.put("text", source);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S> S read(Class<S> clazz, DBObject dbObject) {
        Document document = (Document) dbObject;
        return (S) document.get("text");
    }

}