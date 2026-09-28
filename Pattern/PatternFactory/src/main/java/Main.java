import recruiters.CharacterRecruiter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CharacterRecruiter> recruiters = List.of(
                CharacterRecruiter.forClass("warrior"),
                CharacterRecruiter.forClass("mage"),
                CharacterRecruiter.forClass("archer")
        );

        for (CharacterRecruiter recruiter : recruiters) {
            recruiter.recruit("Aragorn");
        }

        System.out.println("Total recruited: " + CharacterRecruiter.getRecruitedCount());
    }
}
