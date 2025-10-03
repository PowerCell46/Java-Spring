package com.udemy.hibernateRelations.entities.OneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "instructor_details")
public class  InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "youtube_channel", length = 128)
    private String youtubeChannel = null;

    @Column(length = 45)
    private String hobby = null;

    @OneToOne(mappedBy = "instructorDetails", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}) // Refers to instructorDetails property in Instructor class
    private Instructor instructor;

    public InstructorDetails() {}

    public InstructorDetails(String youtubeChannel, String hobby) { // ! Constructor without id and relationship entry
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
