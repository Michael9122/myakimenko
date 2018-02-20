package ru.job4j;

import org.junit.Test;
import ru.job4j.Profession.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 21.02.2018
 * @version 1
 */
public class ProfessionTest {

    /**
     * Тест профессии доктор.
     */
    @Test
    public void whenGiveNameDoctorAndPeopleThenReturnString() {
        Doctor doctor = new Doctor();
        doctor.setName("Алексей");
        Patient patient = new Patient();
        patient.setName("Андрея");
        String result = doctor.heal(patient);
        assertThat(result, is("Доктор Алексей лечит Андрея"));
    }

    /**
     * Тест профессии Инженер.
     */
    @Test
    public void whenGiveNameTeacherAndStudentThenReturnString() {
        Engineer engineer = new Engineer();
        engineer.setName("Петрович");
        Home home = new Home();
        home.setName("Тадж-Махал");
        String result = engineer.builds(home);
        assertThat(result, is("Инженер Петрович строит Тадж-Махал"));
    }

    /**
     * Тест профессии Учитель.
     */
    @Test
    public void whenGiveNameEngineerAndHousesThenReturnString() {
        Teacher teacher = new Teacher();
        teacher.setName("Светлана");
        Student student = new Student();
        student.setName("Вадима");
        String result = teacher.teaches(student);
        assertThat(result, is("Учитель Светлана учит Вадима"));
    }
}
