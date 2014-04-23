package mas;

import mas.tools.Extension;
import mas.tools.MyCalendar;
import mas.tools.Printable;
import static mas.tools.MyPrinter.*;

import java.util.*;

public class Academy extends Extension implements Printable {

    private String name;

    private Map<AcademicTitle, List<Professor>> professors = new HashMap<>();

    private List<Building> buildings = new ArrayList<>();

    public Academy(String name, Building mainBuilding) {
        if (name == null || mainBuilding == null)
            throw new NullPointerException();
        this.name = name;
        addBuilding(mainBuilding);
    }

    public void addBuilding(Building building) {
        if(building == null) throw new NullPointerException();
        if(! buildings.contains(building)) {
            buildings.add(building);
            building.addAcademy(this);
        }
    }

    public void addProfessor(Professor prof) {
        AcademicTitle academicTitle = prof.getAcademicTitle();
        List<Professor> listOfProfessors = professors.get(academicTitle);
        if(listOfProfessors == null) {
            listOfProfessors = new ArrayList<Professor>();
            professors.put(academicTitle, listOfProfessors);
        }
        if(! listOfProfessors.contains(prof)) {
            listOfProfessors.add(prof);
            prof.addToAcademy(this);
        }
    }

    public void removeProfessor(Professor prof) {
        if (prof == null) throw new NullPointerException();
        Collection<List<Professor>> values = professors.values();
        for(Iterator<List<Professor>> iterOverTitles = values.iterator(); iterOverTitles.hasNext();) {
            List<Professor> listOfProf = iterOverTitles.next();
            for (int i = 0; i < listOfProf.size(); i++) {
                if(listOfProf.get(i).equals(prof)) {
                    listOfProf.remove(i);
                    prof.removeFromAcademy(this);
                    return;
                }
            }
        }
    }
    
    public List<Professor> getProfessorsWith(AcademicTitle academicTitle) {
        List<Professor> selectedProfessors = professors.get(academicTitle);
        if(selectedProfessors == null)
            return Arrays.asList();
        return Collections.unmodifiableList(selectedProfessors);
    }

    @Override
    public String toString() {
        String buildingsStr = "";
        String professorsStr = "";
        for (Iterator<Building> i = buildings.iterator(); i.hasNext();)
            buildingsStr += i.next().getName() + ", ";

        for(Iterator<List<Professor>> i = professors.values().iterator();i.hasNext();){
           List<Professor> list = i.next();
            for(Iterator<Professor> innerIt = list.iterator(); innerIt.hasNext();) {
                Professor p = innerIt.next();
                professorsStr += p.getFirstName() + " " + p.getLastName() + ", ";
            }
        }
        return "Academy{" +
                "name='" + name + '\'' + cNl +
                "professors=" + professorsStr + nl +
                "buildings=" + buildingsStr +
                '}';
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Building b = new Building(
                new Address("Warsaw", "Koszykowa 1", "02-111"), "Budynek A");
        Academy pj = new Academy("Pjwstk", b);

        Professor p1 = new Professor("Jan", "Kowalski",
                new Address("Warsaw", "Jerozolimkie 2", "11-009"),
                MyCalendar.getBirthDate(12,1,1970),
                AcademicTitle.BSc);

        Professor p2 = new Professor("Lech", "Nowak",
                new Address("Warsaw", "Solidarnosci 3", "11-209"),
                MyCalendar.getBirthDate(22,9,1963),
                AcademicTitle.MA);

        Professor p3 = new Professor("Andrzej", "Kujawski",
                new Address("Warsaw", "Towarowa 3", "08-222"),
                MyCalendar.getBirthDate(24,6,1979),
                AcademicTitle.MA);

        pj.addProfessor(p1);
        pj.addProfessor(p2);
        pj.addProfessor(p3);

        List<Professor> selectedProf = pj.getProfessorsWith(AcademicTitle.BSc);
        System.out.println(selectedProf);

    }
}

