package mas;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassroomTest {

    @Test
    public void testEquipmentsQuantity() {
        //given
        Building buildingMock = mock(Building.class);
        Classroom classroom = Classroom.createClassroom(buildingMock, "c101");
        //when
        classroom.addEquipment("computer", 10);
        classroom.addEquipment("computer", 2);
        classroom.addEquipment("printer");
        //then
        Assert.assertThat(12, IsEqual.equalTo(classroom.getQuantityOfEquipment("computer")));
        Assert.assertThat(1, IsEqual.equalTo(classroom.getQuantityOfEquipment("printer")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUniquenessOfId() {
        //given
        Building buildingMock = mock(Building.class);
        when(buildingMock.hasClassroom("c100")).thenReturn(true);
        Classroom.createClassroom(buildingMock, "c100");
        //when
        Classroom.createClassroom(buildingMock, "c100");
        // then
        fail("shouldn't create classrooms with the same id");
    }
}
