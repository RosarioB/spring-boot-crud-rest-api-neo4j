package com.rosariob.crud.neo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Person")
@Getter @Setter @AllArgsConstructor @ToString
public class Person {

    @Id @GeneratedValue
    private Long id;

    @Property("name")
    private String name;

    @Property("born")
    private String born;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.OUTGOING)
    private List<Roles> actorsAndRoles;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.OUTGOING)
    private List<Person> directors;
}