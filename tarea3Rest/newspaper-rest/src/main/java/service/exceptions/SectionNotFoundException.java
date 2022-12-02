package service.exceptions;

public class SectionNotFoundException extends Exception {
  private final int sectionId;


    public SectionNotFoundException(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getSectionId() {
        return sectionId;
    }
}

