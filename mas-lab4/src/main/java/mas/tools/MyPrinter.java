package mas.tools;

import mas.Address;
import mas.Building;

import java.lang.reflect.Field;
import java.util.*;

public class MyPrinter {

    public static final String l = System.lineSeparator();
    public static final String t = "\t";
    public static final String nl = l + t ;
    public static final String cNl = ',' + nl ;



    public static String printObject(Object object) {
        return printObject(object, 0);
    }

    public static String printObject(Object object, int offset) {

        StringBuffer sb = new StringBuffer();

        Class clazz = object.getClass();
        String header = addHeader(clazz.getSimpleName(), offset);
        sb.append(header);

        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields) {
            try {
                f.setAccessible(true);
                Object valueOfField = f.get(object);

                if(valueOfField instanceof Collection) {
                    sb.append(addFiledName(f.getName(), offset));
                    sb.append(addCollection((Collection<?>) valueOfField, offset));
                } else
                if(valueOfField.getClass().isArray()) {
                    sb.append(addFiledName(f.getName(), offset));
                    if(valueOfField instanceof int[]) {
                        String r = Arrays.toString((int[]) valueOfField);
                        sb.append(addValueOfField(r, offset));
                    } else {
                        sb.append(addValueOfField(valueOfField.toString(), offset));
                    }
                } else
                if( valueOfField instanceof Printable) {
                    sb.append(addHeader(f.getName(), offset + 1));
                    sb.append(printObject(valueOfField, offset + 2));
                } else
                {
                    sb.append(addFiledName(f.getName(), offset));
                    sb.append(addValueOfField(valueOfField.toString(), offset));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static String addHeader(String header, int offset) {
        offset++;
        String template = countTemplateForHeader(offset);
        return String.format(template, "", header + "-instance");
    }

    private static String addFiledName(String field, int offset) {
        offset++;
        String template = countTemplateForAttribute(offset);
        return String.format(template, "", field);
    }

    private static String addValueOfField(String value, int offset) {
        offset += 2;
        String template = countTemplate(offset);
        return String.format(template,"", value);
    }

    private static String addCollection(Collection<?> collection, int offset) {
        StringBuilder sb = new StringBuilder();
        for(Iterator it = collection.iterator(); it.hasNext();) {
            Object value = it.next();
            sb.append(addValueOfField(value.toString(), offset));
        }
        return sb.toString();
    }


    public static String countTemplate(int offset) {
        return countTemplateForAttribute(offset) + "%n";
    }

    public static String countTemplateForAttribute(int offset) {
        return "%" + (6*offset + 1) + "s%s";
    }

    public static String countTemplateForHeader(int offset) {
        return "%" + (3*offset + 1) + "s%s%n";
    }
 
    public static void main(String[] args) {

        Address wawa = new Address("Wawa", "Koszykowa 33", "02-88");
        Building b1 = new Building(wawa,
                "Polsko Japońska Wyższa Szkoła Technik Komputerowych");

        System.out.println(printObject(b1));
    }


}

