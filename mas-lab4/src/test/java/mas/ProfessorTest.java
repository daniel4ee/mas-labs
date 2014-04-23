package mas;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.Mockito.mock;

public class ProfessorTest {

    @Rule public ExpectedException exception = ExpectedException.none();

    public Address addressMock = mock(Address.class);
    public Date birthdateMock = mock(Date.class);
    public AcademicTitle academicTitle = AcademicTitle.BA;

    @Test
    public void testToString() {
        Professor p1 = new Professor("a", "building", addressMock, birthdateMock, academicTitle);
        System.out.println(p1);
    }

    @Test public void testAcademicTitle() {
        //given
        AcademicTitle ba = academicTitle.BA;
        Professor professor = new Professor("a", "building", addressMock, birthdateMock, ba);
        //then
        Assert.assertThat(professor.toString(), containsString(ba.toString()));
    }
}
