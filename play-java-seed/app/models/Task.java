package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

@Entity
public class Task extends Model {
    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String name;

    public boolean done;

    @Formats.DateTime(pattern = "yyyy/MM/dd")
    public Date dueDate = new Date();

    public static final Finder<Long, Task> find = new Finder<>(Task.class);
}

