package mas;

import mas.tools.MyCalendar;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AcademyTest {

    Building building;

    Academy pj;

    Professor p1;
    Professor p2;
    Professor p3;

    @Before
    public void setUp() throws Exception {
        building = new Building(new Address("W", "S", "1"), "Main building");

        pj = new Academy("PJ", building);

        p1 = new Professor("Jan", "Kowalski",
                new Address("Warsaw", "Jerozolimkie 2", "11-009"),
                MyCalendar.getBirthDate(12,1,1970),
                AcademicTitle.BSc);
        p2 = new Professor("Lech", "Nowak",
                new Address("Warsaw", "Solidarnosci 3", "11-209"),
                MyCalendar.getBirthDate(22,9,1963),
                AcademicTitle.MA);
        p3 = new Professor("Andrzej", "Kujawski",
                new Address("Warsaw", "Towarowa 3", "08-222"),
                MyCalendar.getBirthDate(24,6,1979),
                AcademicTitle.MA);
    }

    @Test
    public void testRemovingProfessors() {
        //given
        pj.addProfessor(p1);
        pj.addProfessor(p2);
        pj.addProfessor(p3);

        int ProfWithMA = pj.getProfessorsWith(AcademicTitle.MA).size();
        int ProfWithBSc = pj.getProfessorsWith(AcademicTitle.BSc).size();
        assertThat(1, IsEqual.equalTo(ProfWithBSc));
        assertThat(2, IsEqual.equalTo(ProfWithMA));

        //when
        pj.removeProfessor(p2);
        pj.removeProfessor(p2);
        //then
        ProfWithMA = pj.getProfessorsWith(AcademicTitle.MA).size();
        ProfWithBSc = pj.getProfessorsWith(AcademicTitle.BSc).size();
        assertThat(1, IsEqual.equalTo(ProfWithBSc));
        assertThat(1, IsEqual.equalTo(ProfWithMA));
    }

    @Test
    public void testAddingTheSameProfessorTwice() {
        //when
        pj.addProfessor(p1);
        pj.addProfessor(p1);
        //then
        int profNum = pj.getProfessorsWith(AcademicTitle.BSc).size();
        assertThat(profNum, IsEqual.equalTo(1));
//        System.out.println(pj);
    }

    @Test
    public void testAddingAndRemovingProfessors() {
        //given
        pj.addProfessor(p1);
        pj.addProfessor(p2);
        p3.addToAcademy(pj);
        //when
        pj.removeProfessor(p1);
        p2.removeFromAcademy(pj);
        //then
        int profBsc = pj.getProfessorsWith(AcademicTitle.BSc).size();
        int profMA = pj.getProfessorsWith(AcademicTitle.MA).size();
        assertThat(profBsc, equalTo(0));
        assertThat(profMA, equalTo(1));
    }
}
