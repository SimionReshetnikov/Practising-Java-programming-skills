package org.lessons.task4.students;

public enum Faculty {
    GIG ("Геологии и геофизики"),
    GMF ("Горно-механический факультет"),
    GTF ("Горно-технический факультет"),
    IEF ("Инженерно-экономический факультет"),
    ZO ("Заочное обучение");

    private final String nameFaculty;

    Faculty(String nameFaculty) {

        this.nameFaculty = nameFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }
}
