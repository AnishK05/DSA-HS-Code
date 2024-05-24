# Instructions  
### TriageList:
This class will manage a hospital ER patient (Triage) List. Patients are placed on the list based on priority. The priority levels are 1 through 3 with 1 being the highest priority. 

Each node will be a patient and have three instance variables/attributes; String name, int priority, Node next. Patients are placed in the list first by priority with 1 being the top of the list. If there are other patients with the same priority already in the list, then the patient is placed at the end of that priority group.

For example, assume the following patients arrive at the ER in the following order.
```
NAME    PRIORITY
Nalla,  1
Harsha, 3
Ryan,   1
Nisha,  3
Andrew, 1
shreya, 2

The toString method should return, 
[1-Nalla, 1-Ryan, 1-Andrew, 2-Shreya, 3-Harsha, 3-Nisha]
```

Implement the following methods in your TriageList class
```
/**
 * Adds a Node/patient to the list by priority. 
 * Priorities are from 1 to 3 with 1 being the 
 * highest priority. Patients are placed in the 
 * list first by priority with 1 being the top 
 * of the list. If there are other patients with
 * the same priority already in the list, then 
 * the patient is placed at the end of that 
 * priority group.
 */
public void addPatient(String name, int priority)


/**
 * Removes and returns the name at the head of 
 * the list. Returns "No patients" if the list 
 * is empty.
 */
public String treatNextPatient()


/**
 * Returns the priority of the given name in 
 * the list. If the name does not exist then 
 * -1 is returned. 
 */
public int contains(String name)


/**
 * Returns a string containing the number of 
 * patients in each priority. For example. 
 * P1:3, P2:1, P3:2
 */
public String triageCount()

```
