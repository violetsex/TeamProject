import java.util.Random;

public class Role {
    private String name;
    private int blood;
    private char gender;
    private String face;

    // Attack descriptions:
    String[] attacksDesc = {
            "%s executed a move called [Backstab], moved behind the opponent, and struck %s's back heart point with a palm.",
            "%s performed a move called [Sky Claw], soared into the air, and transformed hands into claws to attack %s.",
            "%s shouted loudly, lowered the body, executed a move called [Thunderous Ground Smash], and pounded %s's legs.",
            "%s gathered energy in the palm, the palm turned blood-red in an instant, a move called [Palm Thunder], pushing towards %s.",
            "%s concealed the yin hand with the yang hand, a move called [Uncovered Defense], solidly pounded towards %s.",
            "%s stepped forward, deceived with a move, a move called [Cleaving Hanging Chain], attacking %s continuously."
    };
    // Injured descriptions:
    String[] injuredsDesc = {
            "As a result, %s stepped back half a step, unharmed.",
            "Resulting in a bruise for %s.",
            "The strike hit, causing %s to bend down in pain.",
            "Resulting in %s groaning in pain, obviously suffering some internal injuries.",
            "Resulting in %s swaying, stumbling and falling to the ground.",
            "Resulting in %s turning pale, taking several steps back.",
            "With a 'boom', %s spurted blood from the mouth.",
            "Resulting in %s screaming, collapsing like soft mud."
    };

    public Role(String name, int blood, char gender, int faceIndex) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setFace(gender, faceIndex);
    }

    public String getName() {
        return name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    // Add face
    public void setFace(char gender, int faceIndex) {
        String genderSymbol = (gender == '0') ? "♂" : "♀";
        switch (faceIndex) {
            case 1:
                this.face = (gender == '0') ? "Graceful and handsome" : "Exquisitely beautiful";
                break;
            case 2:
                this.face = (gender == '0') ? "Majestic and imposing" : "Alluring and enchanting";
                break;
            case 3:
                this.face = (gender == '0') ? "Handsome appearance" : "Graceful and upright";
                break;
            case 4:
                this.face = (gender == '0') ? "Well-proportioned features" : "Charming figure";
                break;
            case 5:
                this.face = "Average appearance";
                break;
            case 6:
                this.face = "In a mess";
                break;
            case 7:
                this.face = "Fierce-looking";
                break;
            default:
                this.face = "😐";
        }
        System.out.println(name + "(" + genderSymbol + this.face + ") joined the game!");
    }

    // Attack function targets the attacked
    public void attack(Role role) {
        // Randomly reduce health after an attack
        Random random = new Random();
        int damage = random.nextInt(20) + 1;
        int attackDescIndex = random.nextInt(attacksDesc.length);
        System.out.printf(attacksDesc[attackDescIndex], name, role.getName());
        System.out.println();
        role.takeDamage(damage);
    }

    // Character takes damage
    private void takeDamage(int damage) {
        blood = Math.max(0, blood - damage);
        Random random = new Random();
        int injuredDescIndex = random.nextInt(injuredsDesc.length);
        System.out.printf(injuredsDesc[injuredDescIndex], name);
        System.out.println(name + " received " + damage + " damage, remaining blood volume: " + blood);
    }

    public void showRoleInfo() {
        System.out.println("Role information:");
        System.out.println("Name: " + name);
        System.out.println("blood volume: " + blood);
        System.out.println("Gender: " + gender);
        System.out.println("Appearance: " + face);
        System.out.println("--------------");
    }
}