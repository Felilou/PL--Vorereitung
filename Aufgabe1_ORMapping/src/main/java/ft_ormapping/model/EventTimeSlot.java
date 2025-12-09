package ft_ormapping.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventTimeSlot extends AbstractPersistable<Long> {

    String slotTitle;

    String slotDescription;

    @NotNull
    @Column(name = "event_day")
    LocalDate day;

    @NotNull
    @Column(name = "event_time_from")
    Timestamp from;

    @NotNull
    @Column(name = "event_time_to")
    Timestamp to;

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST)
    Set<Student> students;

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST)
    Set<Teacher> teachers;

    @Builder
    public EventTimeSlot(String slotTitle, String slotDescription, LocalDate day, Timestamp from, Timestamp to, Set<Student> students, Set<Teacher> teachers) {
        this.slotTitle = slotTitle;
        this.slotDescription = slotDescription;
        this.day = day;
        this.from = from;
        this.to = to;
        this.students = students;
        this.teachers = teachers;
    }

    public Set<Teacher> getTeachers() {
        return Set.copyOf(teachers);
    }

    public Set<Student> getStudents() {
        return Set.copyOf(students);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
    }

}
