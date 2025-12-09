package ft_ormapping.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class InformationEvent extends AbstractPersistable<Long> {

    @NotNull
    InformationEventType type;

    @NotNull
    String name;

    @Column(name="event_description")
    String description;

    @Embedded
    Room room;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @NotNull
    Set<EventTimeSlot> slots;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @NotNull
    Set<Teacher> teachers;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @NotNull
    Set<Student> students;

    public Set<Teacher> getTeachers() {
        return Set.copyOf(teachers);
    }

    public Set<Student> getStudents() {
        return Set.copyOf(students);
    }

    public Set<EventTimeSlot> getSlots() {
        return Set.copyOf(slots);
    }

    public void addSlot(EventTimeSlot slot) {
        slots.add(slot);
        students.addAll(slot.getStudents());
        teachers.addAll(slot.getTeachers());
    }

    public void removeSlot(EventTimeSlot slot) {
        slots.remove(slot);

        slot.getTeachers().stream()
                .filter(t -> !isTeacherInEventSlots(t))
                .forEach(this::removeTeacher);

        slot.getStudents().stream()
                .filter(s -> !isStudentInEventSlots(s))
                .forEach(this::removeStudent);
    }

    private void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    private void removeStudent(Student student) {
        students.remove(student);
    }

    private boolean isTeacherInEventSlots(Teacher teacher) {
        return slots.stream().anyMatch(s -> s.getTeachers().contains(teacher));
    }

    private boolean isStudentInEventSlots(Student student) {
        return slots.stream().anyMatch(s -> s.getStudents().contains(student));
    }

}
