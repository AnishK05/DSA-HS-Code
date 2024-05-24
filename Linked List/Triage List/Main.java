class Main {
    
    public static void main(String[] args) {

        TriageList triage = new TriageList();

        triage.addPatient("Nalla",  1);
        triage.addPatient("Harsha", 3);
        triage.addPatient("Ryan",   1);
        triage.addPatient("Nisha",  3);
        triage.addPatient("Andrew", 1);
        triage.addPatient("shreya", 2);

        System.out.println(triage); // [1-Nalla, 1-Ryan, 1-Andrew, 2-shreya, 3-Harsha, 3-Nisha]


        System.out.println();
        System.out.println(triage.triageCount());      // P1:3, P2:1, P3:2
        System.out.println(triage.contains("Nalla"));  // 1
        System.out.println(triage.contains("Nisha"));  // 3
        System.out.println(triage.treatNextPatient()); // Nalla
        System.out.println(triage.contains("Nalla"));  // -1
        System.out.println(triage.treatNextPatient()); // Ryan
        System.out.println(triage.treatNextPatient()); // Andrew
        System.out.println(triage.treatNextPatient()); // Shreya

        triage.addPatient("Rithvik", 1);
        triage.addPatient("Tanvi",   2);

        System.out.println(triage); // [1-Rithvik, 2-Tanvi, 3-Harsha, 3-Nisha]
        
    }
}