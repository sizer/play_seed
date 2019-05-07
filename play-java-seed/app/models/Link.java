package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Links")
public class Link extends Model {
    @Id
    @Constraints.Min(10)
    public Long id;

    public String uuid;

    public static final Finder<Long, Link> find = new Finder<>(Link.class);
}

