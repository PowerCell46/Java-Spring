    package com.udemy.hibernateRelations.entities.OneToMany;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;


    @Entity
    @Table(name = "review")
    public class Review {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(length = 256)
        private String comment;

        // * Many reviews have the same(one) course
        @ManyToOne
        @JoinColumn(name = "course_id")
        private Course course;

        public Review() {}

        public Review(String comment) {
            this.comment = comment;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public String getComment() {
            return comment;
        }

        @Override
        public String toString() {
            return "Review{" +
                    "id=" + id +
                    ", comment='" + comment + '\'' +
                    '}';
        }
    }
